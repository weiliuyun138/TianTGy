package com.example.administrator.tiantgy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.tiantgy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyfruitFragment extends Fragment {


    public MyfruitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myfruit, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {



    }


}
