package com.example.administrator.tiantgy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tiantgy.BaseApp;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.BuycarLvAdapter;
import com.example.administrator.tiantgy.bean.CategoryNewCate;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuycarFragment extends Fragment implements View.OnClickListener {
    private ListView listView;
    private TextView price;
    private Button buyNow;
    private ImageView delete;
    private BuycarLvAdapter adapter;
    private List<CategoryNewCate> list=new ArrayList<>();
    private DbUtils dbUtils;
    private int sum=0;
    public BuycarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buycar, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.buycar_listview);
        price = (TextView) view.findViewById(R.id.buycar_price);
        delete = (ImageView) view.findViewById(R.id.buycar_delete);
        buyNow = (Button) view.findViewById(R.id.buycar_buynow);

        delete.setOnClickListener(this);
        buyNow.setOnClickListener(this);

        adapter = new BuycarLvAdapter(list, getActivity());
        getDbData();
        listView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void getDbData() {
        try {
            dbUtils = BaseApp.getInstance().getDbUtils();
            list.addAll(dbUtils.findAll(CategoryNewCate.class));
            for (int i = 0; i < list.size(); i++) {
                sum += Integer.parseInt(list.get(i).getPrice());
            }
            price.setText(sum+"");
            adapter.notifyDataSetChanged();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buycar_delete:
                try {
                    dbUtils.deleteAll(CategoryNewCate.class);
                    Toast.makeText(getActivity(), "清空列表成功", Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.buycar_buynow:
                Toast.makeText(getActivity(), "立即购买", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
