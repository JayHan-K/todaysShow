package com.example.todaysshow.adapter

import android.content.Context
import android.database.AbstractCursor
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show


class RealReviewSearchSuggestionAdapter(context: Context, visibleColumnNamesArray : Array<out String>, idsArray: IntArray ) : SimpleCursorAdapter(context, R.layout.real_review_suggestion_item, null, visibleColumnNamesArray, idsArray, 0){
    private val columnNamesArray =
        arrayOf("_id", "showName", "imageSource")
    private val visibleColumnNamesArray =
        arrayOf<String>("showName")
    var context = context
    var layoutInflater : LayoutInflater? = null

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun runQueryOnBackgroundThread(constraint: CharSequence?): Cursor {
        return SuggestionCursor(constraint)
    }

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        val inflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View =
            inflater.inflate(R.layout.real_review_suggestion_item, parent, false)
        val viewHolder = ViewHolder(rowView)
        rowView.tag = viewHolder
        return rowView
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        //super.bindView(view, context, cursor)
        var viewHolder : ViewHolder = view!!.tag as ViewHolder
        //var url = cursor!!.getString(2)
        //var name = cursor!!.getString(3)
        viewHolder.realReviewSuggestionTitleTextView.setText("titleText")
        viewHolder.realReviewSuggestionTagTextView.setText("tagText")
        viewHolder.realReviewSuggestionDateTextView.setText("2010")
        viewHolder.realReviewSuggestionImageView.setImageResource(R.drawable.poster_sample15)
        //Glide.with(context).load(referenceUrl).into(viewHolder.categoryImageView)
    }

    class SuggestionCursor(constraint: CharSequence?) : AbstractCursor(){
        val findCatagoriesList: List<Show> = ArrayList()
        var constraint = constraint
        init {
            if (constraint != null) {

            }
        }

        override fun getString(column: Int): String {

            return "test"
        }

        override fun getLong(column: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getColumnNames(): Array<String> {
            return arrayOf("_id", "showName","imageSource")
        }

        override fun getShort(column: Int): Short {
            return 0
        }

        override fun getFloat(column: Int): Float {
            return 0F
        }

        override fun getDouble(column: Int): Double {
            return 0.0
        }

        override fun isNull(column: Int): Boolean {
            return false
        }

        override fun getInt(column: Int): Int {
            return 0
        }

    }

    class ViewHolder(view: View) {
        var realReviewSuggestionImageView : ImageView = view.findViewById(R.id.real_review_suggestion_iv)
        var realReviewSuggestionTitleTextView : TextView = view.findViewById(R.id.real_review_suggestion_title_tv)
        var realReviewSuggestionTagTextView : TextView = view.findViewById(R.id.real_review_suggestion_tag_tv)
        var realReviewSuggestionDateTextView : TextView = view.findViewById(R.id.real_review_suggestion_date_tv)
    }

}