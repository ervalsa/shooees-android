package com.sepatu.shooees.ui.main.wishlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ItemLikeBinding
import com.sepatu.shooees.ui.detail.DetailActivity

class WishlistAdapter(private val onWishClick: (ProductDataItem) -> Unit) : ListAdapter<ProductDataItem, WishlistAdapter.WishlistViewHolder>(DIFF_CALLBACK) {

    private var listLike = ArrayList<ProductEntity>()

    fun setLikeProducts(like: List<ProductEntity>?) {
        if (like == null) return
        this.listLike.clear()
        this.listLike.addAll(like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val itemLikeBinding = ItemLikeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishlistViewHolder(itemLikeBinding)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val like = listLike[position]
        holder.bind(like)
    }

    override fun getItemCount(): Int = listLike.size

    class WishlistViewHolder(private val binding: ItemLikeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(like: ProductEntity) {
            with(binding) {
                tvTitle.text = like.name
                tvPrice.text = "Rp. " + like.price.toString()

                Glide.with(itemView.context)
//                    .load(like.image)
//                    .into(imgProduct)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    itemView.context.startActivity(intent)
                }
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
                    return oldItem.name == newItem.name
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