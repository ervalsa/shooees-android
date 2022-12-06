package com.sepatu.shooees.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ItemPopularProductsBinding
import com.sepatu.shooees.ui.detail.DetailActivity
import com.sepatu.shooees.utils.withCurrencyFormat

class PopularProductAdapter : ListAdapter<ProductDataItem, PopularProductAdapter.PopularProductViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularProductViewHolder {
        val itemProductBinding = ItemPopularProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularProductViewHolder(itemProductBinding)
    }

    override fun onBindViewHolder(holder: PopularProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class PopularProductViewHolder(val binding: ItemPopularProductsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductDataItem) {
            binding.tvTitle.text = product.name
            binding.tvCategory.text = product.category.name
            binding.tvPrice.text = product.price.withCurrencyFormat()
            Glide.with(itemView.context)
                .load(product.galleries[0].url)
                .into(binding.imgProduct)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, product.id)
                itemView.context.startActivity(intent)
            }
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