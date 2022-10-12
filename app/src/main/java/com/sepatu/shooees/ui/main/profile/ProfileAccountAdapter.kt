package com.sepatu.shooees.ui.main.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sepatu.shooees.data.entity.ProfileMenuEntity
import com.sepatu.shooees.databinding.ItemProfileMenuBinding

class ProfileAccountAdapter(private val listData: List<ProfileMenuEntity>) : RecyclerView.Adapter<ProfileAccountAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemProfileMenuBinding = ItemProfileMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(itemProfileMenuBinding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    class ProfileViewHolder(private val binding: ItemProfileMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: ProfileMenuEntity) {
            with(binding) {
                tvTitle.text = menu.title
            }
        }
    }
}