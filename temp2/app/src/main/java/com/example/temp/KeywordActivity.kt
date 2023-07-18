package com.example.temp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.temp.databinding.ActivityKeywordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KeywordActivity: AppCompatActivity() {
    lateinit var binding: ActivityKeywordBinding
    private val keywordViewModel: KeywordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_keyword)
        keywordViewModel.updateUserdata()
        Log.d("KeywordActivity", "onCreate")

        // 데이터 변경 감지
        keywordViewModel.userData.observe(this, Observer {
            binding.tvName.text = it.name + "님이 지원을 희망하는"
        })
    }
}