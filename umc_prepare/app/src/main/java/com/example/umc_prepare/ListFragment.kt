package com.example.umc_prepare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_prepare.databinding.FragmentListBinding

class ListFragment: Fragment() {
    private lateinit var viewBinding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentListBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}