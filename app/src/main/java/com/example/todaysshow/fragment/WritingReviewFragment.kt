package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.todaysshow.R

class WritingReviewFragment(title: String) : Fragment() {

    var title = title

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_writing_review_fragment, null) as ViewGroup




        var closeBt : Button = viewGroup.findViewById<Button>(R.id.writing_review_close_bt)
        closeBt.setOnClickListener(View.OnClickListener {
            var parentFrag: ShowDetailFragment = this@WritingReviewFragment.parentFragment as ShowDetailFragment
                parentFrag.showLayout()
        })

        return viewGroup
    }
}
