package com.example.temp.socialLoginManager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.temp.KeywordActivity
import com.example.temp.PlatformManager
import com.example.temp.R
import com.example.temp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivitiy: AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var naverLoginManager: NaverLoginManager

    private val viewModel: LoginViewModel by viewModels()
    val TAG = "LoginActivity"

    companion object{
        private const val NAVER = "naver"
        private const val KAKAO = "kakao"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(binding.root)

        onClickLogin()

        viewModel.token.observe(this@LoginActivitiy, Observer {
            if(it != ""){
                moveKeywordActivity()
                finish()
            }
        })
    }

    private fun onClickLogin(){
        with(binding){
            ibtnNaver.setOnClickListener {
                PlatformManager.setPlatform(NAVER)
                naverLoginManager.startLogin {
                    this@LoginActivitiy.viewModel.updateSocialToken(it)
                }
            }
        }
    }

    private fun moveKeywordActivity(){
        val intent = Intent(this@LoginActivitiy, KeywordActivity::class.java)
        startActivity(intent)
    }


}