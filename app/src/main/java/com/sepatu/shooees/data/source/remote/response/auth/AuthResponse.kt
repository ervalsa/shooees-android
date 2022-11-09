package com.sepatu.shooees.data.source.remote.response.auth

import com.google.gson.annotations.SerializedName
import com.sepatu.shooees.data.source.remote.response.auth.Data

data class AuthResponse(

    @field:SerializedName("code")
	val code: Int,

    @field:SerializedName("data")
	val data: Data,

    @field:SerializedName("message")
	val message: String,

    @field:SerializedName("status")
	val status: String
)
