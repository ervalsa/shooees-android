package com.sepatu.shooees.ui.main.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.sepatu.shooees.R
import com.sepatu.shooees.databinding.FragmentProductBinding
import com.sepatu.shooees.utils.DataDummy

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        showListProducts()
    }

//    fun showListProducts() {
//        val products = DataDummy.generateDataProduct()
//        val productAdapter = ProductAdapter()
//        productAdapter.setListProducts(products)
//        with(binding.rvSearchProduct) {
//            layoutManager = GridLayoutManager(context, 2)
//            setHasFixedSize(true)
//            adapter = productAdapter
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}