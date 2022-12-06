package com.sepatu.shooees.data.source.remote.response.auth

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @field:SerializedName("code")
	val code: Int,

    @field:SerializedName("data")
	val userData: UserData,

    @field:SerializedName("message")
	val message: String,

    @field:SerializedName("status")
	val status: String
)
