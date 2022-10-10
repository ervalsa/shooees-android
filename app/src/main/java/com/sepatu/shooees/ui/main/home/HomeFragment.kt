package com.sepatu.shooees.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sepatu.shooees.R
import com.sepatu.shooees.databinding.FragmentHomeBinding
import com.sepatu.shooees.utils.DataDummy

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListPopularProducts()
    }

    fun showListPopularProducts() {
        val products = DataDummy.generateDataProduct()
        val productAdapter = HomeAdapter()
        productAdapter.setProducts(products)
        with(binding.rvPopularShoe) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = productAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}