package com.example.todaysshow.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter

class CommunityEditors : Fragment() {

    var journalList : ArrayList<Journal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_community_editors_fragment, null) as ViewGroup


        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                Toast.makeText(context, "Community Editors", Toast.LENGTH_SHORT).show()
            }
        }
        journalList = getJournals()
        val searchResultJournalRV = viewGroup.findViewById<RecyclerView>(R.id.community_editors_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(journalList, context!!, listener)
        searchResultJournalRV.layoutManager = journalLayoutManager
        searchResultJournalRV.adapter = journalAdapter



        return viewGroup
    }

    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "2020\n공연트렌트",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "샤롯데 씨어\n첫! 방문기",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "나는\n도대체 어디...?",
                R.drawable.empty_circle
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.empty_circle
            )
        )
        return journals
    }
}
