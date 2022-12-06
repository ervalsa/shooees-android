package com.sepatu.shooees.ui.main.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.sepatu.shooees.R
import com.sepatu.shooees.data.source.local.datastore.UserPreference
import com.sepatu.shooees.databinding.FragmentProfileBinding
import com.sepatu.shooees.ui.ViewModelFactory
import com.sepatu.shooees.ui.login.LoginActivity
import com.sepatu.shooees.ui.main.MainViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = parentFragment?.let { SectionsPagerAdapter(it) }
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        setupViewModel()

        mainViewModel.getUser().observe(requireActivity()) { user ->
            binding.tvName.text = user.name
            binding.tvUsername.text = user.username
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireActivity()).apply {
                setTitle("Ingin keluar aplikasi?")
                setMessage("Apakah Anda yakin ingin mengeluarkan akun dari aplikasi?")
                setNegativeButton("Tidak jadi") {_, _ ->

                }
                setPositiveButton("Yakin") { _, _ ->
                    val intent = Intent(requireActivity(), LoginActivity::class.java)
                    startActivity(intent)
                    mainViewModel.logout()
                    requireActivity().finish()
                }
                create()
                show()
            }
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                UserPreference.getInstance(requireContext().dataStore))
        )[MainViewModel::class.java]
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}