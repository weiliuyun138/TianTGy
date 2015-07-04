package com.example.administrator.tiantgy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.utils.AppUtils;

public class SplashActivity extends ActionBarActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.wellcome);
        AnimationSet set = new AnimationSet(true);
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 0);
        animation.setDuration(5 * 100);
        set.addAnimation(animation);
        textView.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                statIntent();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    private void statIntent() {
        Intent intent;
        if (AppUtils.isFirst(getApplicationContext())) {
            intent = new Intent(this, GuideActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

}
