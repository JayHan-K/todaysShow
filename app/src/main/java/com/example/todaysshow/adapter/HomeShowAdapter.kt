package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show

class HomeShowAdapter(homeShows: ArrayList<Show>, context : Context, itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<HomeShowAdapter.HomeShowHolder>() {
    public var homeShows: ArrayList<Show> = homeShows
    public var context: Context = context
    var itemClickListener = itemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeShowHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_show_list_item, parent, false)
        return HomeShowAdapter.HomeShowHolder(inflatedView)
    }
    override fun onBindViewHolder(holder: HomeShowHolder, position: Int) {
        var homeShow : Show = homeShows.get(position)
        holder.homeShowIV.setBackgroundResource(homeShow.imageSource)
        setMarginsInDp(holder.homeShowIV, 0,0,25, 0)
        holder.homeShowIV.setOnClickListener(View.OnClickListener {
            itemClickListener.onItemClicked(holder, homeShow, position)
        })

    }

    override fun getItemCount(): Int {
        return homeShows.size
    }
    class HomeShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeShowIV = itemView?.findViewById<ImageView>(R.id.home_show_iv)
    }

    fun setMarginsInDp(view: View, left: Int, top: Int, right: Int, bottom: Int){
        if(view.layoutParams is ViewGroup.MarginLayoutParams){
            val screenDensity : Float = view.context.resources.displayMetrics.density
            val params: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(left*screenDensity.toInt(), top*screenDensity.toInt(), right*screenDensity.toInt(), bottom*screenDensity.toInt())
            view.requestLayout()
        }
    }




}