package com.example.umc_prepare

import android.os.Bundle
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
        binding.vpMain.adapter = mainVPAdapter


        binding.navBottom.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_list -> {
                    binding.vpMain.currentItem = 0
                }
                R.id.menu_home -> {
                    binding.vpMain.currentItem = 1
                }
                R.id.menu_mypage -> {
                    EventBus.getDefault().post(Profile(
                        intent.getStringExtra("name")?:"null",
                        intent.getStringExtra("gender")?:"null",
                        intent.getStringExtra("age")?:"null"
                    ))
                    binding.vpMain.currentItem = 2
                }
            }
            true
        }

        binding.vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if(position == 2){
                    EventBus.getDefault().post(Profile(
                        intent.getStringExtra("name")?:"null",
                        intent.getStringExtra("gender")?:"null",
                        intent.getStringExtra("age")?:"null"
                    ))
                    binding.navBottom.menu.getItem(position).isChecked = true
                }else{
                    binding.navBottom.menu.getItem(position).isChecked = true
                }
            }
        })
    }


    //fragment switching
    private fun changeFragment(fragmet: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, fragmet)
            .commit()
    }
}
