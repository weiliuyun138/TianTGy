package com.example.administrator.tiantgy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/6/28.
 */
public class CategoryDetailAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public CategoryDetailAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }
}
