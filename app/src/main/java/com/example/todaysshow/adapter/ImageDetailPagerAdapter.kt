package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.todaysshow.R

class ImageDetailPagerAdapter(imageResources: ArrayList<Int>, context: Context, initPosition: Int) : PagerAdapter() {
    var imageResources = imageResources
    var context = context
    var layoutInflater : LayoutInflater? = null
    var initPosition = initPosition

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageResources.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var v = layoutInflater!!.inflate(R.layout.image_detail_pager_item, null)
        var image = v.findViewById<ImageView>(R.id.image_detail_pager_iv)

        image.setImageResource(imageResources.get(position))
        var vp = container as ViewPager
        vp.addView(v, 0)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}