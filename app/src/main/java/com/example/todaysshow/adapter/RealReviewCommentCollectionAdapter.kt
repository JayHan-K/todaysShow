package com.example.todaysshow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.R
import com.example.todaysshow.`object`.DetailComment

class RealReviewCommentCollectionAdapter (comments: ArrayList<DetailComment>, context: Context) :
    RecyclerView.Adapter<RealReviewCommentCollectionAdapter.RealReviewCommentCollectionHolder>() {
    var comments = comments
    var context = context

    class RealReviewCommentCollectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var realReviewCommentEditorProfileImageView : ImageView = itemView.findViewById(R.id.real_review_comment_collection_editor_profile_iv)
        var realReviewCommentEditorNameTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_editor_name_tv)
        var realReviewCommentEditorInformationTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_editor_info_tv)
        var realReviewCommentRecommendIconImageView : ImageView = itemView.findViewById(R.id.real_review_comment_collection_recommend_icon_iv)
        var realReviewCommentGoodTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_good_tv)
        var realReviewCommentBadTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_bad_tv)
        var realReviewHeartTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_heart_tv)
        var realReviewCommentCommentTextView : TextView = itemView.findViewById(R.id.real_review_comment_collection_comment_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealReviewCommentCollectionHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.real_review_collection_comment_item, parent, false)
        return RealReviewCommentCollectionAdapter.RealReviewCommentCollectionHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: RealReviewCommentCollectionHolder, position: Int) {
        var comment : DetailComment = comments.get(position)
        holder.realReviewCommentEditorProfileImageView.setImageResource(comment.imageResource)
        holder.realReviewCommentEditorNameTextView.setText(comment.editorName)
        holder.realReviewCommentEditorInformationTextView.setText(comment.info)
        if(comment.isGood){
            holder.realReviewCommentRecommendIconImageView.setImageResource(R.drawable.icon_good)
        }else{
            holder.realReviewCommentRecommendIconImageView.setImageResource(R.drawable.icon_bad)
        }
        holder.realReviewCommentGoodTextView.setText(comment.goodThing)
        holder.realReviewCommentBadTextView.setText(comment.badThing)
        holder.realReviewHeartTextView.setText(comment.heart.toString())
        holder.realReviewCommentCommentTextView.setText(comment.comment.toString())
    }
}