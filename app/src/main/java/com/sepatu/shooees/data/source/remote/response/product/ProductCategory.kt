package com.sepatu.shooees.data.source.remote.response.product

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductCategory(
    @field:SerializedName("name")
    val name: String
) : Parcelable
