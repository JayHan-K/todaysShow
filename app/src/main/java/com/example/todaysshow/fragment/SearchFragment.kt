package com.example.todaysshow.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.RecyclerItemClickListener
import com.example.todaysshow.fragment.search.SearchResultFragment
import com.example.todaysshow.TodayShowApplication
import com.example.todaysshow.adapter.SearchQueryAdapter

class SearchFragment : Fragment() {

    var search_result_rv : RecyclerView? = null
    var searchbar : androidx.appcompat.widget.SearchView? = null
    var search_pop_rec : TextView? = null
    var searchFrameLayout : FrameLayout? = null
    var searchLinearLayout : LinearLayout? = null

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
        searchFrameLayout = viewGroup.findViewById(R.id.search_frame)
        searchLinearLayout = viewGroup.findViewById(R.id.search_list_ll)
        search_pop_rec = viewGroup.findViewById(R.id.search_pop_rec_tv)

        searchFrameLayout!!.visibility = View.INVISIBLE
        searchLinearLayout!!.visibility = View.VISIBLE

        search_result_rv = viewGroup.findViewById<RecyclerView>(R.id.search_result_rv) as RecyclerView
        search_result_rv!!.layoutManager = LinearLayoutManager(context)

        searchbar = viewGroup.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_bar)
        searchbar!!.setIconifiedByDefault(false)
        searchbar!!.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                searchFrameLayout!!.visibility = View.INVISIBLE
                searchLinearLayout!!.visibility = View.VISIBLE

                if(newText.equals("")){
                    search_pop_rec!!.setText("인기 검색어")
                }else{
                    search_pop_rec!!.setText("추천 검색어")
                }

                searchQueryAdapter.filter.filter(newText)
                Log.i("Filter" , newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchFrameLayout!!.visibility = View.VISIBLE
                searchLinearLayout!!.visibility = View.INVISIBLE

                childFragmentManager.beginTransaction().replace(
                    R.id.search_frame,
                    SearchResultFragment(
                        query!!
                    )
                ).commitAllowingStateLoss()
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
        val searchList = TodayShowApplication.instance.popularSearchList

        searchQueryAdapter = SearchQueryAdapter(
            searchList,
            context
        )


        search_result_rv!!.adapter = searchQueryAdapter
        search_result_rv!!.addOnItemTouchListener(
            RecyclerItemClickListener(
                requireContext(),
                search_result_rv!!,
                object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        var str = searchQueryAdapter.filteredList.get(position)
                        searchbar!!.setQuery(str, false)

                    }

                })
        )


    }


}
