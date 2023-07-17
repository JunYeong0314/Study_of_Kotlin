package com.example.temp.socialLoginManager

import android.content.Context
import android.util.Log
import com.example.temp.Constants
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

// 네이버 로그인 기능
class NaverLoginManager @Inject constructor(
    @ActivityContext private val context: Context
) {
    lateinit var oAuthLoginCallback: OAuthLoginCallback
        private set

    // OAuthLogin 콜백 함수
    fun naverSetOAuthLoginCallback(updateSocialToken: (String) -> Unit){
        oAuthLoginCallback = object : OAuthLoginCallback{
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }

            override fun onFailure(httpStatus: Int, message: String) {
                Log.d("NaverLoginManager", message)
            }

            override fun onSuccess() {
                updateSocialToken(NaverIdLoginSDK.getAccessToken() ?: "")
                Log.d("NaverLoginManager", "onSuccess() : ${NaverIdLoginSDK.getAccessToken()}")
            }
        }
    }
    fun startLogin(updateSocialToken: (String) -> Unit) {
        naverSetOAuthLoginCallback {
            Log.d("NaverLoginManager", "call back(it) : ${it}")
            updateSocialToken(it)
        }
        Log.d("NaverLoginManager", "Naver 초기화 시작")
        // 초기화 작업
        NaverIdLoginSDK.initialize(
            context,
            Constants.NAVER_CLIENT_ID,
            Constants.NAVER_CLIENT_SECRET,
            "JYClient"
        )
        NaverIdLoginSDK.authenticate(context, oAuthLoginCallback)
    }
}