package com.example.umc_prepare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_prepare.databinding.ActivityMainBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonOAuthLoginImg.setOnClickListener {
            val oauthLoginCallback = object : OAuthLoginCallback{
                override fun onSuccess() {
                    val intent = Intent(this@MainActivity, FirstActivity::class.java)


                    NidOAuthLogin().callProfileApi(object: NidProfileCallback<NidProfileResponse>{
                        override fun onError(errorCode: Int, message: String) {
                            onFailure(errorCode, message)
                        }

                        override fun onFailure(httpStatus: Int, message: String) {
                            val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                            val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                            Toast.makeText(this@MainActivity, "errorCode:$errorCode, errorDesc:$errorDescription", Toast.LENGTH_SHORT).show()
                        }

                        override fun onSuccess(result: NidProfileResponse) {
                            intent.putExtra("name", result?.profile?.name)
                            intent.putExtra("gender", result?.profile?.gender)
                            intent.putExtra("age", result?.profile?.age)
                            startActivity(intent)
                        }

                    })
                }
                override fun onError(errorCode: Int, message: String) {
                    onFailure(errorCode, message)
                }

                override fun onFailure(httpStatus: Int, message: String) {
                    val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                    val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                    Toast.makeText(this@MainActivity, "errorCode:$errorCode, errorDesc:$errorDescription", Toast.LENGTH_SHORT).show()
                }
            }

            NaverIdLoginSDK.initialize(this@MainActivity, getString(R.string.naver_client_ID), getString(R.string.naver_client_Secret), "프로젝트준비")
            NaverIdLoginSDK.authenticate(this@MainActivity, oauthLoginCallback)
        }
    }
}