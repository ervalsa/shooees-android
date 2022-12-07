package com.sepatu.shooees.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.sepatu.shooees.data.source.local.room.ProductDao
import com.sepatu.shooees.data.source.remote.response.product.ProductCategory
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.data.source.remote.response.product.ProductResponse
import com.sepatu.shooees.data.source.remote.retrofit.ApiService
import com.sepatu.shooees.utils.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository private constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao,
    private val appExecutors: AppExecutors
){
    private val result = MediatorLiveData<Result<List<ProductDataItem>>>()

    fun getProducts(): LiveData<Result<List<ProductDataItem>>> {
        result.value = Result.Loading

        val client = apiService.listProducts()
        client.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.productData?.data
                    val productsList = ArrayList<ProductDataItem>()
                    appExecutors.diskIO.execute {
                        products?.forEach { product ->
                            val isWished = productDao.isProductsWished(product.name)
                            val shoeProducts = ProductDataItem(
                                product.id,
                                product.name,
                                product.price,
                                product.description,
                                product.category,
                                product.galleries,
                                isWished
                            )
                            productsList.add(shoeProducts)
                        }
                        productDao.deleteAll()
                        productDao.insertProducts(productsList)
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                result.value = Result.Error(t.message.toString())
            }
        })

        val localData = productDao.getProducts()
        result.addSource(localData) { newData: List<ProductDataItem> ->
            result.value = Result.Success(newData)
        }

        return result
    }

    fun getWishedProducts(): LiveData<List<ProductDataItem>> {
        return productDao.getWishedProducts()
    }

    fun setWishedProducts(products: ProductDataItem, wishState: Boolean) {
        appExecutors.diskIO.execute {
            products.isWished = wishState
            productDao.updateProducts(products)
        }
    }

    companion object {
        @Volatile
        private var instance: ProductRepository? = null

        fun getInstance(
            apiService: ApiService,
            productDao: ProductDao,
            appExecutors: AppExecutors
        ): ProductRepository =
            instance ?: synchronized(this) {
                instance ?: ProductRepository(apiService, productDao, appExecutors)
            }.also { instance = it }
    }
}