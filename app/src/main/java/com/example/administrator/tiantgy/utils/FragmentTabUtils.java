package com.example.administrator.tiantgy.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/6/15.
 */
public class FragmentTabUtils implements RadioGroup.OnCheckedChangeListener{
    private ArrayList<Fragment> fragments;
    private RadioGroup radioGroups;
    private FragmentManager fragmentManager;
    private int fragmentContentId;
    private int currentTab;

    public FragmentTabUtils(ArrayList<Fragment> fragments, RadioGroup radioGroups, FragmentManager fragmentManager, int fragmentContentId) {
        this.fragments = fragments;
        this.radioGroups = radioGroups;
        this.fragmentManager = fragmentManager;
        this.fragmentContentId=fragmentContentId;
        //默认显示第一页
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.add(fragmentContentId,fragments.get(0));
        ft.commit();
        radioGroups.setOnCheckedChangeListener(this);

    }

    /**
     * 页面切换
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < radioGroups.getChildCount(); i++) {
            if (radioGroups.getChildAt(i).getId() == checkedId){
                Fragment fragment = fragments.get(i);
                FragmentTransaction ft=obtainFragmentTransaction(i);
                getCurrentFragment().onStop();  //暂停当前页面
                if (fragment.isAdded()){
                    fragment.onStart();  //启动目标tab的fragment onStart()
                }else {
                    ft.add(fragmentContentId,fragment);
                    ft.commit();
                }
                showTab(i);
            }
        }
    }

    /**
     * 切换tab
     * @param ii
     */
    private void showTab(int ii) {
        for (int j = 0; j < fragments.size(); j++) {
            Fragment fragment=fragments.get(j);
            FragmentTransaction fragmentTransaction=obtainFragmentTransaction(ii);
            if (ii==j){
                fragmentTransaction.show(fragment);   //显示
            }else {
                fragmentTransaction.hide(fragment);   //隐藏
            }
            fragmentTransaction.commit();
        }
        currentTab=ii;  //更新目标tab为当前tab
    }

    /**
     * 获取当前Fragment
     * @return
     */
    private Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

    /**
     * 获取带动画的FragmentTransaction
     * @param i
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int i) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //设置切换动画
//        if (i>currentTab){
//            fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
//        }else {
//            fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_top,R.anim.abc_slide_out_top);
//        }
        return fragmentTransaction;
    }
}
