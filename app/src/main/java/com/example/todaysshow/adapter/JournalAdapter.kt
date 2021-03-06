package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.RecyclerItemClickListener
import com.example.todaysshow.`object`.Journal
import com.example.todaysshow.fragment.CommunityFragment
import com.mikhaellopez.circularimageview.CircularImageView

class JournalAdapter(journals: ArrayList<Journal>, context: Context, itemClickListener: ItemClickListener) : RecyclerView.Adapter<JournalAdapter.JournalHolder>() {
    var journals : ArrayList<Journal> = journals
    var context : Context = context
    var itemClickListener = itemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.journal_list_item, parent, false)
        return JournalAdapter.JournalHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: JournalHolder, position: Int) {
        val journal: Journal = journals.get(position)
        holder.journal_tv.text = journal.getJournalStr()
        holder.journal_iv.setImageResource(journal.getImageResource())
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(holder, journal, position)
        }
    }

    override fun getItemCount(): Int {
        return journals.size
    }


    class JournalHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var journal_tv = itemView?.findViewById<TextView>(R.id.journal_tv)
        var journal_iv = itemView?.findViewById<CircularImageView>(R.id.journal_iv);
    }
}