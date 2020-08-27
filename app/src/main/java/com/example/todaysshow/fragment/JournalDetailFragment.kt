package com.example.todaysshow.fragment

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.example.todaysshow.R

class JournalDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_journal_detail_fragment, null) as ViewGroup


        var wm : WindowManager = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var display : Display = wm.defaultDisplay
        var size : Point = Point()
        display.getSize(size)
        var width = size.x
        var height = size.y
        var journalDetailMainImageViewRelativeLayout: RelativeLayout = viewGroup.findViewById(R.id.journal_detail_main_iv_rl)
        var metrics : DisplayMetrics = context!!.resources.displayMetrics
        var heightDouble : Double = height * 0.9
        height = heightDouble.toInt()
        setSizeInDP(journalDetailMainImageViewRelativeLayout, width, height)

        return viewGroup
    }

    fun setSizeInDP(view: View, width: Int, height: Int){
        if(view.layoutParams is ViewGroup.LayoutParams){
            val screenDensity : Float = view.context.resources.displayMetrics.density
            val params : ViewGroup.LayoutParams = view.layoutParams as ViewGroup.LayoutParams

            params.width = width
            params.height = height
            view.requestLayout()
        }
    }
}
