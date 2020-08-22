package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.todaysshow.R
import com.example.todaysshow.adapter.CommunityPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_community_fragment.*

class CommunityFragment(initIndex: Int) : Fragment() {
    var initIndex = initIndex
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup:ViewGroup = inflater.inflate(R.layout.activity_community_fragment, null) as ViewGroup

        var communityTabLayout = viewGroup.findViewById<TabLayout>(R.id.community_tab_layout)
        var communityViewPager = viewGroup.findViewById<ViewPager>(R.id.community_view_pager)
        communityViewPager.adapter = CommunityPagerAdapter(childFragmentManager)
        communityTabLayout.setupWithViewPager(communityViewPager)
        communityViewPager.currentItem = initIndex




        return viewGroup
    }

}
