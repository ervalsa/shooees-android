package com.sepatu.shooees.ui.main.home

import androidx.lifecycle.ViewModel
import com.sepatu.shooees.data.ProductRepository
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem

class HomeViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun getProducts() = productRepository.getProducts()

    fun getWishedProducts() = productRepository.getWishedProducts()

    fun saveProducts(products: ProductDataItem) {
        productRepository.setWishedProducts(products, true)
    }

    fun deleteProducts(products: ProductDataItem) {
        productRepository.setWishedProducts(products, false)
    }
}