package com.sepatu.shooees.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sepatu.shooees.data.entity.UserEntity
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import kotlinx.coroutines.launch

class LoginViewModel(private val preferences: UserPreference) : ViewModel() {

    fun getUser(): LiveData<UserEntity> =
        preferences.getUser().asLiveData()

    fun saveUser(user: UserEntity) {
        viewModelScope.launch {
            preferences.saveUser(user)
        }
    }
}