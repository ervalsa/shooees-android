package com.sepatu.shooees.ui.main.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepatu.shooees.R
import com.sepatu.shooees.databinding.FragmentCartBinding
import com.sepatu.shooees.utils.DataDummy

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListCart()
    }

    fun showListCart() {
        val carts = DataDummy.generateDataCart()
        val cartAdapter = CartAdapter()
        cartAdapter.setCartProducts(carts)
        with(binding.rvCart) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = cartAdapter
        }
    }
}