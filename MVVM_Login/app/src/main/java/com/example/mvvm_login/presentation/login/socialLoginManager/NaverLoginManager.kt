package com.example.mvvm_login.presentation.login.socialLoginManager

import android.content.Context
import android.util.Log
import com.example.mvvm_login.R
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
class NaverLoginManager @Inject constructor(
    @ActivityContext private val context: Context
) {
    lateinit var oAuthLoginCallback: OAuthLoginCallback
        private set

    // 네이버 로그인 구현
    @Provides
    fun naverSetOAuthLoginCallback(updateSocialTokens: (String) -> Unit){
        oAuthLoginCallback = object : OAuthLoginCallback{
            override fun onError(errorCode: Int, message: String) {
                TODO("Not yet implemented")
            }

            override fun onFailure(httpStatus: Int, message: String) {
                TODO("Not yet implemented")
            }

            override fun onSuccess() {
                updateSocialTokens(NaverIdLoginSDK.getAccessToken() ?: " ")
            }
        }
    }

    @Provides
    fun startNaverLogin(updateSocialTokens: (String) -> Unit){
        naverSetOAuthLoginCallback { updateSocialTokens(it) }
        NaverIdLoginSDK.initialize(
            context,
            (R.string.naver_client_ID).toString(),
            (R.string.naver_client_SECRET).toString(),
            "공부용"
        )
        NaverIdLoginSDK.authenticate(context, oAuthLoginCallback)
    }


}