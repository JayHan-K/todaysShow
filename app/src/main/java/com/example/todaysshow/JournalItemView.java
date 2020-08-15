package com.example.todaysshow;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JournalItemView extends RecyclerView.ViewHolder {
    TextView journal_tv;
    ImageView journal_iv;

    public JournalItemView(@NonNull View itemView) {
        super(itemView);
        journal_tv = (TextView) itemView.findViewById(R.id.journal_tv);
        journal_iv = (ImageView) itemView.findViewById(R.id.journal_iv);
    }


}
