package com.sepatu.shooees.data.source.remote.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

//class ApiConfig {
//
//    companion object {
//
//        fun getApiService(): ApiService {
//            val loggingInterceptor =
//                HttpLoggingInterceptor().setLevel(
//                    HttpLoggingInterceptor.Level.BODY
//                )
//
//
//            val client = OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .build()
//
//            val retrofit = Retrofit.Builder()
////                .baseUrl()
//
////            return retrofit.create
//        }
//    }
//}