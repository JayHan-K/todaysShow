package com.example.todaysshow.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.`object`.Show
import com.example.todaysshow.adapter.JournalAdapter
import com.example.todaysshow.adapter.SearchResultImageAdapter
import com.example.todaysshow.adapter.SearchResultRelationAdapter
import com.example.todaysshow.fragment.HomeFragment
import com.example.todaysshow.fragment.SearchFragment

class CategoryDetailFragment(category: String ) : Fragment() {
    var category = category
    var categoryDetailFragmentJournalRecyclerView : RecyclerView? = null
    var categoryDetailFragmentImageRecyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.categoty_detail_fragment, null) as ViewGroup

        categoryDetailFragmentImageRecyclerView = viewGroup.findViewById(R.id.category_detail_fragment_image_rv)
        val myListener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var show :Show = item as Show
                var parentFrag: HomeFragment =
                    this@CategoryDetailFragment.parentFragment as HomeFragment
                parentFrag.homeChangeToShowDetail(show)

            }
        }
        categoryDetailFragmentImageRecyclerView!!.adapter = SearchResultImageAdapter(getImageList(), context!!,myListener)
        var gridLayoutManager : GridLayoutManager = GridLayoutManager(context!!, 3)
        categoryDetailFragmentImageRecyclerView!!.layoutManager = gridLayoutManager




        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val listener : ItemClickListener = object : ItemClickListener {
            override fun onItemClicked(vh: RecyclerView.ViewHolder, item: Any, pos: Int) {
                var parentFrag: HomeFragment =
                    this@CategoryDetailFragment.parentFragment as HomeFragment
                parentFrag.homeChangeToJournalDetail()
            }
        }
        categoryDetailFragmentJournalRecyclerView = viewGroup.findViewById(R.id.category_detail_fragment_journal_rv) as RecyclerView
        val journalAdapter =
            JournalAdapter(getJournals(), context!!, listener)
        categoryDetailFragmentJournalRecyclerView!!.layoutManager = journalLayoutManager
        categoryDetailFragmentJournalRecyclerView!!.adapter = journalAdapter

        var categoryDetailFragmentCloseButton : Button = viewGroup.findViewById(R.id.category_detail_fragment_close_bt)
        categoryDetailFragmentCloseButton.setOnClickListener(View.OnClickListener {
            var parentFrag: HomeFragment =
                this@CategoryDetailFragment.parentFragment as HomeFragment
            parentFrag.BackToHome()
        })

        var categoryDetailCategoryTextView : TextView = viewGroup.findViewById(R.id.category_detail_category_tv)
        categoryDetailCategoryTextView.setText(category)

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
