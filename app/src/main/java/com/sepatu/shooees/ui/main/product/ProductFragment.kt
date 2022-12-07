package com.sepatu.shooees.ui.main.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepatu.shooees.R
import com.sepatu.shooees.data.Result.*
import com.sepatu.shooees.databinding.FragmentProductBinding
import com.sepatu.shooees.ui.ProductModelFactory
import com.sepatu.shooees.ui.main.home.HomeViewModel
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

        val factory: ProductModelFactory = ProductModelFactory.getInstance(requireActivity())
        val homeViewModel: HomeViewModel by viewModels {
            factory
        }

        val productAdapter = ProductAdapter()

        homeViewModel.getProducts().observe(viewLifecycleOwner) { result ->
            if (result != null) {
                when(result) {
                    is Loading -> {
                        showLoading(true)
                    }

                    is Success -> {
                        showLoading(false)
                        val productsData = result.data
                        productAdapter.submitList(productsData)
                    }

                    is Error -> {
                        showLoading(false)
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.rvSearchProduct.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = productAdapter
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}