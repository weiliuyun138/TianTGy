package com.example.administrator.tiantgy.fragment;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.activity.HomeSearchActivity;
import com.example.administrator.tiantgy.adapter.CategoryDetailAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener ,View.OnClickListener{
    private android.app.ActionBar actionBar;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton newCategory, hotBuy, price;
    private Button categorySearch;
    private TextView categoryBack;
    private CategoryDetailAdapter adapter;
    private List<Fragment> list;
    private HashMap<String, String> params1, params2, params3;

    public CategoryDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
//        initView(view);

        return view;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initView(View view) {
//        viewPager = (ViewPager) view.findViewById(R.id.category_viewpager);
        radioGroup = (RadioGroup) view.findViewById(R.id.category_rg);
        newCategory = (RadioButton) view.findViewById(R.id.category_rb_newcate);
        hotBuy = (RadioButton) view.findViewById(R.id.category_rb_hot);
        price = (RadioButton) view.findViewById(R.id.category_rb_price);
        categorySearch= (Button) view.findViewById(R.id.categorydetail_button_search);
        categoryBack= (TextView) view.findViewById(R.id.category_tv_back);
        categoryBack.setOnClickListener(this);
        categorySearch.setOnClickListener(this);
        viewPager.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        list = new ArrayList<>();
        getParamsData();
        list.add(new CategoryDetailNewCFragment());
        list.add(new CategoryDetailNewCFragment());
        list.add(new CategoryDetailPriceFragment());
        adapter = new CategoryDetailAdapter(getFragmentManager(), list);
        viewPager.setAdapter(adapter);
//        actionBar=getActivity().getActionBar();
    }


    /**
     * ViewPager 改变监听
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
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

    /**
     * RadioGroup 改变监听
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.category_rb_newcate:
                viewPager.setCurrentItem(0);
                break;
            case R.id.category_rb_hot:
                viewPager.setCurrentItem(1);
                break;
            case R.id.category_rb_price:
                viewPager.setCurrentItem(2);
                break;
        }

    }


    private void getParamsData() {
        params1 = new HashMap<>();
        params2 = new HashMap<>();
        params3 = new HashMap<>();

        params1.put("sign", "e30a704efe8f8a2976da5e703795bc99");
        params1.put("source", "app");
        params1.put("curr_page", "0");
        params1.put("timestamp", "1435470754");
        params1.put("service", "product.category");
        params1.put("connect_id", "");
        params1.put("platform", "ANDROID");
        params1.put("device_id", "6730e871823c2475f7d4a164859a2857");
        params1.put("version", "2.1.1");
        params1.put("page_size", "20");
        params1.put("class_id", "40");
        params1.put("region_id", "143949");
        params1.put("sort", "0");
        params1.put("channel", "googleplay");

        params2.put("sign", "50fd68d8680db9dae466d8eba85dd5ba");
        params2.put("source", "app");
        params2.put("curr_page", "0");
        params2.put("timestamp", "1435470821");
        params2.put("service", "product.category");
        params2.put("connect_id", "");
        params2.put("platform", "ANDROID");
        params2.put("device_id", "6730e871823c2475f7d4a164859a2857");
        params2.put("version", "2.1.1");
        params2.put("page_size", "20");
        params2.put("class_id", "40");
        params2.put("region_id", "143949");
        params2.put("sort", "2");
        params2.put("channel", "googleplay");

        params3.put("sign", "00392adb381ad4d5e58c69a0d8cb475a");
        params3.put("source", "app");
        params3.put("curr_page", "0");
        params3.put("timestamp", "1435470952");
        params3.put("service", "product.category");
        params3.put("connect_id", "");
        params3.put("platform", "ANDROID");
        params3.put("device_id", "6730e871823c2475f7d4a164859a2857");
        params3.put("version", "2.1.1");
        params3.put("page_size", "20");
        params3.put("class_id", "40");
        params3.put("region_id", "143949");
        params3.put("sort", "2");
        params3.put("channel", "googleplay");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent=new Intent();
        switch (id){
            case R.id.categorydetail_button_search:
                intent.setClass(getActivity(), HomeSearchActivity.class);
                break;
            case R.id.category_tv_back:
                getActivity().finish();
                break;

        }

        startActivity(intent);

    }
}
