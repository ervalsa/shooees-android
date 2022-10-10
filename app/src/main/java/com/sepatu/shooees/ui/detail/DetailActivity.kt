package com.sepatu.shooees.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val extra_data = "EXTRA_DATA"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun populate(productEntity: ProductEntity) {

    }
}