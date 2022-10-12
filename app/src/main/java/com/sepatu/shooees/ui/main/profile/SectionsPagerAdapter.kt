package com.sepatu.shooees.ui.main.profile

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: Fragment) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = ProfileAccountFragment()
            1 -> fragment = ProfileGeneralFragment()
        }

        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }

}