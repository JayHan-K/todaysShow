package com.example.todaysshow.adapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.todaysshow.fragment.community.CommunityEditors
import com.example.todaysshow.fragment.community.CommunityHotIssue
import com.example.todaysshow.fragment.community.CommunityQNA
import com.example.todaysshow.fragment.community.CommunityRealReview

class CommunityPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){

    val titleList :ArrayList<String> = arrayListOf("핫 이슈", "에디터's", "공연 찐후기", "Q & A")


    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment {
        var fragment :Fragment = Fragment()
        when(position){
            0 -> fragment = CommunityHotIssue()
            1 -> fragment = CommunityEditors()
            2 -> fragment = CommunityRealReview()
            3 -> fragment = CommunityQNA()
        }

        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }
}