package com.sepatu.shooees.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.databinding.ActivityDetailBinding
import com.sepatu.shooees.utils.DataDummy

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            val productId = extras.getInt(EXTRA_DATA)
            for (product in DataDummy.generateDataProduct()) {
                if (product.id == productId) {
                    populateData(product)
                }
            }
        }
    }

    fun populateData(productEntity: ProductEntity) {
        binding.tvTitleProduct.text = productEntity.name
        binding.tvCategory.text = productEntity.category
        binding.tvPrice.text = productEntity.price.toString()
        binding.tvDescription.text = productEntity.description

        Glide.with(this)
            .load(productEntity.image)
            .into(binding.imgProduct)
    }
}