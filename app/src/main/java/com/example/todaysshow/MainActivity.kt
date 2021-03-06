package com.example.todaysshow

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todaysshow.fragment.CommunityFragment
import com.example.todaysshow.fragment.HomeFragment
import com.example.todaysshow.fragment.ProfileFragment
import com.example.todaysshow.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mBackWait:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout,
            HomeFragment()
        ).commitAllowingStateLoss()
        main_bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout,
                        HomeFragment()
                    ).commitAllowingStateLoss()
                }
                R.id.bottom_search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout,
                        SearchFragment()
                    ).commitAllowingStateLoss()
                }
                R.id.bottom_community -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout,
                        CommunityFragment(0)
                    ).commitAllowingStateLoss()
                }
                R.id.bottom_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout,
                        ProfileFragment()
                    ).commitAllowingStateLoss()
                }
            }
            true
        }
    }

    override fun onBackPressed() {



        if(System.currentTimeMillis() - mBackWait >= 2000){
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }else{
            finish()
        }

    }

}
