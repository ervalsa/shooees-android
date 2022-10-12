package com.sepatu.shooees.ui.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepatu.shooees.R
import com.sepatu.shooees.data.entity.ProfileMenuEntity
import com.sepatu.shooees.databinding.FragmentProfileAccountBinding

class ProfileAccountFragment : Fragment() {

    private var _binding: FragmentProfileAccountBinding? = null
    private val binding get() = _binding!!
    private var menuList: ArrayList<ProfileMenuEntity> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileAccountBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMenuTitle()
        showListMenu()
    }

    fun showListMenu() {
        val menuAdapter = ProfileAccountAdapter(menuList)
        with(binding.rvProfileAccount) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = menuAdapter
        }
    }

    fun addMenuTitle() {
        menuList = ArrayList()
        menuList.add(ProfileMenuEntity("Edit Profile"))
        menuList.add(ProfileMenuEntity("Address"))
        menuList.add(ProfileMenuEntity("Your Orders"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}