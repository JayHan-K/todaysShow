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
import com.example.todaysshow.ItemClickListener
import com.example.todaysshow.R
import com.example.todaysshow.`object`.Show

class QnASearchSuggestionAdapter (context: Context, visibleColumnNamesArray : Array<out String>, idsArray: IntArray, itemClickListener: ItemClickListener) : SimpleCursorAdapter(context, R.layout.real_review_suggestion_item, null, visibleColumnNamesArray, idsArray, 0) {
    private val columnNamesArray =
        arrayOf("_id", "qnaTitle", "qnaDate", "qnaComment", "qnaView")
    private val visibleColumnNamesArray =
        arrayOf<String>("qnaTitle")
    var context = context
    var layoutInflater: LayoutInflater? = null
    var itemClickListener = itemClickListener

    var tempTitleArray: ArrayList<String> = ArrayList()
    var tempDateArray: ArrayList<String> = ArrayList()
    var tempCommentArray: ArrayList<String> = ArrayList()
    var tempViewArray: ArrayList<String> = ArrayList()

    init {
        layoutInflater = LayoutInflater.from(context)

        tempTitleArray.add("디큐브에서 길을 잃었어요ㅠㅠ 도와주세요")
        tempTitleArray.add("디큐브 자리 추천")
        tempTitleArray.add("디큐브 센터 불만사항")
        tempDateArray.add("2020.00.00")
        tempDateArray.add("2020.00.00")
        tempDateArray.add("2020.00.00")
        tempCommentArray.add("5")
        tempCommentArray.add("3")
        tempCommentArray.add("2")
        tempViewArray.add("32")
        tempViewArray.add("12")
        tempViewArray.add("47")
    }

    override fun runQueryOnBackgroundThread(constraint: CharSequence?): Cursor {
        return SuggestionCursor(constraint)
    }

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        val inflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View =
            inflater.inflate(R.layout.qna_suggestion_item, parent, false)
        val viewHolder = ViewHolder(rowView)
        rowView.tag = viewHolder
        return rowView
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        //super.bindView(view, context, cursor)
        var viewHolder: ViewHolder = view!!.tag as ViewHolder
        //var url = cursor!!.getString(2)
        //var name = cursor!!.getString(3)
        var pos = cursor!!.position
        viewHolder.qnaSuggestionTitleTextView.setText(tempTitleArray.get(pos))
        viewHolder.qnaSuggestionDateTextView.setText(tempDateArray.get(pos))
        viewHolder.qnaSuggestionCommentTextView.setText(tempCommentArray.get(pos))
        viewHolder.qnaSuggestionViewTextView.setText(tempViewArray.get(pos))
        view.setOnClickListener(View.OnClickListener {
        })
        //Glide.with(context).load(referenceUrl).into(viewHolder.categoryImageView)
    }

    class SuggestionCursor(constraint: CharSequence?) : AbstractCursor() {
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
            return 3
        }

        override fun getColumnNames(): Array<String> {
            return arrayOf("_id", "qnaTitle", "qnaDate", "qnaComment", "qnaView")
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
        var qnaSuggestionTitleTextView : TextView =
            view.findViewById(R.id.qna_suggestion_title_tv)
        var qnaSuggestionDateTextView: TextView =
            view.findViewById(R.id.qna_suggestion_date_tv)
        var qnaSuggestionCommentTextView: TextView =
            view.findViewById(R.id.qna_suggestion_comment_tv)
        var qnaSuggestionViewTextView: TextView =
            view.findViewById(R.id.qna_suggestion_view_tv)
    }

}