package com.example.todaysshow.fragment.community

import android.app.SearchManager
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.todaysshow.R
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter
import java.util.*


class CommunityRealReview : Fragment() {
    var communityRealReviceSearchBar : SearchView? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.activity_community_real_review_fragment, null) as ViewGroup

        communityRealReviceSearchBar = viewGroup.findViewById(R.id.community_real_review_search_bar)
        communityRealReviceSearchBar!!.setIconifiedByDefault(false)

        var searchManager : SearchManager = context!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        communityRealReviceSearchBar!!.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName));
        var a : Array<out String>
        a = arrayOf("showName")
        var b : IntArray
        b = intArrayOf(R.id.real_review_suggestion_iv,R.id.real_review_suggestion_title_tv, R.id.real_review_suggestion_tag_tv, R.id.real_review_suggestion_date_tv)
        communityRealReviceSearchBar!!.suggestionsAdapter = RealReviewSearchSuggestionAdapter(context!!,a, b)






        return viewGroup
    }

}
