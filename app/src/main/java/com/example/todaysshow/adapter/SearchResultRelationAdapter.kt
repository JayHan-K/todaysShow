package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R

class SearchResultRelationAdapter(relationList : ArrayList<String>, context: Context, itemClickListener: ItemClickListener) : RecyclerView.Adapter<SearchResultRelationAdapter.SearchResultRelationHolder>(){

    var relationList : ArrayList<String> = relationList
    var context: Context = context
    var itemClickListener = itemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultRelationHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.search_relation_list_item, parent, false)
        return SearchResultRelationAdapter.SearchResultRelationHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchResultRelationHolder, position: Int) {
        val relation = relationList[position]
        holder.searchRelationBt.text = relation
        holder.itemView.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClicked(holder, relation, position)
        })

    }

    override fun getItemCount(): Int {
        return relationList.size
    }

    class SearchResultRelationHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var searchRelationBt = itemView?.findViewById<TextView>(R.id.search_relation_bt)
    }
}