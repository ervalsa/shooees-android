package com.sepatu.shooees.data.source.remote.response.product

import com.google.gson.annotations.SerializedName

data class ProductData (

    @field:SerializedName("data")
    val data: List<ProductDataItem>,
)
