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
public class CategoryDetailHotFragment extends Fragment {


    public CategoryDetailHotFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_category_detail_hot, container, false);
    }


}
