package com.sepatu.shooees.data.source.remote.response.product

import com.google.gson.annotations.SerializedName

data class ProductCategory(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String
)
