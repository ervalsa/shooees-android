package com.sepatu.shooees.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.databinding.FragmentHomeBinding
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.main.MainViewModel
import com.sepatu.shooees.utils.DataDummy
import kotlin.math.log

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
//        showListAllProducts()
//        showListPopularProducts()

        mainViewModel.getUser().observe(viewLifecycleOwner) { user ->
            if (user.isLogin) {
                binding.tvNameUser.text = "${user.name}"
                Log.d(TAG, "${user.name}")
            }
        }
    }

//    fun showListPopularProducts() {
//        val products = DataDummy.generateDataProduct()
//        val productAdapter = PopularProductAdapter()
//        productAdapter.setPopularProducts(products)
//        with(binding.rvPopularShoe) {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            setHasFixedSize(true)
//            adapter = productAdapter
//        }
//    }
//
//    fun showListAllProducts() {
//        val products = DataDummy.generateDataProduct()
//        val productAdapter = AllProductAdapter()
//        productAdapter.setAllProducts(products)
//        with(binding.rvAllShoe) {
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            adapter = productAdapter
//        }
//    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(
                UserPreference
                    .getInstance(requireContext().dataStore)
            )
        )[MainViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private val TAG = "HomeFragment"
    }
}