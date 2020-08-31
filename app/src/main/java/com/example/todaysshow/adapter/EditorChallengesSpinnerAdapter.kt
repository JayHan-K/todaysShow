package com.example.todaysshow.adapter

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import android.widget.TextView
import com.example.todaysshow.R

class EditorChallengesSpinnerAdapter(items: ArrayList<String>, context: Context) : BaseAdapter(), SpinnerAdapter {
    var items = items
    var context = context
    var inflater : LayoutInflater? = null

    init {
        inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView : View = inflater!!.inflate(R.layout.adapter_editor_chanllenges_spinner_list, parent, false)
        var textView : TextView = itemView.findViewById(R.id.adapter_editor_chanllenges_spinner_list_tv)
        textView.setText(items.get(position))

        return itemView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView : View = inflater!!.inflate(R.layout.adapter_editor_chanllenges_spinner, parent, false)
        var textView : TextView = itemView.findViewById(R.id.spinner_list_item_tv)
        if (position>=10){
            textView.setText("소분류 선택")
        }else{
            textView.setText(items.get(position))
        }


        return itemView
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