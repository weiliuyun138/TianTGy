package com.example.administrator.tiantgy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.tiantgy.fragment.GuideFragment;

/**
 * Created by Administrator on 2015/6/22.
 */
public class GuideAdapter extends FragmentPagerAdapter {

    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return GuideFragment.getInstance(i);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
