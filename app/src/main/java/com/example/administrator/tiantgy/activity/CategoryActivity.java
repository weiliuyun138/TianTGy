package com.example.administrator.tiantgy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.CategoryDetailAdapter;
import com.example.administrator.tiantgy.fragment.CategoryDetailHotFragment;
import com.example.administrator.tiantgy.fragment.CategoryDetailNewCFragment;
import com.example.administrator.tiantgy.fragment.CategoryDetailPriceFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_category)
public class CategoryActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private int position;
    private TextView name;
    private RadioGroup radioGroup;
    private RadioButton newCate, hot, price;
    private Button search;
    private ViewPager viewPager;
    private CategoryDetailAdapter categoryDetailAdapter;
    private List<Fragment> fragments;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        Intent intent = getIntent();
        position = Integer.parseInt(intent.getStringExtra("position"));
        initView();

    }

    private void initView() {
        actionBar = getSupportActionBar();
        actionBar.hide();
        name = (TextView) findViewById(R.id.category_tv_back);//标题
        radioGroup = (RadioGroup) findViewById(R.id.category_rg);
        newCate = (RadioButton) findViewById(R.id.category_rb_newcate);//新品
        hot = (RadioButton) findViewById(R.id.category_rb_hot);//热卖
        price = (RadioButton) findViewById(R.id.category_rb_price);//价格
        search = (Button) findViewById(R.id.categorydetail_button_search);//搜索
        viewPager = (ViewPager) findViewById(R.id.categoryd_viewpager);
        fragments = new ArrayList<>();

        viewPager.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        search.setOnClickListener(this);

        fragments.add(new CategoryDetailNewCFragment(position));
        fragments.add(new CategoryDetailHotFragment());
        fragments.add(new CategoryDetailPriceFragment());


        categoryDetailAdapter = new CategoryDetailAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(categoryDetailAdapter);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rb = (RadioButton) radioGroup.getChildAt(position);
        rb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

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

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(this, HomeSearchActivity.class);
        startActivity(intent1);
    }
}
