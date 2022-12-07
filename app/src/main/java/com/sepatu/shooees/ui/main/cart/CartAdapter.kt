package com.sepatu.shooees.ui.main.cart

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sepatu.shooees.data.entity.CartEntity
import com.sepatu.shooees.databinding.ItemCartBinding
import com.sepatu.shooees.ui.detail.DetailActivity

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var listCart =  ArrayList<CartEntity>()

    fun setCartProducts(cart: List<CartEntity>?) {
        if (cart == null) return
        this.listCart.clear()
        this.listCart.addAll(cart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemCartBinding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(itemCartBinding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = listCart[position]
        holder.bind(cart)
    }

    override fun getItemCount(): Int = listCart.size

    class CartViewHolder(private val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cart: CartEntity) {
            with(binding) {
                tvTitle.text = cart.name
                tvPrice.text = "Rp. " + cart.price.toString()

                Glide.with(itemView.context)
                    .load(cart.image)
                    .into(imgProduct)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}