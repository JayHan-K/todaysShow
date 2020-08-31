package com.example.todaysshow.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.adapter.CommunityHotIssueJournalAdapter
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter
import com.example.todaysshow.fragment.CommunityFragment

class CommunityHotIssue : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_community_hot_issue_fragment, null) as ViewGroup
        val mListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag: CommunityFragment =
                    this@CommunityHotIssue.parentFragment as CommunityFragment
                parentFrag.communityChangeToJournalDetail()
            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {
            }
        }

        var communityHotIssueRecyclerView : RecyclerView = viewGroup.findViewById(R.id.community_hot_issue_rv)
        communityHotIssueRecyclerView.layoutManager = LinearLayoutManager(context)
        communityHotIssueRecyclerView.adapter = CommunityHotIssueJournalAdapter(getJournals(), context!!, mListener)

        return viewGroup
    }

    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "명동에 극장이 있다고!",
                R.drawable.hot_issue_sample1
            )
        )
        journals.add(
            Journal(
                "모든 이야기의 시작,\n오이디푸스",
                R.drawable.hot_issue_sample2
            )
        )
        journals.add(
            Journal(
                "세계 4대 뮤지컬을 알려줄게 1편, 캣츠",
                R.drawable.hot_issue_sample3
            )
        )
        journals.add(
            Journal(
                "정신없이 웃고 싶어",
                R.drawable.hot_issue_sample4
            )
        )
        journals.add(
            Journal(
                "혼자가 딱 좋아!\n혼공 라이프",
                R.drawable.hot_issue_sample5
            )
        )
        journals.add(
            Journal(
                "명동에 극장이 있다고!",
                R.drawable.hot_issue_sample1
            )
        )
        journals.add(
            Journal(
                "모든 이야기의 시작,\n오이디푸스",
                R.drawable.hot_issue_sample2
            )
        )
        journals.add(
            Journal(
                "세계 4대 뮤지컬을 알려줄게 1편, 캣츠",
                R.drawable.hot_issue_sample3
            )
        )
        journals.add(
            Journal(
                "정신없이 웃고 싶어",
                R.drawable.hot_issue_sample4
            )
        )
        return journals
    }
}
