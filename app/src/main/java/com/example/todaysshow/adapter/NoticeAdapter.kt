package com.example.todaysshow.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Notice

class NoticeAdapter(notices: ArrayList<Notice>, context: Context): RecyclerView.Adapter<NoticeAdapter.NoticeHolder>() {

    var notices = notices
    var context = context

    class NoticeHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var importantNoticeImageView : ImageView = itemView.findViewById(R.id.important_notice_iv)
        var noticeTitleTextView : TextView = itemView.findViewById(R.id.notice_title_tv)
        var noticeInformationTextView : TextView = itemView.findViewById(R.id.notice_info_tv)
        var noticeRelativeLayout : RelativeLayout = itemView.findViewById(R.id.notice_rl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.notice_list_item, parent, false)
        return NoticeAdapter.NoticeHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return notices.size
    }

    override fun onBindViewHolder(holder: NoticeHolder, position: Int) {
        var notice: Notice = notices.get(position)
        if(notice.isImportant){
            holder.importantNoticeImageView.visibility = View.VISIBLE
            holder.noticeRelativeLayout.setBackgroundColor(Color.rgb(239,239,239))
            setMarginsInDp(holder.noticeTitleTextView, 76, 12 ,0 , 0)
            setMarginsInDp(holder.noticeInformationTextView, 76, 30 ,0 , 0)
        }else{
            holder.importantNoticeImageView.visibility = View.INVISIBLE
            holder.noticeRelativeLayout.setBackgroundColor(Color.rgb(255,255,255))
            setMarginsInDp(holder.noticeTitleTextView, 36, 12 ,0 , 0)
            setMarginsInDp(holder.noticeInformationTextView, 36, 30 ,0 , 0)
        }
        holder.noticeTitleTextView.setText(notice.title)
        holder.noticeInformationTextView.setText(notice.info)
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