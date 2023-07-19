package com.example.temp.present.views.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.temp.databinding.ActivityLoginBinding
import com.example.temp.present.views.keyword.KeywordActivity

import com.example.temp.present.config.PlatformManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivitiy: AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    // LoginManager 주입받기
    @Inject
    lateinit var naverLoginManager: NaverLoginManager
    @Inject
    lateinit var kakaoLoginManager: KakaoLoginManager

    private val viewModel: LoginViewModel by viewModels()
    val TAG = "LoginActivity"

    companion object{
        private const val NAVER = "naver"
        private const val KAKAO = "kakao"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 클릭이벤트
        onClickLogin()

        // observe를 통해 토큰 값 변경 감지
        viewModel.token.observe(this@LoginActivitiy, Observer {
            if(it != ""){
                moveKeywordActivity()
                finish()
            }
        })

        // 텍스트 스타일 변경
        val builder = SpannableStringBuilder(binding.tvExplan.text.toString())
        builder.setSpan(StyleSpan(Typeface.BOLD), 7, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(StyleSpan(Typeface.BOLD), 19, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvExplan.text = builder

    }

    // 클릭 이벤트
    private fun onClickLogin(){
        with(binding){
            ibtnNaver.setOnClickListener {
                PlatformManager.setPlatform(NAVER)
                naverLoginManager.startLogin {
                    viewModel.updateSocialToken(it)
                }
            }
            ibtnKakao.setOnClickListener {
                PlatformManager.setPlatform(KAKAO)
                kakaoLoginManager.startKakaoLogin {
                    viewModel.updateSocialToken(it)
                }
            }
        }
    }

    // 엑티비티 이동
    private fun moveKeywordActivity(){
        val intent = Intent(this@LoginActivitiy, KeywordActivity::class.java)
        startActivity(intent)
    }


}