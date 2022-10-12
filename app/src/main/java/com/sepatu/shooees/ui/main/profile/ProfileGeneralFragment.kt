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
import com.sepatu.shooees.databinding.FragmentProfileGeneralBinding

class ProfileGeneralFragment : Fragment() {

    private var _binding: FragmentProfileGeneralBinding? = null
    private val binding get() = _binding!!
    private var menuList: ArrayList<ProfileMenuEntity> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileGeneralBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMenuTitle()
        showListMenu()
    }

    fun showListMenu() {
        val menuAdapter = ProfileGeneralAdapter(menuList)
        with(binding.rvProfileGeneral) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = menuAdapter
        }
    }

    fun addMenuTitle() {
        menuList = ArrayList()
        menuList.add(ProfileMenuEntity("Rate App"))
        menuList.add(ProfileMenuEntity("Privacy & Policy"))
        menuList.add(ProfileMenuEntity("Help Center"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}