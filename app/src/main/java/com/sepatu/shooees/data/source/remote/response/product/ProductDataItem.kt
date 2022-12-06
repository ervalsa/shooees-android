package com.sepatu.shooees.data.source.remote.response.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ProductDataItem(

    @field:ColumnInfo(name = "id")
    @field:PrimaryKey
    @field:SerializedName("id")
    val id: Int,

    @field:ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name: String,

    @field:ColumnInfo(name = "price")
    @field:SerializedName("price")
    val price: String,

    @field:ColumnInfo(name = "description")
    @field:SerializedName("description")
    val description: String,

    @field:ColumnInfo(name = "category")
    @field:SerializedName("category")
    val category: ProductCategory,

    @field:ColumnInfo(name = "galleries")
    @field:SerializedName("galleries")
    val galleries: List<ProductGallery>,
)
