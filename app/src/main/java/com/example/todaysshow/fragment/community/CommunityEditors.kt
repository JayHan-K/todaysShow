package com.example.todaysshow.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.`object`.Show
import com.example.todaysshow.adapter.CommunityEditorsJournalAdapter
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.SearchResultImageAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter
import com.example.todaysshow.fragment.CommunityFragment
import com.example.todaysshow.fragment.SearchFragment

class CommunityEditors : Fragment() {

    var journalList : ArrayList<Journal> = ArrayList()
    var communityEditorsEditorRecyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_community_editors_fragment, null) as ViewGroup

        communityEditorsEditorRecyclerView = viewGroup.findViewById(R.id.community_editors_editor_rv)
        val mListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag: CommunityFragment =
                    this@CommunityEditors.parentFragment as CommunityFragment
                parentFrag.communityChangeToJournalDetail()
            }
        }
        communityEditorsEditorRecyclerView!!.adapter = CommunityEditorsJournalAdapter(getJournals(), context!!,mListener)
        var gridLayoutManager : GridLayoutManager = GridLayoutManager(context!!, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                when(position){
                    6 -> return 2
                    else -> return 1
                }
            }
        }
        communityEditorsEditorRecyclerView!!.layoutManager = gridLayoutManager


        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag: CommunityFragment =
                    this@CommunityEditors.parentFragment as CommunityFragment
                parentFrag.communityChangeToJournalDetail()
            }
        }
        journalList = getJournals()
        val searchResultJournalRV = viewGroup.findViewById<RecyclerView>(R.id.community_editors_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(journalList, context!!, listener)
        searchResultJournalRV.layoutManager = journalLayoutManager
        searchResultJournalRV.adapter = journalAdapter

        var communityEditorsChallengesButton = viewGroup.findViewById<Button>(R.id.community_editors_challenges_bt)
        communityEditorsChallengesButton.setOnClickListener(View.OnClickListener {
            var parentFrag: CommunityFragment =
                this@CommunityEditors.parentFragment as CommunityFragment
            parentFrag.communityChangeToEditorChallenges()
        })


        return viewGroup
    }

    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "공연 병아리\n필수",
                R.drawable.editors_sample1
            )
        )
        journals.add(
            Journal(
                "연인과 함께",
                R.drawable.editors_sample2
            )
        )
        journals.add(
            Journal(
                "가족과 함께?",
                R.drawable.editors_sample3
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.editors_sample4
            )
        )
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.family
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.alone
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.the42nd
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.tip
            )
        )
        journals.add(
            Journal(
                "극장 꿀팁",
                R.drawable.tip_
            )
        )
        return journals
    }
}
