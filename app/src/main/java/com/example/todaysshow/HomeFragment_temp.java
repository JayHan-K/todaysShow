package com.example.todaysshow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment_temp extends Fragment {

    RecyclerView home_journal_rv;
    LinearLayout home_journal_ll;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_home_fragment,null);

        home_journal_rv = (RecyclerView) viewGroup.findViewById(R.id.home_journal_rv);
        home_journal_ll = (LinearLayout) viewGroup.findViewById(R.id.home_journal_ll);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ArrayList<Journal> journalArrayList = getJournalList();
        JournalAdapter journalAdapter = new JournalAdapter(journalArrayList, getContext());
        home_journal_rv.setLayoutManager(layoutManager);
        home_journal_rv.setAdapter(journalAdapter);

        return viewGroup;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public ArrayList<Journal> getJournalList(){
        ArrayList<Journal> journals = new ArrayList<>();
        journals.add(new Journal("2020\n공연트렌트", R.drawable.empty_circle));
        journals.add(new Journal("샤롯데 씨어\n첫! 방문기", R.drawable.empty_circle));
        journals.add(new Journal("나는\n도대체 어디...?", R.drawable.empty_circle));
        journals.add(new Journal("4대 뮤지컬\n오페라의 유령", R.drawable.empty_circle));

        return journals;

    }
}
