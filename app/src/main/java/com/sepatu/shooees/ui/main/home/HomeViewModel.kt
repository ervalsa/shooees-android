package com.sepatu.shooees.ui.main.home

import androidx.lifecycle.ViewModel
import com.sepatu.shooees.data.ProductRepository

class HomeViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun getProducts() = productRepository.getProducts()
}