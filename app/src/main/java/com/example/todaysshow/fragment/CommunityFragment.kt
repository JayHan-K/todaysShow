package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.todaysshow.R
import com.example.todaysshow.adapter.CommunityPagerAdapter
import com.example.todaysshow.fragment.community.CommunityEditorChallenges
import com.example.todaysshow.fragment.community.CommunityEditors
import com.example.todaysshow.fragment.community.CommunityEditorsNotice
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_community_fragment.*

class CommunityFragment(initIndex: Int) : Fragment() {
    var initIndex = initIndex
    var communityMainLinearLayout : LinearLayout? = null
    var communityMainFrameLayout : FrameLayout? = null
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

        communityMainLinearLayout = viewGroup.findViewById(R.id.community_main_ll)
        communityMainFrameLayout = viewGroup.findViewById(R.id.community_main_fl)

        return viewGroup
    }

    fun communityChangeToEditorChallenges(){
        communityMainLinearLayout!!.visibility = View.INVISIBLE
        communityMainFrameLayout!!.visibility = View.VISIBLE

        childFragmentManager.beginTransaction().replace(
            R.id.community_main_fl,
            CommunityEditorChallenges()
        ).commitAllowingStateLoss()
    }

    fun backToCommunity(){
        communityMainLinearLayout!!.visibility = View.VISIBLE
        communityMainFrameLayout!!.visibility = View.INVISIBLE
    }

    fun communityChangeToJournalDetail(){
        communityMainLinearLayout!!.visibility = View.INVISIBLE
        communityMainFrameLayout!!.visibility = View.VISIBLE

        childFragmentManager.beginTransaction().replace(
            R.id.community_main_fl,
            JournalDetailFragment("Community")
        ).commitAllowingStateLoss()
    }

    fun communityChangeToNotice(){
        communityMainLinearLayout!!.visibility = View.INVISIBLE
        communityMainFrameLayout!!.visibility = View.VISIBLE

        childFragmentManager.beginTransaction().replace(
            R.id.community_main_fl,
            CommunityEditorsNotice()
        ).commitAllowingStateLoss()
    }

}
