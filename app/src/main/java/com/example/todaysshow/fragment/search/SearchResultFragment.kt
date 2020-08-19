package com.example.todaysshow.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.R
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter

class SearchResultFragment(resultStr : String) : Fragment() {
    var searchResultStr = resultStr
    var journalList : ArrayList<Journal>? = null
    var relationList : ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.search_result_layout, null) as ViewGroup

        //var searchResultTv = viewGroup.findViewById<TextView>(R.id.search_result_tv) as TextView
        //searchResultTv.setText(searchResultStr)

        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val relationLayoutManager : LinearLayoutManager = LinearLayoutManager(context)


        journalList = getJournals()
        val searchResultJournalRV = viewGroup.findViewById<RecyclerView>(R.id.search_result_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(journalList!!, context!!)
        searchResultJournalRV.layoutManager = journalLayoutManager
        searchResultJournalRV.adapter = journalAdapter

        relationList = getRelation()
        val relationListRV = viewGroup.findViewById<RecyclerView>(R.id.search_result_relation_rv)
        val relationAdapter =
            SearchResultRelationAdapter(
                relationList!!,
                context!!
            )
        relationListRV.layoutManager = relationLayoutManager
        relationListRV.adapter = relationAdapter






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

    fun getRelation() : ArrayList<String>{
        val relationList = ArrayList<String>()
        relationList.add("오백에 삼십")
        relationList.add("쉬어 매드니스")
        relationList.add("캣츠")
        relationList.add("오페라의 유령")

        return relationList

    }

}
