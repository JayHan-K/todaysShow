package com.example.todaysshow.adapter

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import android.widget.TextView

class EditorChallengesSpinnerAdapter(items: ArrayList<String>, context: Context) : BaseAdapter(), SpinnerAdapter {
    var items = items
    var context = context

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var textView : TextView = TextView(context)
        textView.setPadding(5,5,5,5)
        textView.textSize = 10F
        textView.gravity = Gravity.CENTER_VERTICAL
        textView.setText(items.get(position))
        textView.setTextColor(0x000000)
        return textView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var textView : TextView = TextView(context)
        textView.setPadding(5,5,5,5)
        textView.textSize = 10F
        textView.gravity = Gravity.CENTER
        textView.setCompoundDrawablesWithIntrinsicBounds(0 ,0, android.R.drawable.arrow_down_float, 0)
        textView.setText(items.get(position))
        textView.setTextColor(0x000000)
        return textView
    }

    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}