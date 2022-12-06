package com.sepatu.shooees.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.ui.login.LoginViewModel
import com.sepatu.shooees.ui.main.MainViewModel

class ViewModelFactory(
    private val preference: UserPreference
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(preference) as T
            }

            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(preference) as T
            }

            else -> throw IllegalArgumentException("Unkown ViewModel class: " + modelClass.name)
        }
    }
}