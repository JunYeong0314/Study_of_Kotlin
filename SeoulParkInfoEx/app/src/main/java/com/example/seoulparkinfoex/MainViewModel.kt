package com.example.seoulparkinfoex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seoulparkinfoex.seoulParkApi.RetrofitApi
import com.example.seoulparkinfoex.seoulParkApi.Row
import com.example.seoulparkinfoex.seoulParkApi.SeoulPark
import com.example.seoulparkinfoex.seoulParkApi.SeoulParkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val seoulParkService: SeoulParkService): ViewModel() {
    private val _response = MutableLiveData<List<Row?>>()

    val response: LiveData<List<Row?>>
        get() = _response

    fun retrofitLoad(){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                val parkResponse = seoulParkService.getDataCoroutine(Constants.park_api_key)
                if(parkResponse.isSuccessful){
                    _response.value = parkResponse.body()?.getParkInfo?.row
                }else{
                    _response.value = null
                }
            }
            Log.d("View", "success")
        }
    }


}