package com.sepatu.shooees.data.source.remote.response.product

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductGallery(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("products_id")
    val productsId: Int,

    @field:SerializedName("url")
    val url: String
) : Parcelable
