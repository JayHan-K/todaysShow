package com.example.todaysshow.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.todaysshow.R

class HomeAdPagerFragment(imageResource: Int) : Fragment() {
    var imageResource = imageResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_home_ad_fragment, null) as ViewGroup
        var homeMainAdIV = viewGroup.findViewById<ImageView>(R.id.home_main_ad_iv)
        homeMainAdIV.setBackgroundResource(imageResource)
        return viewGroup
    }
}