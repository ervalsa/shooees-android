package com.sepatu.shooees.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sepatu.shooees.data.ProductRepository
import com.sepatu.shooees.di.Injection
import com.sepatu.shooees.ui.main.home.HomeViewModel

class ProductModelFactory private constructor (private val productRepository: ProductRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(productRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ProductModelFactory? = null

        fun getInstance(context: Context): ProductModelFactory =
            instance ?: synchronized(this) {
                instance ?: ProductModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}