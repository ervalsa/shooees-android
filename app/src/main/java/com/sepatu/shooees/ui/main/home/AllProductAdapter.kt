package com.sepatu.shooees.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ItemProductsBinding
import com.sepatu.shooees.ui.detail.DetailActivity
import com.sepatu.shooees.utils.withCurrencyFormat

class AllProductAdapter : ListAdapter<ProductDataItem, AllProductAdapter.AllProductViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllProductViewHolder {
        val binding = ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllProductViewHolder, position: Int) {
        val products = getItem(position)
        holder.bind(products)

        holder.itemView.setOnClickListener {
            val data = ProductDataItem(
                products.id,
                products.name,
                products.price,
                products.description,
                products.category,
                products.galleries,
                products.isWished
            )

            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PRODUCT, data)
            it.context.startActivity(intent)
        }
    }

    class AllProductViewHolder(val binding: ItemProductsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(products: ProductDataItem) {
            binding.tvTitle.text = products.name
            binding.tvCategory.text = products.category.name
            binding.tvPrice.text = products.price.withCurrencyFormat()
            Glide.with(itemView.context)
                .load(products.galleries[0].url)
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