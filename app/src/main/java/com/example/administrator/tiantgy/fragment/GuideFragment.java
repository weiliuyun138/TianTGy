package com.example.administrator.tiantgy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment implements View.OnClickListener{
    private static final String KEY="position";
    private Button button;
    private ImageView imageView;
    private int [] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};


    public static GuideFragment getInstance(int position){
        GuideFragment fragment=new GuideFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(KEY,position);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_guide, container, false);
        button= (Button) view.findViewById(R.id.guide_viewPager_bt);
        imageView= (ImageView) view.findViewById(R.id.guide_image);
        int position = getArguments().getInt(KEY);
        imageView.setImageResource(images[position]);
        button.setOnClickListener(this);
        if (position==2){
            button.setVisibility(View.VISIBLE);
        }else {
            button.setVisibility(View.GONE);
        }
        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
