package com.sepatu.shooees.ui.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepatu.shooees.data.Result
import com.sepatu.shooees.data.Result.Loading
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.databinding.FragmentHomeBinding
import com.sepatu.shooees.ui.ProductModelFactory
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.main.MainViewModel
import com.sepatu.shooees.ui.main.product.ProductAdapter

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
        val factory: ProductModelFactory = ProductModelFactory.getInstance(requireActivity())
        val homeViewModel: HomeViewModel by viewModels {
            factory
        }

        val productsAdapter = AllProductAdapter()
        val popularAdapter = PopularProductAdapter()

        mainViewModel.getUser().observe(viewLifecycleOwner) { user ->
            if (user.isLogin) {
                binding.tvNameUser.text = "${user.name}"

                homeViewModel.getProducts().observe(viewLifecycleOwner) { result ->
                    if (result != null) {
                        when(result) {
                            is Result.Loading -> {

                            }

                            is Result.Success -> {
                                val productsData = result.data
                                productsAdapter.submitList(productsData)
                                popularAdapter.submitList(productsData)
                            }

                            is Result.Error -> {

                            }
                        }
                    }
                }
            }
        }

        binding.rvAllShoe.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = productsAdapter
        }

        binding.rvPopularShoe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = popularAdapter
        }
    }

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