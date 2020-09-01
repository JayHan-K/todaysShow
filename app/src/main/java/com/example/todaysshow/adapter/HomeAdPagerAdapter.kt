package com.example.todaysshow.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.todaysshow.R
import com.example.todaysshow.fragment.home.HomeAdPagerFragment

class HomeAdPagerAdapter (fm: FragmentManager): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {

        var fragment : Fragment = Fragment()
        when(position){
            0 -> fragment = HomeAdPagerFragment(R.drawable.ad_sample1)
            1 -> fragment = HomeAdPagerFragment(R.drawable.ad_sample2)
            2 -> fragment = HomeAdPagerFragment(R.drawable.ad_sample3)
            3 -> fragment = HomeAdPagerFragment(R.drawable.ad_sample4)
            4 -> fragment = HomeAdPagerFragment(R.drawable.ad_sample5)
        }
        return fragment
    }

    override fun getCount(): Int {
        return 5
    }

}