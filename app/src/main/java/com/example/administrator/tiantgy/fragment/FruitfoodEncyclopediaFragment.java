package com.example.administrator.tiantgy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.FruitfEncyclopediaAdapter;
import com.example.administrator.tiantgy.bean.FruitfoodBaseBean;
import com.example.administrator.tiantgy.bean.Main;
import com.example.administrator.tiantgy.config.ContantsUrl;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
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
public class FruitfoodEncyclopediaFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2<ListView> {
    private PullToRefreshListView ptrListView;
    private RequestParams params;
    private int page = 1;
    private FruitfEncyclopediaAdapter encyclopediaAdapter;
    private List<Main> list;


    public FruitfoodEncyclopediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fruitfood_encyclopedia, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        ptrListView = (PullToRefreshListView) view.findViewById(R.id.fruitfood_encyclopedia_ptrlistview);
        ptrListView.setMode(PullToRefreshBase.Mode.BOTH);
        ptrListView.setOnRefreshListener(this);
        list = new ArrayList<>();
        encyclopediaAdapter = new FruitfEncyclopediaAdapter(list, getActivity());
        ptrListView.setAdapter(encyclopediaAdapter);
        loadData();


    }

    private void loadData() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, ContantsUrl.CATEGORY_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                String result = objectResponseInfo.result;
                FruitfoodBaseBean bean = JSONObject.parseObject(result, FruitfoodBaseBean.class);
                if (bean != null) {
                    List<Main> main = bean.getMain();
                    if (main != null && !main.isEmpty()) {
                        list.addAll(main);
                        encyclopediaAdapter.notifyDataSetChanged();
                        ptrListView.onRefreshComplete();

                    }
                }

            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }


    private void initData() {
        params = new RequestParams();
        params.addBodyParameter("version", "2.1.1");
        params.addBodyParameter("timestamp", "1435471362");
        params.addBodyParameter("source", "app");
        params.addBodyParameter("sign", "b5ac949c218cb533ad4c141542451012");
        params.addBodyParameter("service", "bake.getArticleList");
        params.addBodyParameter("region_id", "143949");
        params.addBodyParameter("platform", "ANDROID");
        params.addBodyParameter("page", page + "");
        params.addBodyParameter("limit", "20");
        params.addBodyParameter("device_id", "6730e871823c2475f7d4a164859a2857");
        params.addBodyParameter("connect_id", "");
        params.addBodyParameter("channel", "googleplay");

    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        loadData();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
        initData();
        loadData();
    }

}
