package com.example.todaysshow.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R

class RealReviewSearchSuggestionAdapter(context: Context, cursor: Cursor? ) : CursorAdapter(context, cursor,0){
    var context = context
    var mCursor = cursor

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context!!).inflate(R.layout.real_review_suggestion_item, parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {

    }


}