package com.sepatu.shooees.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.utils.Converters

@Database(entities = [ProductDataItem::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductDao

    companion object {
        @Volatile
        private var instance: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java, "Product.db"
                ).build()
            }
    }
}