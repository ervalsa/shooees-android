package com.sepatu.shooees.data.source.remote.retrofit

import com.sepatu.shooees.data.source.remote.response.auth.AuthResponse
import com.sepatu.shooees.data.source.remote.response.product.ProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<AuthResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<AuthResponse>

    @GET("products")
    fun listProducts() : Call<ProductResponse>
}