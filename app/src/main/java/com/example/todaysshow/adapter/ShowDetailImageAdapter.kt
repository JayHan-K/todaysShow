package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show

class ShowDetailImageAdapter (imageResources: ArrayList<Int>, context: Context) :
    (RecyclerView.Adapter<ShowDetailImageAdapter.ShowDetailImageHolder>)() {
    var imageResources = imageResources
    var context = context


    class ShowDetailImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var showDetailImageView : ImageView = itemView.findViewById(R.id.show_detail_image_iv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShowDetailImageAdapter.ShowDetailImageHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.show_detail_image_layout, parent, false)
        return ShowDetailImageAdapter.ShowDetailImageHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return imageResources.size
    }

    override fun onBindViewHolder(
        holder: ShowDetailImageAdapter.ShowDetailImageHolder,
        position: Int
    ) {
        var imageResource: Int = imageResources.get(position)
        holder.showDetailImageView.setImageResource(imageResource)
        holder.showDetailImageView.scaleType = ImageView.ScaleType.FIT_XY
    }


}