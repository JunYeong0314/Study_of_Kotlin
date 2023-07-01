package com.example.umc_prepare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_prepare.databinding.ActivityFirstBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FirstActivity: AppCompatActivity() {
    private val binding: ActivityFirstBinding by lazy{
        ActivityFirstBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mainVPAdapter = MainVPAdapter(this)
        binding.vpMain.adapter = mainVPAdapter

        changeFragment(HomeFragment()) // 첫 화면 fragment
        binding.navBottom.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_list -> {
                    changeFragment(ListFragment())
                }
                R.id.menu_home -> {
                    changeFragment(HomeFragment())
                }
                R.id.menu_mypage -> {
                    changeFragment(MypageFragment())
                }
            }
            true
        }

        binding.vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> binding.navBottom.selectedItemId = R.id.menu_list
                    1 -> binding.navBottom.selectedItemId = R.id.menu_home
                    2 -> binding.navBottom.selectedItemId = R.id.menu_mypage
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
