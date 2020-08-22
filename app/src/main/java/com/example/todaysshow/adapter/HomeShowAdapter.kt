package com.example.todaysshow.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.ShowDetailActivity
import com.example.todaysshow.`object`.HomeShow

class HomeShowAdapter(homeShows: ArrayList<HomeShow>, context : Context) :
    RecyclerView.Adapter<HomeShowAdapter.HomeShowHolder>() {
    public var homeShows: ArrayList<HomeShow> = homeShows
    public var context: Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeShowHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.home_show_list_item, parent, false)
        return HomeShowAdapter.HomeShowHolder(inflatedView)
    }
    override fun onBindViewHolder(holder: HomeShowHolder, position: Int) {
        var homeShow : HomeShow = homeShows.get(position)
        holder.homeShowIV.setBackgroundResource(homeShow.getImageResource())
        holder.homeShowIV.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, homeShow.getShowName(), Toast.LENGTH_SHORT).show()
            var intent : Intent = Intent(context, ShowDetailActivity::class.java)
            context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return homeShows.size
    }
    class HomeShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeShowIV = itemView?.findViewById<ImageView>(R.id.home_show_iv)
    }




}