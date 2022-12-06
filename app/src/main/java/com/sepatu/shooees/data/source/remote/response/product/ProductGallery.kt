package com.sepatu.shooees.data.source.remote.response.product

import com.google.gson.annotations.SerializedName

data class ProductGallery(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("products_id")
    val productsId: Int,

    @field:SerializedName("url")
    val url: String
)
