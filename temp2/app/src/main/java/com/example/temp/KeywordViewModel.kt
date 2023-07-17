package com.example.temp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.temp.data.UserData
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class KeywordViewModel: ViewModel() {
    private val _userData = MutableLiveData<UserData>()
    val TAG = "KeywordViewModel"

    val userData: LiveData<UserData>
        get() = _userData

    fun updateUserdata(){
        Log.d(TAG, PlatformManager.getPlatform())
        if(PlatformManager.getPlatform() == "naver"){
            Log.d(TAG, "updateUserdata")
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
        }
    }
}