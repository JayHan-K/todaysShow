package com.example.todaysshow.adapter



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Journal
import com.makeramen.roundedimageview.RoundedImageView

class CommunityHotIssueJournalAdapter (journals: ArrayList<Journal>, context: Context, itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CommunityHotIssueJournalAdapter.CommunityHotIssueJournalHolder>() {

    var journals = journals
    var context = context
    var itemClickListener = itemClickListener

    class CommunityHotIssueJournalHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var communityHotIssueCardView : CardView = itemView.findViewById(R.id.community_hot_issue_cv)
        var communityHotIssueCardViewImageView : RoundedImageView = itemView.findViewById(R.id.community_hot_issue_cv_iv)
        var communityHotIssueCardViewIndexTextView : TextView = itemView.findViewById(R.id.community_hot_issue_cv_index_tv)
        var communityHotIssueCardViewTitleTextView : TextView = itemView.findViewById(R.id.community_hot_issue_cv_title_tv)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommunityHotIssueJournalHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.community_hot_issue_card_view, parent, false)
        return CommunityHotIssueJournalAdapter.CommunityHotIssueJournalHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return journals.size
    }

    override fun onBindViewHolder(holder: CommunityHotIssueJournalHolder, position: Int) {

        val journal: Journal = journals.get(position)
        holder.communityHotIssueCardViewImageView.setImageResource(journal.getImageResource())
        var str = "%02d".format(position+1)
        holder.communityHotIssueCardViewIndexTextView.setText(str)
        holder.communityHotIssueCardViewTitleTextView.setText(journal.getJournalStr())
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(holder, journal, position)
        }
    }
}