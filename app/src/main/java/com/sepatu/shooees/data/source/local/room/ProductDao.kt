package com.sepatu.shooees.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getProducts(): LiveData<List<ProductDataItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProducts(products: List<ProductDataItem>)

    @Update
    fun updateProducts(products: ProductDataItem)

    @Query("DELETE FROM products")
    fun deleteAll()
}