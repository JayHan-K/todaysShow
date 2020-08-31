package com.example.todaysshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.todaysshow.MyQnAActivity;
import com.example.todaysshow.MyReviewActivity;
import com.example.todaysshow.MyScrapActivity;
import com.example.todaysshow.R;

public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance(){
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_profile_fragment, container, false);
        Button review_btn = (Button)rootView.findViewById(R.id.review_btn);
        Button scrap_btn = (Button)rootView.findViewById(R.id.scrap_btn);
        Button qna_btn = (Button)rootView.findViewById(R.id.qna_btn);

        review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyReviewActivity.class);
                startActivity(intent);
            }
        });

        scrap_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyScrapActivity.class);
                startActivity(intent);
            }
        });

        qna_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyQnAActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
