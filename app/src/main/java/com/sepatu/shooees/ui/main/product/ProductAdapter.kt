package com.sepatu.shooees.ui.main.product

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ItemProductSearchBinding
import com.sepatu.shooees.ui.detail.DetailActivity
import com.sepatu.shooees.utils.withCurrencyFormat

class ProductAdapter() : ListAdapter<ProductDataItem, ProductAdapter.ProductViewHolder>(DIFF_CALLBACK) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductSearchBinding = ItemProductSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemProductSearchBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)

        holder.itemView.setOnClickListener {
            val data = ProductDataItem(
                product.id,
                product.name,
                product.price,
                product.description,
                product.category,
                product.galleries
            )

            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PRODUCT, data)
            it.context.startActivity(intent)
        }
    }

    class ProductViewHolder(private val binding: ItemProductSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductDataItem) {
            binding.tvTitle.text = product.name
            binding.tvPrice.text = product.price.withCurrencyFormat()
            binding.tvCategory.text = product.category.name

            Glide.with(itemView.context)
                .load(product.galleries[0].url)
                .into(binding.imgProduct)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<ProductDataItem> =
            object : DiffUtil.ItemCallback<ProductDataItem>() {
                override fun areItemsTheSame(
                    oldItem: ProductDataItem,
                    newItem: ProductDataItem
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: ProductDataItem,
                    newItem: ProductDataItem
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }
}