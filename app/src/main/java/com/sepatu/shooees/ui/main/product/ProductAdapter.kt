package com.sepatu.shooees.ui.main.product

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.ProductEntity
import com.sepatu.shooees.data.source.remote.response.product.ProductData
import com.sepatu.shooees.data.source.remote.response.product.ProductDataItem
import com.sepatu.shooees.databinding.ItemProductSearchBinding
import com.sepatu.shooees.ui.detail.DetailActivity
import com.sepatu.shooees.utils.withCurrencyFormat
import java.util.Locale

class ProductAdapter(private var productList: ArrayList<String>) : ListAdapter<ProductDataItem, ProductAdapter.ProductViewHolder>(DIFF_CALLBACK), Filterable {

    var productFilterList = ArrayList<String>()

    init {
        productFilterList = productList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductSearchBinding = ItemProductSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemProductSearchBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)

        val selectProductTextView =
            holder.itemView.findViewById<TextView>(R.id.tvTitle)
        selectProductTextView.text = productFilterList[position]
    }

    class ProductViewHolder(private val binding: ItemProductSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductDataItem) {
            binding.tvTitle.text = product.name
            binding.tvPrice.text = product.price.withCurrencyFormat()
            binding.tvCategory.text = product.category.name

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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    productFilterList = productList
                } else {
                    val resultList = ArrayList<String>()
                    for (row in productList) {
                        if (row.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    productFilterList = resultList
                }

                val filterResults = FilterResults()
                filterResults.values = productFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                productFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }
}