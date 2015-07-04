package com.example.administrator.tiantgy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/7/3.
 */
public class FruitfoodVPagerAdapter extends FragmentPagerAdapter {
   private List<Fragment> fragments;
    public FruitfoodVPagerAdapter(FragmentManager fm,List<Fragment> fragment) {
        super(fm);
        this.fragments=fragment;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments!=null&&!fragments.isEmpty()?fragments.size():0;
    }
}
