package com.sepatu.shooees.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ActivityDetailBinding
import com.sepatu.shooees.ui.checkout.CheckoutActivity
import com.sepatu.shooees.utils.withCurrencyFormat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODUCT = "extra_product"
    }

    private lateinit var binding: ActivityDetailBinding
    private var product: ProductDataItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        product = intent.getParcelableExtra(EXTRA_PRODUCT)
        populateProduct()

        binding.btnBuy.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun populateProduct() {
        binding.tvTitleProduct.text = product?.name
        binding.tvPrice.text = product?.price?.withCurrencyFormat()
        binding.tvDescription.text = product?.description
        binding.tvCategory.text = product?.category?.name
        Glide.with(binding.root)
            .load(product?.galleries?.get(0)?.url)
            .into(binding.imgProduct)
    }
}