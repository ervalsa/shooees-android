package com.sepatu.shooees.data.source.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sepatu.shooees.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    fun getUser(): Flow<UserEntity> {
        return dataStore.data.map { preferences ->
            UserEntity(
                preferences[NAME_KEY] ?:"",
                preferences[EMAIL_KEY] ?:"",
                preferences[USERNAME_KEY] ?:"",
                preferences[PHONE_KEY] ?:"",
                preferences[TOKEN_KEY] ?:"",
                preferences[LOGIN_STATE_KEY] ?:false,
            )
        }
    }

    suspend fun login() {
        dataStore.edit { preferences ->
            preferences[LOGIN_STATE_KEY] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences[LOGIN_STATE_KEY] = false
            preferences.remove(LOGIN_STATE_KEY)
        }
    }

    suspend fun saveUser(user: UserEntity) {
        dataStore.edit { preferences ->
            preferences[NAME_KEY] = user.name
            preferences[EMAIL_KEY] = user.email
            preferences[USERNAME_KEY] = user.username
            preferences[PHONE_KEY] = user.phone.toString()
            preferences[TOKEN_KEY] = user.token
            preferences[LOGIN_STATE_KEY] = user.isLogin
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val NAME_KEY = stringPreferencesKey("name")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val USERNAME_KEY = stringPreferencesKey("username")
        private val PHONE_KEY = stringPreferencesKey("phone")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val LOGIN_STATE_KEY = booleanPreferencesKey("login_state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}