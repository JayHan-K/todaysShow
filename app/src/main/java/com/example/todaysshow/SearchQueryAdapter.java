package com.example.todaysshow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchQueryAdapter extends RecyclerView.Adapter<SearchQueryAdapter.SearchQueryItemView> implements Filterable {

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    ArrayList<String> searchList;
    Context context;
    ArrayList<String> filteredList;
    ArrayList<String> unFilteredList;

    SearchQueryAdapter(ArrayList<String> searchList, Context context){
        this.searchList = searchList;
        this.unFilteredList = searchList;
        this.filteredList = searchList;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchQueryItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_item, parent, false);
        return new SearchQueryItemView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchQueryItemView holder, int position) {
        final String searchStr = filteredList.get(position);
        holder.search_qeury_tv.setText(searchStr);
        //holder.journal_iv.setImageResource(journal.getImageResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, searchStr , Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    filteredList = unFilteredList;
                }else{
                    ArrayList<String> filteringList = new ArrayList<>();
                    for(String name : unFilteredList){
                        if(name.toLowerCase().contains(charString.toLowerCase())){
                            filteringList.add(name);
                        }
                    }
                    filteredList = filteringList;
                }
                for(String name : filteredList){
                    Log.i("Filtered", name);
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<String>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class SearchQueryItemView extends RecyclerView.ViewHolder {
        TextView search_qeury_tv;

        public SearchQueryItemView(@NonNull final View itemView) {
            super(itemView);
            search_qeury_tv = (TextView) itemView.findViewById(R.id.search_query_tv);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(mListener != null){
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }

}

