package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.view.marginRight
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show
import kotlinx.android.synthetic.main.home_show_list_item.view.*

class SearchResultImageAdapter(shows: ArrayList<Show>,context: Context, itemClickListener: ItemClickListener) :
    (RecyclerView.Adapter<SearchResultImageAdapter.SearchResultImageHolder>)() {
    var shows = shows
    var context = context
    var itemClickListener = itemClickListener


    class SearchResultImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var showListItem : ImageView = itemView.findViewById(R.id.home_show_iv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultImageAdapter.SearchResultImageHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_show_list_item, parent, false)
        return SearchResultImageAdapter.SearchResultImageHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    override fun onBindViewHolder(
        holder: SearchResultImageAdapter.SearchResultImageHolder,
        position: Int
    ) {
        var show:Show = shows.get(position)
        holder.showListItem.setImageResource(show.getImageResource())
        setMarginsInDp(holder.showListItem, 0,0,0,2)
        setSizeInDP(holder.showListItem, 100, 135)
        holder.showListItem.scaleType = ImageView.ScaleType.FIT_XY
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(holder, show, position)
        }
    }

    fun setMarginsInDp(view: View, left: Int, top: Int, right: Int, bottom: Int){
        if(view.layoutParams is ViewGroup.MarginLayoutParams){
            val screenDensity : Float = view.context.resources.displayMetrics.density
            val params: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(left*screenDensity.toInt(), top*screenDensity.toInt(), right*screenDensity.toInt(), bottom*screenDensity.toInt())
            view.requestLayout()
        }
    }
    fun setSizeInDP(view: View, width: Int, height: Int){
        if(view.layoutParams is ViewGroup.LayoutParams){
            val screenDensity : Float = view.context.resources.displayMetrics.density
            val params : ViewGroup.LayoutParams = view.layoutParams as ViewGroup.LayoutParams
            params.width = (width * screenDensity + 0.5F).toInt()
            params.height = (height * screenDensity + 0.5F).toInt()
            view.requestLayout()
        }
    }

    fun pxToDp(context: Context, px: Float) : Float {
        var screenDensity: Float = context.resources.displayMetrics.density
        when(screenDensity){
            1.0F -> screenDensity *= 4.0F
            1.5F -> screenDensity *= (8/3)
            2.0F -> screenDensity *= 2.0F
        }
        return px / screenDensity
    }

}