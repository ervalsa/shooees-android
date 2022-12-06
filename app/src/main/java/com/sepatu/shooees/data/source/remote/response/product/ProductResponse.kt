package com.sepatu.shooees.data.source.remote.response.product

import com.google.gson.annotations.SerializedName
import com.sepatu.shooees.data.source.remote.response.auth.UserData

data class ProductResponse(
    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("data")
    val productData: ProductData,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: String
)
