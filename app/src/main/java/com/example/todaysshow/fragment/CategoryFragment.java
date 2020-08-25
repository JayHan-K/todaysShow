package com.example.todaysshow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todaysshow.adapter.CategoryPagerAdapter;
import com.example.todaysshow.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class CategoryFragment extends Fragment {
    ViewPager viewPager;
    CategoryPagerAdapter adapter;

    public CategoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_category, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab((tabLayout.newTab().setText("전체")));
        tabLayout.addTab((tabLayout.newTab().setText("뮤지컬")));
        tabLayout.addTab((tabLayout.newTab().setText("연극")));
        tabLayout.addTab((tabLayout.newTab().setText("클래식")));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new CategoryPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return rootView;
    }
}

