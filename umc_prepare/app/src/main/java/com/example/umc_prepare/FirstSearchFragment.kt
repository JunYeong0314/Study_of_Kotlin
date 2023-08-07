package com.example.umc_prepare

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.umc_prepare.databinding.FragmentFirstSearchBinding

class FirstSearchFragment: Fragment() {
    private val binding: FragmentFirstSearchBinding by lazy {
        FragmentFirstSearchBinding.inflate(layoutInflater)
    }
    companion object{
        const val TAG = "firstSearchFragment"
        fun newInstance(): FirstSearchFragment = FirstSearchFragment()
    }
    private var searchFragment: SearchFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.etSearch.requestFocus()

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text = p0.toString()
                if (text.isNotEmpty()) {
                    addSearchFragment()
                } else {
                    removeSearchFragment()
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.ivDelete.setOnClickListener {
            binding.etSearch.text = null
        }

        binding.ivBack.setOnClickListener {
            hideKeyboard()
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root
    }

    private fun addSearchFragment() {
        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance()
            childFragmentManager.beginTransaction()
                .replace(R.id.fv_first_search, searchFragment!!, SearchFragment.TAG)
                .commitAllowingStateLoss()
        }
    }

    private fun removeSearchFragment() {
        if (searchFragment != null) {
            childFragmentManager.beginTransaction()
                .remove(searchFragment!!)
                .commitAllowingStateLoss()
            searchFragment = null
        }
    }

    private fun hideKeyboard(){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireActivity().window.decorView.applicationWindowToken, 0)
    }

}