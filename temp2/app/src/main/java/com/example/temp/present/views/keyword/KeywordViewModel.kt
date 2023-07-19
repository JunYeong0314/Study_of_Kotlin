package com.example.temp.present.views.keyword

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.temp.domain.model.UserData
import com.example.temp.present.config.PlatformManager
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse

class KeywordViewModel: ViewModel() {
    private val _userData = MutableLiveData<UserData>()
    companion object{
        const val TAG = "KeywordViewModel"
    }

    val userData: LiveData<UserData>
        get() = _userData

    // 플랫폼에 알맞는 유저 최초닉네임 업데이트
    fun updateUserdata(){
        Log.d(TAG, PlatformManager.getPlatform())
        if(PlatformManager.getPlatform() == "naver"){
            NidOAuthLogin().callProfileApi(object : NidProfileCallback<NidProfileResponse> {
                override fun onError(errorCode: Int, message: String) {
                    onFailure(errorCode, message)
                }
                override fun onFailure(httpStatus: Int, message: String) {
                    Log.d("LoginViewModel", "error: ${message}")
                }
                override fun onSuccess(result: NidProfileResponse) {
                    _userData.value = UserData(
                        result?.profile?.name ?: "",
                        result?.profile?.gender ?: "",
                        result?.profile?.nickname ?: ""
                    )
                }

            })
        }else if(PlatformManager.getPlatform() == "kakao"){
            UserApiClient.instance.me{user, error ->
                if(error != null){
                    Log.d(TAG, error.message.toString())
                }else if(user != null){
                    _userData.value = UserData(
                        user.kakaoAccount?.name ?: "",
                        (user.kakaoAccount?.gender).toString() ?: "",
                        user.kakaoAccount?.profile?.nickname ?: ""
                    )
                }

            }
        }
    }
}