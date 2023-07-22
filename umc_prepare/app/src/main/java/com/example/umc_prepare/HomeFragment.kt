package com.example.umc_prepare

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.umc_prepare.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        bottomNavigationView = requireActivity().findViewById(R.id.nav_bottom)
        binding.ivSearch.setOnClickListener {
            showFragment(SearchFragment.newInstance(), SearchFragment.TAG)
            bottomNavigationView.isGone = true
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("HOME", "onResume")
        bottomNavigationView.isVisible = true
    }

    fun showFragment(fragment: Fragment, tag: String){
        val transaction: FragmentTransaction =
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.horizon_enter_front,
                    R.anim.none,
                    R.anim.none,
                    R.anim.horizon_exit_front
                )
                .remove(this)
                .add(R.id.fl_main, fragment, tag)
        transaction.addToBackStack(tag).commitAllowingStateLoss()
    }


}