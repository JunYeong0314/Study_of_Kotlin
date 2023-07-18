package com.example.temp.socialLoginManager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _token = MutableLiveData<String>()
    companion object{
        const val TAG = "LoginViewModel"
    }

    val token: LiveData<String>
        get() = _token

    fun updateSocialToken(Token: String){
        _token.value = Token
        Log.d(TAG, "token:${Token}")
    }

}