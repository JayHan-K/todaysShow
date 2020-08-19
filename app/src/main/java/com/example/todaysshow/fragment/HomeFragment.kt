package com.example.todaysshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.`object`.HomeShow
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.R
import com.example.todaysshow.adapter.HomeShowAdapter
import com.example.todaysshow.adapter.JournalAdapter

class HomeFragment : Fragment() {

    var journalList : ArrayList<Journal>? = null
    var personalizedShow : ArrayList<HomeShow>? = null
    var recommendedShow : ArrayList<HomeShow>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup =
            inflater.inflate(R.layout.activity_home_fragment, null) as ViewGroup
        val journalLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        journalLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val personalLayoutManger : LinearLayoutManager = LinearLayoutManager(context)
        personalLayoutManger.orientation = LinearLayoutManager.HORIZONTAL
        val recommendedLayoutManager : LinearLayoutManager = LinearLayoutManager(context)
        recommendedLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        journalList = getJournals()
        personalizedShow = getPersonals()
        recommendedShow = getRecommended()
        val homeJournalRV = viewGroup.findViewById<RecyclerView>(R.id.home_journal_rv) as RecyclerView
        val journalAdapter = JournalAdapter(journalList, context)
        homeJournalRV.layoutManager = journalLayoutManager
        homeJournalRV.adapter = journalAdapter

        val homePersonalRV = viewGroup.findViewById<RecyclerView>(R.id.personalizedShowRV)
        val homeRecommendedRV = viewGroup.findViewById<RecyclerView>(R.id.recommendShowRV)
        val personalAdapter = HomeShowAdapter(
            personalizedShow,
            context
        )
        val recommandedAdapter = HomeShowAdapter(
            recommendedShow,
            context
        )
        homePersonalRV.layoutManager = personalLayoutManger
        homeRecommendedRV.layoutManager = recommendedLayoutManager
        homePersonalRV.adapter = personalAdapter
        homeRecommendedRV.adapter = recommandedAdapter

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
    fun getPersonals() : ArrayList<HomeShow>{
        val shows = ArrayList<HomeShow>()
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show1"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show2"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show3"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show4"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show5"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show6"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "Show7"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "Show8"
            )
        )
        return shows
    }

    fun getRecommended() : ArrayList<HomeShow>{
        val shows = ArrayList<HomeShow>()
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow1"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow2"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow3"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow4"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow5"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow6"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample2,
                "RShow7"
            )
        )
        shows.add(
            HomeShow(
                R.drawable.show_sample1,
                "RShow8"
            )
        )
        return shows
    }


}