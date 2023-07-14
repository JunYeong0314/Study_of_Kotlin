package com.example.seoulparkinfoex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seoulparkinfoex.databinding.ActivityMainBinding
import com.example.seoulparkinfoex.seoulParkApi.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val parkAdapter: SeoulParkAdapter by lazy {
        SeoulParkAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = parkAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        load()

    }

    fun load(){
        val service = RetrofitApi.seoulParkService
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getDataCoroutine(Constants.park_api_key)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    binding.pbMain.visibility = View.INVISIBLE
                    val result = response.body()?.getParkInfo?.row
                    result?.let{
                        parkAdapter.submitList(it)
                    }
                }else{
                    Log.d("TAG", response.code().toString())
                }
            }
        }

    }

}