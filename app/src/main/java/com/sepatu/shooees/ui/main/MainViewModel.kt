package com.sepatu.shooees.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sepatu.shooees.data.entity.UserEntity
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import kotlinx.coroutines.launch

class MainViewModel(private val preference: UserPreference) : ViewModel() {

    fun getUser(): LiveData<UserEntity> =
        preference.getUser().asLiveData()

    fun logout() {
        viewModelScope.launch {
            preference.logout()
        }
    }


}