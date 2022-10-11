package com.sepatu.shooees.ui.main.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.databinding.ItemProductSearchBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var listProducts = ArrayList<ProductEntity>()

    fun setListProducts(product: List<ProductEntity>?) {
        if (product == null) return
        this.listProducts.clear()
        this.listProducts.addAll(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductSearchBinding = ItemProductSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemProductSearchBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = listProducts[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = listProducts.size

    class ProductViewHolder(private val binding: ItemProductSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductEntity) {
            with(binding) {
                tvTitle.text = product.name
                tvPrice.text = "Rp. " + product.price.toString()
                tvCategory.text = product.category

                Glide.with(itemView.context)
                    .load(product.image)
                    .into(imgProduct)

                itemView.setOnClickListener {

                }
            }
        }
    }
}