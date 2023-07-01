package com.example.umc_prepare

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)
{
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListFragment()
            1 -> HomeFragment()
            2 -> MypageFragment()
            else -> HomeFragment()
        }
    }

}