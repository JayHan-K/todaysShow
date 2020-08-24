package com.example.todaysshow.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.todaysshow.fragment.category.CategoryClassic;
import com.example.todaysshow.fragment.category.CategoryMusical;
import com.example.todaysshow.fragment.category.CategoryPlay;
import com.example.todaysshow.fragment.category.CategoryTotal;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
    int num;

    public CategoryPagerAdapter(FragmentManager fm, int num){
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CategoryTotal tab1 = new CategoryTotal();
                return tab1;

            case 1:
                CategoryMusical tab2 = new CategoryMusical();
                return tab2;

            case 2:
                CategoryPlay tab3 = new CategoryPlay();
                return tab3;

            case 3:
                CategoryClassic tab4 = new CategoryClassic();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}