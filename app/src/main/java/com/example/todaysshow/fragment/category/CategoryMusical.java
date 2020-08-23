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

import com.example.todaysshow.R;

public class CategoryMusical extends ListFragment {
    public CategoryMusical(){
        
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categroy_listview,container,false);

        String[] LIST_MENU = {"인기작","주크박스/댄스 뮤지컬","대극장 뮤지컬", "중,소극장 뮤지컬","소설 원작","창작 뮤지컬","토니 어워즈 수상작","역사","로맨스","공포/스릴러","드라마/감동","어린이 뮤지컬"};
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,LIST_MENU);
        setListAdapter(listViewAdapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String strText = (String) l.getItemAtPosition(position);
        Log.d("Fragment: ", position + ": " +strText);
        Toast.makeText(this.getContext(), "클릭: " + position +" " + strText, Toast.LENGTH_SHORT).show();
    }

}
