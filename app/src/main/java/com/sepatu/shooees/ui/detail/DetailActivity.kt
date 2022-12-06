package com.sepatu.shooees.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.CartEntity
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


    }
}