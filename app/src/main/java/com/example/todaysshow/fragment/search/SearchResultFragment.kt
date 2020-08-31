package com.example.todaysshow.fragment.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.ShowDetailActivity
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.`object`.Show
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter
import com.example.todaysshow.adapter.SearchResultImageAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter
import com.example.todaysshow.fragment.HomeFragment
import com.example.todaysshow.fragment.SearchFragment
import com.example.todaysshow.fragment.ShowDetailFragment
import kotlinx.android.synthetic.main.search_list_item.*

class SearchResultFragment(resultStr : String) : Fragment() {
    var searchResultStr = resultStr
    var journalList : ArrayList<Journal>? = null
    var relationList : ArrayList<String>? = null
    var searchResultImageRecyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.search_result_layout, null) as ViewGroup


        searchResultImageRecyclerView = viewGroup.findViewById(R.id.search_result_image_rv)
        val myListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var show :Show = item as Show
                var parentFrag: SearchFragment =
                    this@SearchResultFragment.parentFragment as SearchFragment
                parentFrag.changeSearchFrameToShowDetail(show)

            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {

            }
        }
        searchResultImageRecyclerView!!.adapter = SearchResultImageAdapter(getImageList(), context!!,myListener)
        var gridLayoutManager : GridLayoutManager = GridLayoutManager(context!!, 3)
        searchResultImageRecyclerView!!.layoutManager = gridLayoutManager




        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val relationLayoutManager : LinearLayoutManager = LinearLayoutManager(context)

        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag: SearchFragment =
                    this@SearchResultFragment.parentFragment as SearchFragment
                parentFrag.changeSearchFrameToJournalDetail()
            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {

            }
        }
        journalList = getJournals()
        val searchResultJournalRV = viewGroup.findViewById<RecyclerView>(R.id.search_result_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(journalList!!, context!!, listener)
        searchResultJournalRV.layoutManager = journalLayoutManager
        searchResultJournalRV.adapter = journalAdapter

        relationList = getRelation()
        val mListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag : SearchFragment = this@SearchResultFragment.parentFragment as SearchFragment
                parentFrag.setSearchQuery(item.toString())

            }

            override fun onItemClicked(
                v: RealReviewSearchSuggestionAdapter.ViewHolder,
                item: Any,
                pos: Int
            ) {

            }
        }
        val relationListRV = viewGroup.findViewById<RecyclerView>(R.id.search_result_relation_rv)
        val relationAdapter =
            SearchResultRelationAdapter(
                relationList!!,
                context!!,
                mListener
            )
        relationListRV.layoutManager = relationLayoutManager
        relationListRV.adapter = relationAdapter


        return viewGroup
    }


    fun getJournals() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(
            Journal(
                "2020\n오페라트렌드",
                R.drawable.tip
            )
        )
        journals.add(
            Journal(
                "나의 오페라\n첫! 도전기",
                R.drawable.alone
            )
        )
        journals.add(
            Journal(
                "오페라는\n무엇일까?",
                R.drawable.journal_image_sample2
            )
        )
        journals.add(
            Journal(
                "4대 뮤지컬\n오페라의 유령",
                R.drawable.the_phantom_of_the_opera
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
        relationList.add("파우스트")

        return relationList

    }


    fun getImageList(): ArrayList<Show>{
        var shows : ArrayList<Show> = ArrayList()

        shows.add(
            Show(
                R.drawable.poster_sample11,
                "오페라의 유령"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample1,
                "돈 조반니"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample15,
                "파우스트"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample3,
                "라인의 황금"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample4,
                "레미제라블"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample17,
                "라흐마니노프"
            )
        )
        shows.add(
            Show(
                R.drawable.the42nd,
                "브로드웨이42번가"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample13,
                "캣츠"
            )
        )
        shows.add(
            Show(
                R.drawable.poster_sample7,
                "마우스피스"
            )
        )

        return shows
    }

}
