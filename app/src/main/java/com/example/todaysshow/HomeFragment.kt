package com.example.todaysshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home_fragment.*

class HomeFragment : Fragment() {

    var journalList : ArrayList<Journal>? = null

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
        val layoutManager : LinearLayoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        journalList = etJournalList()
        val journalAdapter = JournalAdapter(journalList, context)
        home_journal_rv.layoutManager = layoutManager
        home_journal_rv.adapter = journalAdapter


        return viewGroup
    }

    fun etJournalList() : ArrayList<Journal> {
        val journals = java.util.ArrayList<Journal>()
        journals.add(Journal("2020\n공연트렌트", R.drawable.empty_circle))
        journals.add(Journal("샤롯데 씨어\n첫! 방문기", R.drawable.empty_circle))
        journals.add(Journal("나는\n도대체 어디...?", R.drawable.empty_circle))
        journals.add(Journal("4대 뮤지컬\n오페라의 유령", R.drawable.empty_circle))

        return journals
    }
}