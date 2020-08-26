package com.example.todaysshow.adapter

import android.content.Context
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal

class CommunityEditorsJournalAdapter (journals :ArrayList<Journal>, context: Context) :
    RecyclerView.Adapter<CommunityEditorsJournalAdapter.CommunityEditorsJournalHolder>() {

    var journals = journals
    var context = context


    class CommunityEditorsJournalHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var communityEditorJournalListImageView: ImageView = itemView.findViewById<ImageView>(R.id.editor_journal_list_iv)
        var communityEditorJournalTitleTextView: TextView = itemView.findViewById(R.id.editor_journal_list_title_tv)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommunityEditorsJournalHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.editors_journal_item, parent, false)
        return CommunityEditorsJournalAdapter.CommunityEditorsJournalHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return journals.size
    }

    override fun onBindViewHolder(holder: CommunityEditorsJournalHolder, position: Int) {
        val journal: Journal = journals.get(position)
        holder.communityEditorJournalListImageView.setImageResource(journal.getImageResource())

        var journalString = journal.getJournalStr()
        journalString = journalString.replace("\n","")
        holder.communityEditorJournalTitleTextView.setText(journalString)
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                journal.getJournalStr() + " ",
                Toast.LENGTH_SHORT
            ).show()
            //itemClickListener.onItemClicked(holder, journal, position)
        }
    }


}