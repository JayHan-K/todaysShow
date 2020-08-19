package com.example.todaysshow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysshow.R;

import java.util.ArrayList;

public class SearchResultRelationListAdapter extends RecyclerView.Adapter<SearchResultRelationListAdapter.SearchResultRelationItemView> {
    public ArrayList<String> relationList;
    public Context context;
    public SearchResultRelationListAdapter(ArrayList<String> relationList, Context context){
        this.relationList = relationList;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchResultRelationItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_relation_list_item, parent, false);
        return new SearchResultRelationItemView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultRelationItemView holder, int position) {
        final String relation = relationList.get(position);
        holder.searchRelationBt.setText(relation);
        holder.searchRelationBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, relation, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return relationList.size();
    }

    public class SearchResultRelationItemView extends RecyclerView.ViewHolder {
        Button searchRelationBt;

        public SearchResultRelationItemView(@NonNull final View itemView) {
            super(itemView);
            searchRelationBt = (Button) itemView.findViewById(R.id.search_relation_bt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {

                    }
                }
            });
        }
    }
}
