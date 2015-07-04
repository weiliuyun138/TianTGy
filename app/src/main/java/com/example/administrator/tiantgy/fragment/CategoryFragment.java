package com.example.administrator.tiantgy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.activity.CategoryActivity;
import com.example.administrator.tiantgy.adapter.CategoryAdapter;
import com.example.administrator.tiantgy.bean.CategoryBean;
import com.example.administrator.tiantgy.bean.CategoryCommon;
import com.example.administrator.tiantgy.config.ContantsUrl;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<CategoryCommon> commons;
    private ListView listView;
    private Button searchButton;
    private CategoryAdapter adapter;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private CategoryDetailFragment fragment;
    //    private List<RequestParams> requestParamses;
    private int layoutId;

    public CategoryFragment(int id) {
        this.layoutId = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        return view;
    }

    /**
     * 初始化
     */
    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.category_lv);
        searchButton = (Button) view.findViewById(R.id.category_button_search);
        searchButton.setOnClickListener(this);

        commons = new ArrayList<>();
//        requestParamses = new ArrayList<>();
//        requestParamses.addAll(getRequestParamsData());

        loadData();

        adapter = new CategoryAdapter(commons, getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }


    private void loadData() {
        HttpUtils httpUtils = new HttpUtils();
        //获取请求参数
        RequestParams params = getRequestParams();
        httpUtils.send(HttpRequest.HttpMethod.POST, ContantsUrl.CATEGORY_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                //获得服务器返回的json数据
                String result = objectResponseInfo.result;
                CategoryBean categoryBean = JSONObject.parseObject(result, CategoryBean.class);
                if (categoryBean != null) {
                    List<CategoryCommon> common = categoryBean.getCommon();
                    commons.addAll(common);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 获取请求参数
     */
    private RequestParams getRequestParams() {
        RequestParams params = new RequestParams();
        params.addBodyParameter("platform", "ANDROID");
        params.addBodyParameter("sign", "3d39f373c0a59d60ddbb4b18bdec427f");
        params.addBodyParameter("device_id", "6730e871823c2475f7d4a164859a2857");
        params.addBodyParameter("source", "app");
        params.addBodyParameter("version", "2.1.1");
        params.addBodyParameter("timestamp", "1435470567");
        params.addBodyParameter("region_id", "143949");
        params.addBodyParameter("service", "product.getCatList");
        params.addBodyParameter("channel", "googleplay");
        params.addBodyParameter("connect_id", "");

        return params;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CategoryActivity.class);
        intent.putExtra("position", position + "");
        startActivity(intent);

    }


    private List<RequestParams> getRequestParamsData() {
        List<RequestParams> requestParamsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            RequestParams params = new RequestParams();
            params.addBodyParameter("platform", "ANDROID");
            params.addBodyParameter("source", "app");
            params.addBodyParameter("version", "2.1.1");
            params.addBodyParameter("region_id", "143949");
            params.addBodyParameter("service", "product.category");
            params.addBodyParameter("channel", "googleplay");
            params.addBodyParameter("connect_id", "");
            params.addBodyParameter("curr_page", "0");
            params.addBodyParameter("page_size", "20");
            params.addBodyParameter("class_id", "40");
            params.addBodyParameter("sort", "0");
            params.addBodyParameter("device_id", "6730e871823c2475f7d4a164859a2857");
            if (i == 0) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 1) {
                params.addBodyParameter("timestamp", "1435470821");
                params.addBodyParameter("sign", "50fd68d8680db9dae466d8eba85dd5ba");
            } else if (i == 2) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 3) {
                params.addBodyParameter("timestamp", "1435470821");
                params.addBodyParameter("sign", "50fd68d8680db9dae466d8eba85dd5ba");
            } else if (i == 4) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 5) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 6) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 7) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 8) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 9) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 10) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            } else if (i == 11) {
                params.addBodyParameter("timestamp", "1435470754");
                params.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
            }
            requestParamsList.add(params);
        }
        return requestParamsList;
    }
}
