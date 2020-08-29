package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Comment
import com.example.todaysshow.`object`.Journal
import org.w3c.dom.Text

class CommentAdapter (comments: ArrayList<Comment>, context: Context) :
    RecyclerView.Adapter<CommentAdapter.CommentHolder>() {

    var comments = comments
    var context = context

    class CommentHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var profileImageView : ImageView = itemView.findViewById(R.id.comment_user_profile_iv)
        var profileNameTextView : TextView = itemView.findViewById(R.id.comment_user_name_tv)
        var commentTextView : TextView = itemView.findViewById(R.id.comment_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.journal_detail_comment_list_item, parent, false)
        return CommentAdapter.CommentHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        val comment: Comment = comments.get(position)
        holder.profileImageView.setImageResource(comment.profileResource)
        holder.profileNameTextView.setText(comment.profileName)
        holder.commentTextView.setText(comment.comment)

    }
}