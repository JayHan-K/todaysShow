package com.example.todaysshow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysshow.object.Journal;
import com.example.todaysshow.R;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalItemView> {
    public ArrayList<Journal> horizontalList;
    public Context context;
    public JournalAdapter(ArrayList<Journal> horizontalList, Context context){
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
        final Journal journal = horizontalList.get(position);
        holder.journal_tv.setText(journal.getJournalStr());
        //holder.journal_iv.setImageResource(journal.getImageResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, journal.getJournalStr() + " " , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class JournalItemView extends RecyclerView.ViewHolder {
        TextView journal_tv;
        ImageView journal_iv;

        public JournalItemView(@NonNull View itemView) {
            super(itemView);
            journal_tv = (TextView) itemView.findViewById(R.id.journal_tv);
            journal_iv = (ImageView) itemView.findViewById(R.id.journal_iv);
        }


    }


}
