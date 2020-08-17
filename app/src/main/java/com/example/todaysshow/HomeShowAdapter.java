package com.example.todaysshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeShowAdapter extends RecyclerView.Adapter<HomeShowItemView> {
    ArrayList<HomeShow> homeShows;
    Context context;

    HomeShowAdapter(ArrayList<HomeShow> homeShows, Context context){
        this.homeShows = homeShows;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeShowItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_show_list_item, parent, false);
        return new HomeShowItemView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeShowItemView holder, int position) {
        final HomeShow homeShow = homeShows.get(position);
        holder.home_show_iv.setImageResource(homeShow.getImageResouce());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, homeShow.getShowName() + " ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeShows.size();
    }
}
