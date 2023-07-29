package com.example.umc_prepare

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_prepare.databinding.ActivityFirstBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.greenrobot.eventbus.EventBus

class FirstActivity: AppCompatActivity() {
    private val binding: ActivityFirstBinding by lazy{
        ActivityFirstBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mainVPAdapter = MainVPAdapter(this)


        binding.navBottom.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_list -> {
                    showFragment(ListFragment.newInstance(), ListFragment.TAG)
                }
                R.id.menu_home -> {
                    showFragment(HomeFragment.newInstance(), HomeFragment.TAG)
                }
                R.id.menu_mypage -> {
                    EventBus.getDefault().post(Profile(
                        intent.getStringExtra("name")?:"null",
                        intent.getStringExtra("gender")?:"null",
                        intent.getStringExtra("age")?:"null"
                    ))
                    showFragment(MypageFragment.newInstance(), MypageFragment.TAG)
                }
            }
            true
        }

    }

    private fun showFragment(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fv_main, fragment, tag)
            .commit()
    }

}
