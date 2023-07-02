package com.example.umc_prepare

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)
{
    private val fragments = listOf(
        ListFragment(),
        HomeFragment(),
        MypageFragment()
    )
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
    override fun getItemCount(): Int{
        return fragments.size
    }

}