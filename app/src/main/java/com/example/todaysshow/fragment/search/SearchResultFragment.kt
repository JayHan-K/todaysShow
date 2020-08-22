package com.example.todaysshow.fragment.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.R
import com.example.todaysshow.ShowDetailActivity
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter

class SearchResultFragment(resultStr : String) : Fragment(), View.OnClickListener {
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

        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                Toast.makeText(context, "Search Fragment", Toast.LENGTH_SHORT).show()
            }
        }
        journalList = getJournals()
        val searchResultJournalRV = viewGroup.findViewById<RecyclerView>(R.id.search_result_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(journalList!!, context!!, listener)
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

        var searchResultBt1 = viewGroup.findViewById<Button>(R.id.search_result_bt1)
        var searchResultBt2 = viewGroup.findViewById<Button>(R.id.search_result_bt2)
        var searchResultBt3 = viewGroup.findViewById<Button>(R.id.search_result_bt3)
        var searchResultBt4 = viewGroup.findViewById<Button>(R.id.search_result_bt4)
        var searchResultBt5 = viewGroup.findViewById<Button>(R.id.search_result_bt5)
        var searchResultBt6 = viewGroup.findViewById<Button>(R.id.search_result_bt6)
        var searchResultBt7 = viewGroup.findViewById<Button>(R.id.search_result_bt7)
        var searchResultBt8 = viewGroup.findViewById<Button>(R.id.search_result_bt8)
        var searchResultBt9 = viewGroup.findViewById<Button>(R.id.search_result_bt9)

        searchResultBt1.setOnClickListener(this)
        searchResultBt2.setOnClickListener(this)
        searchResultBt3.setOnClickListener(this)
        searchResultBt4.setOnClickListener(this)
        searchResultBt5.setOnClickListener(this)
        searchResultBt6.setOnClickListener(this)
        searchResultBt7.setOnClickListener(this)
        searchResultBt8.setOnClickListener(this)
        searchResultBt9.setOnClickListener(this)





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

    override fun onClick(v: View?) {
        var intent: Intent = Intent(activity, ShowDetailActivity::class.java)
        startActivity(intent)
    }

}
