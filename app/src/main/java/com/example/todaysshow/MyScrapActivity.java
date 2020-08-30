package com.example.todaysshow;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todaysshow.adapter.MyPageReviewCommentAdapter;
import com.example.todaysshow.adapter.MyPageScrapJournalAdapter;
import com.example.todaysshow.fragment.community.CommunityHotIssue;
import com.example.todaysshow.object.Journal;

import java.util.ArrayList;

public class MyScrapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myscrap);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.myscrap_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        ArrayList<Journal> journals = new ArrayList<>();

        journals.add(
                new Journal(
                        "모든 이야기의 시작,\n오이디푸스",
                        R.drawable.hot_issue_sample2
                )
        );
        journals.add(
                new Journal(
                        "세계 4대 뮤지컬을 알려줄게 1편, 캣츠",
                        R.drawable.hot_issue_sample3
                )
        );
        journals.add(
                new Journal(
                        "혼자가 딱 좋아!\n혼공 라이프",
                        R.drawable.hot_issue_sample5
                )
        );
        recyclerView.setAdapter(new MyPageScrapJournalAdapter(journals,getApplicationContext()));

    }
}
