package com.example.todaysshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search_fragment.*;

class SearchFragment : Fragment() {

    var search_result_rv : RecyclerView? = null

    lateinit var searchQueryAdapter : SearchQueryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup:ViewGroup = inflater.inflate(R.layout.activity_search_fragment, null) as ViewGroup

        search_result_rv = viewGroup.findViewById<RecyclerView>(R.id.search_result_rv) as RecyclerView
        search_result_rv!!.layoutManager = LinearLayoutManager(context)

        var searchbar = viewGroup.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_bar)


        searchbar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                searchQueryAdapter.filter.filter(newText)
                Log.i("Filter" , newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

        })


        setPopularSearch()


        /*
        childFragmentManager.beginTransaction().replace(R.id.search_frame,
            SearchResultFragment("Opera")
        ).commitAllowingStateLoss()
        */


        return viewGroup
    }

    private fun setPopularSearch(){
        val searchList = ArrayList<String>()
        searchList.add("The Phantom of the Opera")
        searchList.add("CATS")
        searchList.add("오백에 삼십")
        searchList.add("쉬어 매드니스")
        searchList.add("42nd Street")
        searchList.add("RENT")

        searchQueryAdapter = SearchQueryAdapter(searchList, context)


        search_result_rv!!.adapter = searchQueryAdapter
        search_result_rv!!.addOnItemTouchListener(
            RecyclerItemClickListener(requireContext(), search_result_rv!!, object : RecyclerItemClickListener.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    var str = searchQueryAdapter.filteredList.get(position)

                }

            })
        )


    }


}
