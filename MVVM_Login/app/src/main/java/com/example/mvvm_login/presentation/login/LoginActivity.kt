package com.example.mvvm_login.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_login.R
import com.example.mvvm_login.databinding.ActivityLoginBinding
import com.example.mvvm_login.presentation.MainActivity
import com.example.mvvm_login.presentation.login.socialLoginManager.NaverLoginManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"

    private val viewModel: LoginViewModel by viewModels()
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    lateinit var naverLoginManager: NaverLoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onClickLogiunBtn()
    }

    fun onClickLogiunBtn(){
        with(binding){
            btnNaverLogin.setOnClickListener {
                this@LoginActivity.viewModel.updatePlatform("naver")
                naverLoginManager.startNaverLogin {
                    this@LoginActivity.viewModel.updateSocialToken(it)
                }
            }
        }
    }
}