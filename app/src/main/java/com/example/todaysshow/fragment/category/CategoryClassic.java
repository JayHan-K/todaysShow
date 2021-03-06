package com.example.todaysshow.fragment.category;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.todaysshow.CategoryActivity;
import com.example.todaysshow.R;

public class CategoryClassic extends ListFragment {
    public CategoryClassic(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categroy_listview,container,false);

        String[] LIST_MENU = {"인기작","오페라","오케스트라", "현악중주","관악중주","합창","콩쿨","바로크 시대","고전 시대","낭만 시대","르네상스 시대","현대 시대"};
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.category_tab_list_text,LIST_MENU);
        setListAdapter(listViewAdapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String strText = (String) l.getItemAtPosition(position);
        //Log.d("Fragment: ", position + ": " +strText);
        //Toast.makeText(this.getContext(), "클릭: " + position +" " + strText, Toast.LENGTH_SHORT).show();
        String category = "클래식 | " + strText;
        ((CategoryActivity)getActivity()).closeAndChangeDeatil(category);

    }
}