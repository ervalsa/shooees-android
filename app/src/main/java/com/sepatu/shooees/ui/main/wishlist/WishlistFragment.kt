package com.sepatu.shooees.ui.main.wishlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sepatu.shooees.R
import com.sepatu.shooees.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}