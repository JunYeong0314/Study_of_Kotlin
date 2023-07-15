package com.example.seoulparkinfoex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seoulparkinfoex.databinding.ActivityMainBinding
import com.example.seoulparkinfoex.seoulParkApi.RetrofitApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val parkAdapter: SeoulParkAdapter by lazy {
        SeoulParkAdapter()
    }
    // Hilt가 mainViewModel을 초기화 시켜준다
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 어뎁터 연결
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = parkAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        // api로부터 데이터 받아오는 retrofitLoad() 수행
        mainViewModel.retrofitLoad()
        // observe를 통해 데이터 변경을 감지
        mainViewModel.response.observe(this, Observer {Row->
            Row?.let {
                // 응답이 온다면 ProgressBar 숨기기
                binding.pbMain.visibility = View.INVISIBLE
                // 데이터 갱신
                parkAdapter.submitList(it)
            }
        })
    }

}