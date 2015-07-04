package com.example.administrator.tiantgy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.fragment.BuycarFragment;
import com.example.administrator.tiantgy.fragment.CategoryFragment;
import com.example.administrator.tiantgy.fragment.FruitfoodFragment;
import com.example.administrator.tiantgy.fragment.HomePageFragment;
import com.example.administrator.tiantgy.fragment.MyfruitFragment;
import com.example.administrator.tiantgy.utils.FragmentTabUtils;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private RadioGroup radioGroup;
    private RadioButton homePageButton, categoryButton, myFruitButton, buyCarButton, fruitFoodButton;
    private ArrayList<Fragment> fragments;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.hide();
//        if (actionBar != null) {
//            actionBar.setDisplayShowHomeEnabled(false);
//            actionBar.setDisplayShowCustomEnabled(false);
//            actionBar.setDisplayShowTitleEnabled(false);
////            LayoutInflater layoutInflater= (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            View view=layoutInflater.inflate(layoutId,null);
////            ActionBar.LayoutParams layoutParams=new ActionBar.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
//            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//            actionBar.setCustomView(R.layout.homepage_actionbar_layout);
//        }
        initView();

    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.home_fragment_rg);
        homePageButton = (RadioButton) findViewById(R.id.home_fragment_rb_homepage);
        categoryButton = (RadioButton) findViewById(R.id.home_fragment_rb_category);
        myFruitButton = (RadioButton) findViewById(R.id.home_fragment_rb_myfruit);
        buyCarButton = (RadioButton) findViewById(R.id.home_fragment_rb_buycar);
        fruitFoodButton = (RadioButton) findViewById(R.id.home_fragment_rb_fruitfood);
        fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new CategoryFragment(R.id.home_fragment_container));
        fragments.add(new MyfruitFragment());
        fragments.add(new BuycarFragment());
        fragments.add(new FruitfoodFragment());
        FragmentTabUtils utils = new FragmentTabUtils(fragments, radioGroup, getSupportFragmentManager(), R.id.home_fragment_container);

    }


    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    ;
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
