package com.example.mvvm_login.presentation.login

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _isNaverLogin = MutableLiveData<Boolean>()
    private val _socialToken = MutableLiveData<String>()

    val isNaverLogin: LiveData<Boolean>
        get() = _isNaverLogin
    val socialToken: LiveData<String>
        get() = _socialToken

    init {
        _isNaverLogin.value = false
        _socialToken.value = ""
    }

    fun updatePlatform(platform: String){
        if(platform == "naver"){
            _isNaverLogin.value = true
        }
    }

    fun updateSocialToken(token: String){
        _socialToken.value = token
    }




}