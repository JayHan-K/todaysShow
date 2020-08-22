package com.example.todaysshow

import androidx.recyclerview.widget.RecyclerView
import java.util.*

interface ItemClickListener {
    fun onItemClicked(vh :RecyclerView.ViewHolder, item : Any, pos: Int)
}