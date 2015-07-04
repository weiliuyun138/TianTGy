package com.example.administrator.tiantgy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.FruitfoodVPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitfoodFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private RadioGroup radioGroup;
    private ImageView login;
    private ViewPager viewPager;
    private FruitfoodVPagerAdapter vPagerAdapter;
    private List<Fragment> list;

    public FruitfoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fruitfood, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.fruitfood_rg);
        radioGroup.setOnCheckedChangeListener(this);
        login = (ImageView) view.findViewById(R.id.fruitfood_login);
        login.setOnClickListener(this);
        viewPager = (ViewPager) view.findViewById(R.id.fruitfood_viewpager);
        viewPager.setOnPageChangeListener(this);
        list=new ArrayList<>();
        list.add(new FruitfoodEncyclopediaFragment());
        list.add(new FruitfoodFruitfrientFragment());
        vPagerAdapter=new FruitfoodVPagerAdapter(getFragmentManager(),list);
        viewPager.setAdapter(vPagerAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fruitfood_login:

                break;
            case R.id.fruitfood_loginchat:

                break;


        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.fruitfood_rb_encyclopedia://百科
                viewPager.setCurrentItem(0);
                break;

            case R.id.fruitfood_rb_fruitfriend: //果友圈
                viewPager.setCurrentItem(1);
                break;

        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
        radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
