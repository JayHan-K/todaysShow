package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.ShowDetailActivity
import com.example.todaysshow.adapter.SearchResultImageAdapter
import com.example.todaysshow.adapter.ShowDetailImageAdapter
import kr.co.prnd.YouTubePlayerView

class ShowDetailFragment(parent: String, title: String) : Fragment() {

    var parent = parent
    var title = title
    var showDetailFrameLayout : FrameLayout? = null
    var showDetailRelativeLayout : RelativeLayout? = null
    var showDetailTopLinearLayout : LinearLayout? = null
    var showDetailImageRecyclerView : RecyclerView? = null
    var isHeart : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_show_detail_fragment, null) as ViewGroup

        showDetailImageRecyclerView = viewGroup.findViewById(R.id.show_detail_image_rv)
        var imageResources : ArrayList<Int> = ArrayList()
        imageResources.add(R.drawable.opera_1)
        imageResources.add(R.drawable.opera_2)
        imageResources.add(R.drawable.opera_3)
        imageResources.add(R.drawable.opera_4)
        imageResources.add(R.drawable.opera_5)
        imageResources.add(R.drawable.opera_6)

        showDetailImageRecyclerView!!.adapter = ShowDetailImageAdapter(imageResources, context!!)
        var gridLayoutManager : GridLayoutManager = GridLayoutManager(context!!, 3)
        showDetailImageRecyclerView!!.layoutManager = gridLayoutManager

        showDetailFrameLayout = viewGroup.findViewById(R.id.show_detail_fl)
        showDetailRelativeLayout = viewGroup.findViewById(R.id.show_detail_rl)
        showDetailTopLinearLayout = viewGroup.findViewById(R.id.show_detail_top_ll)

        var showDetailTitleTextView = viewGroup.findViewById<TextView>(R.id.show_detail_title_tv)
        showDetailTitleTextView.setText(title)

        var closeBt : Button = viewGroup.findViewById<Button>(R.id.show_detail_fragment_close_bt)
        closeBt.setOnClickListener(View.OnClickListener {
            if (parent.equals("Home")) {
                var parentFrag: HomeFragment =
                this@ShowDetailFragment.parentFragment as HomeFragment
                parentFrag.BackToHome()
            }else if(parent.equals("Search")){
                var parentFrag: SearchFragment =
                    this@ShowDetailFragment.parentFragment as SearchFragment
                parentFrag.backToSearchFrame()
            }
        })

        var showDetailWritingReviewButton : Button = viewGroup.findViewById(R.id.show_detail_writing_review_bt)
        showDetailWritingReviewButton.setOnClickListener(View.OnClickListener {
            showDetailFrameLayout!!.visibility = View.VISIBLE
            showDetailRelativeLayout!!.visibility = View.INVISIBLE
            showDetailTopLinearLayout!!.visibility = View.INVISIBLE

            childFragmentManager.beginTransaction().replace(
                R.id.show_detail_fl,
                WritingReviewFragment("오페라의 유령")
            ).commitAllowingStateLoss()

        })

        var youTubePlayer = viewGroup.findViewById<YouTubePlayerView>(R.id.show_detail_fragment_youtube)

        youTubePlayer.play(ShowDetailFragment.VIDEO_ID)

        var showDetailHeartButton: Button = viewGroup.findViewById(R.id.show_detail_heart_bt)
        showDetailHeartButton.setOnClickListener(View.OnClickListener {
            if(isHeart){
                showDetailHeartButton.setBackgroundResource(R.drawable.icon_heart_unmine)
                isHeart = false
            }else{
                showDetailHeartButton.setBackgroundResource(R.drawable.icon_heart_mine)
                isHeart = true
            }
        })

        return viewGroup
    }

    fun showLayout(){
        showDetailFrameLayout!!.visibility = View.INVISIBLE
        showDetailRelativeLayout!!.visibility = View.VISIBLE
        showDetailTopLinearLayout!!.visibility = View.VISIBLE
    }

    companion object{
        private const val VIDEO_ID = "a7AP-XrBKC0"
    }


}
