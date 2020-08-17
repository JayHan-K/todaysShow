package com.example.todaysshow;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeShowItemView extends RecyclerView.ViewHolder {

    ImageView home_show_iv;

    public HomeShowItemView(@NonNull View itemView) {
        super(itemView);
        home_show_iv = (ImageView) itemView.findViewById(R.id.home_show_iv);

    }



}
