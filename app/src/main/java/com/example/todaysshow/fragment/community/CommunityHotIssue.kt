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
                "2020\n공연트렌트",
                R.drawable.journal_image_sample1
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.journal_image_sample2
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.journal_image_sample1
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.journal_image_sample2
            )
        )
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.journal_image_sample1
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.journal_image_sample2
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.journal_image_sample1
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.journal_image_sample2
            )
        )
        return journals
    }
}
