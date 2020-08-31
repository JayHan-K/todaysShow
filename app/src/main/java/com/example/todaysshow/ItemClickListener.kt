package com.example.todaysshow

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.adapter.RealReviewSearchSuggestionAdapter
import java.util.*

interface ItemClickListener {
    fun onItemClicked(vh :RecyclerView.ViewHolder, item : Any, pos: Int)
    fun onItemClicked(v : RealReviewSearchSuggestionAdapter.ViewHolder, item : Any, pos: Int)
}