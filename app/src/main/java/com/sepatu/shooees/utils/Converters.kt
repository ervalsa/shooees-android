package com.sepatu.shooees.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sepatu.shooees.data.source.remote.response.product.ProductCategory
import com.sepatu.shooees.data.source.remote.response.product.ProductGallery

private const val SEPARATOR = ","

class Converters {
    @TypeConverter
    fun productGalleryToString(gallery: List<ProductGallery>): String {
        return Gson().toJson(gallery)
    }

    @TypeConverter
    fun productCategoryToString(category: ProductCategory): String {
        return category.name
    }

    @TypeConverter
    fun stringToGallery(value: String): List<ProductGallery> {
        return try {
            Gson().fromJson<List<ProductGallery>>(value)
        } catch (e: Exception) {
            listOf()
        }
    }

    @TypeConverter
    fun stringToCategory(value: String): ProductCategory {
       return ProductCategory(value)
    }
}

inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)