package com.example.umc_prepare

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_prepare.databinding.FragmentMypageBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MypageFragment: Fragment() {
    val TAG = "MypageFragment"
    private lateinit var binding: FragmentMypageBinding

    companion object{
        const val TAG = "mayPageFragment"
        fun newInstance(): MypageFragment = MypageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(layoutInflater)

        binding.tvLogout.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("알림")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("네"){_, _ ->
                    NaverIdLoginSDK.logout()
                    requireActivity().supportFragmentManager.popBackStack()
                    requireActivity().finish()
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("아니요", null)
            builder.show()
        }
        binding.tvDelete.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("알림")
                .setMessage("탈퇴하시겠습니까?\n기존 회원정보 및 관련 내용이 모두 삭제됩니다")
                .setPositiveButton("네"){_, _->
                    NidOAuthLogin().callDeleteTokenApi(requireContext(), object: OAuthLoginCallback{
                        override fun onError(errorCode: Int, message: String) {
                            onFailure(errorCode, message)
                        }

                        override fun onFailure(httpStatus: Int, message: String) {
                            Log.e(TAG, "errorCode:${NaverIdLoginSDK.getLastErrorCode().code}")
                            Log.e(TAG, "errorDesc:${NaverIdLoginSDK.getLastErrorDescription()}")
                        }

                        override fun onSuccess() {
                            //탈퇴 완료
                        }
                    })
                    requireActivity().supportFragmentManager.popBackStack()
                    requireActivity().finish()
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("아니오", null)
            builder.show()

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getProfile(profile: Profile){
        binding.tvName.text = profile.name
        binding.tvGender.text = if(profile.gender == "M") "남자" else "여자"
        binding.tvAge.text = profile.age
    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


}