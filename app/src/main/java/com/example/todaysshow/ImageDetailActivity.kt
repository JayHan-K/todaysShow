package com.example.todaysshow

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.todaysshow.adapter.ImageDetailPagerAdapter
import org.w3c.dom.Text

class ImageDetailActivity : AppCompatActivity() {
    var imageDetailImageNumberTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
            WindowManager.LayoutParams.FLAG_BLUR_BEHIND
        )
        setContentView(R.layout.activity_image_detail)
        var position = 0
        if(intent.hasExtra("position")){
            position = intent.getIntExtra("position",0)
        }

        var viewPager = findViewById<ViewPager>(R.id.image_detail_vp)
        var adapter = ImageDetailPagerAdapter(getImageResources(), this, position)
        viewPager.adapter = adapter

        var imageDetailCloseButton : Button = findViewById(R.id.image_detail_close_bt)
        imageDetailCloseButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        imageDetailImageNumberTextView  = findViewById(R.id.image_detail_image_num_tv)
        imageDetailImageNumberTextView!!.setText(getImageNumTextViewString(position))

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                imageDetailImageNumberTextView!!.setText(getImageNumTextViewString(position))
            }

        })

        viewPager.currentItem = position

    }

    fun getImageNumTextViewString(position: Int) : String{
        return (position+1).toString() + " of 6"
    }

    fun getImageResources(): ArrayList<Int>{
        var imageResources : ArrayList<Int> = ArrayList()
        imageResources.add(R.drawable.opera_1)
        imageResources.add(R.drawable.opera_2)
        imageResources.add(R.drawable.opera_3)
        imageResources.add(R.drawable.opera_4)
        imageResources.add(R.drawable.opera_5)
        imageResources.add(R.drawable.opera_6)
        return imageResources
    }
}