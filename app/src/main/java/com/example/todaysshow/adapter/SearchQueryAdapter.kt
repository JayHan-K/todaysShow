package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.TodayShowApplication

class SearchQueryAdapter(context: Context) : RecyclerView.Adapter<SearchQueryAdapter.SearchQueryHolder>(),
    Filterable {
    var context: Context = context
    var popularList: ArrayList<String> = TodayShowApplication.instance.popularSearchList
    var defaultList: ArrayList<String> = TodayShowApplication.instance.defaultSearchList
    var filteredList: ArrayList<String> = popularList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchQueryHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.search_list_item, parent, false)
        return SearchQueryAdapter.SearchQueryHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: SearchQueryHolder, position: Int) {
        val query : String = filteredList.get(position)
        holder.searchQueryTv.setText(query)
        holder.searchQueryTv.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
       return object: Filter(){
           override fun performFiltering(constraint: CharSequence?): FilterResults {
               val charString: String = constraint.toString()
               if(charString.isEmpty()){
                   filteredList = popularList
               }else{
                   var filteringList : ArrayList<String> = ArrayList()
                   for (name in defaultList){
                       if(name.toLowerCase().contains(charString.toLowerCase())){
                           filteringList.add(name)
                       }
                   }
                   filteredList = filteringList
               }
               val filterResults : FilterResults = FilterResults()
               filterResults.values = filteredList
               return filterResults
           }

           override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
               filteredList = results!!.values as ArrayList<String>
               notifyDataSetChanged()
           }
       }
    }

    class SearchQueryHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var searchQueryTv = itemView?.findViewById<TextView>(R.id.search_query_tv)
        init {
            itemView.setOnClickListener(View.OnClickListener {
                var pos : Int = adapterPosition
                if(pos != RecyclerView.NO_POSITION){

                }
            })
        }
    }


}