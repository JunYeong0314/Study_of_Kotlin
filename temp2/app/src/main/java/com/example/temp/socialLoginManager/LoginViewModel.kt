package com.example.temp.socialLoginManager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.temp.PlatformManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val naverLoginManager: NaverLoginManager
): ViewModel() {

    private val _token = MutableLiveData<String>()

    val token: LiveData<String>
        get() = _token

    fun updateSocialToken(Token: String){
        _token.value = Token
    }

}