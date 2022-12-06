package com.sepatu.shooees.di

import android.content.Context
import com.sepatu.shooees.data.ProductRepository
import com.sepatu.shooees.data.source.local.room.ProductDatabase
import com.sepatu.shooees.data.source.remote.retrofit.ApiConfig
import com.sepatu.shooees.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ProductRepository {
        val apiService = ApiConfig.getApiService()
        val database = ProductDatabase.getInstance(context)
        val dao = database.productsDao()
        val appExecutors = AppExecutors()

        return ProductRepository.getInstance(apiService, dao, appExecutors)
    }
}