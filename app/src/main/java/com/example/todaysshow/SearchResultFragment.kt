package com.example.todaysshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.search_result_layout.*

class SearchResultFragment(resultStr : String) : Fragment() {
    var searchResultStr = resultStr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup: ViewGroup = inflater.inflate(R.layout.search_result_layout, null) as ViewGroup

        var searchResultTv = viewGroup.findViewById<TextView>(R.id.search_result_tv) as TextView
        searchResultTv.setText(searchResultStr)

        return viewGroup
    }


}
