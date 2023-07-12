package com.example.selfstudy_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.selfstudy_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 뷰 모델 가져오기
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel

        /* 관찰해 데이터 값이 변경되면 호출, this와 라이프 사이클을 공유한다. (LiveData는 자동으로 Observe 상태를 관리한다.)*/
        mainViewModel.currentValue.observe(this, Observer {
            Log.d("check", "현재 값 : $it")
            binding.tvUpdate.text = it.toString()
        })

        mainViewModel.currentValue2.observe(this, Observer {
            binding.tvSave.text = it.toString()
        })
    }
}