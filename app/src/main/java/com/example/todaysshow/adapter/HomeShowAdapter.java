package com.example.todaysshow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysshow.object.HomeShow;
import com.example.todaysshow.R;

import java.util.ArrayList;

public class HomeShowAdapter extends RecyclerView.Adapter<HomeShowAdapter.HomeShowItemView> {
    public ArrayList<HomeShow> homeShows;
    public Context context;

    public HomeShowAdapter(ArrayList<HomeShow> homeShows, Context context){
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

    public class HomeShowItemView extends RecyclerView.ViewHolder {

        ImageView home_show_iv;

        public HomeShowItemView(@NonNull View itemView) {
            super(itemView);
            home_show_iv = (ImageView) itemView.findViewById(R.id.home_show_iv);

        }
    }
}
