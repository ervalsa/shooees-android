package com.sepatu.shooees.data.source.remote.response.auth

import com.google.gson.annotations.SerializedName

data class Data(

    @field:SerializedName("access_token")
    val accessToken: String,

    @field:SerializedName("token_type")
    val tokenType: String,

    @field:SerializedName("user")
    val user: User
)
