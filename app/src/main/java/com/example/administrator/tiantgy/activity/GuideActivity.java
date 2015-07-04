package com.example.administrator.tiantgy.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.GuideAdapter;

public class GuideActivity extends ActionBarActivity {
    private ViewPager viewPager;
    private GuideAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.guide_vp);
        adapter=new GuideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }


}
