package com.example.todaysshow.fragment.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.cursoradapter.widget.CursorAdapter
import androidx.fragment.app.Fragment
import com.example.todaysshow.R
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter

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
        //communityRealReviceSearchBar!!.suggestionsAdapter = RealReviewSearchSuggestionAdapter(context!!, cursor = null) as CursorAdapter


        return viewGroup
    }
}
