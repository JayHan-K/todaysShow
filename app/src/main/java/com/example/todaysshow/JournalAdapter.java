package com.example.todaysshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<JournalItemView> {
    ArrayList<Journal> horizontalList;
    Context context;
    JournalAdapter(ArrayList<Journal> horizontalList, Context context){
        this.horizontalList = horizontalList;
        this.context = context;
    }

    @NonNull
    @Override
    public JournalItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_list_item, parent, false);
        return new JournalItemView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalItemView holder, int position) {
        Journal journal = horizontalList.get(position);
        holder.journal_tv.setText(journal.getJournalStr());
        //holder.journal_iv.setImageResource(journal.getImageResource());

    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
