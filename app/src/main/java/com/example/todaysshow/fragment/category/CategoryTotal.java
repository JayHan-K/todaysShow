package com.example.todaysshow.fragment.category;

import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.todaysshow.CategoryActivity;
import com.example.todaysshow.MainActivity;
import com.example.todaysshow.R;
import com.example.todaysshow.fragment.HomeFragment;

public class CategoryTotal extends ListFragment {

    public CategoryTotal(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categroy_listview,container,false);

        String[] LIST_MENU = {"로맨스","코미디","드라마", "역사","스릴러","추리","공포","판타지","블랙 코미디","실화 바탕","러브 코미디","소설 원작"};
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.category_tab_list_text ,LIST_MENU);
        setListAdapter(listViewAdapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){

        String strText = (String) l.getItemAtPosition(position);
        //Log.d("Fragment: ", position + ": " +strText);
        //Toast.makeText(this.getContext(), "클릭: " + position +" " + strText, Toast.LENGTH_SHORT).show();
        String category = "전체 | " + strText;
        ((CategoryActivity)getActivity()).closeAndChangeDeatil(category);

    }
}