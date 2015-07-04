package com.example.administrator.tiantgy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.adapter.CategorySonAdapter;
import com.example.administrator.tiantgy.bean.CategoryNewCate;
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
public class CategoryDetailNewCFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2<ListView>, AdapterView.OnItemClickListener {
    private RequestParams requestParams;
    private PullToRefreshListView listView;
    private int position;
    private List<CategoryNewCate> list;
    private CategorySonAdapter adapter;

    public CategoryDetailNewCFragment() {
    }

    public CategoryDetailNewCFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail_son, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (PullToRefreshListView) view.findViewById(R.id.category_detail_listview);
        listView.setMode(PullToRefreshBase.Mode.PULL_UP_TO_REFRESH);
        listView.setOnRefreshListener(this);
        listView.setOnItemClickListener(this);

        list = new ArrayList<>();

        adapter = new CategorySonAdapter(list, getActivity());
        listView.setAdapter(adapter);
        requestParams = getRequestParams().get(position);
        loadData();

    }


    private void loadData() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, ContantsUrl.CATEGORY_URL, requestParams, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                String jsonResult = objectResponseInfo.result;
                List<CategoryNewCate> newCateList = JSONArray.parseArray(jsonResult, CategoryNewCate.class);
                if (newCateList != null && !newCateList.isEmpty()) {
                    list.addAll(newCateList);
                }
                adapter.notifyDataSetChanged();
                listView.onRefreshComplete();
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }


    /**
     * 获取请求参数
     *
     * @return
     */
    private List<RequestParams> getRequestParams() {
        List<RequestParams> paramses = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            RequestParams param1 = new RequestParams();
            param1.addBodyParameter("source", "app");
            param1.addBodyParameter("curr_page", "0");
            param1.addBodyParameter("service", "product.category");
            param1.addBodyParameter("connect_id", "");
            param1.addBodyParameter("platform", "ANDROID");
            param1.addBodyParameter("device_id", "6730e871823c2475f7d4a164859a2857");
            param1.addBodyParameter("version", "2.1.1");
            param1.addBodyParameter("page_size", "20");
            param1.addBodyParameter("region_id", "143949");
            param1.addBodyParameter("channel", "googleplay");
            param1.addBodyParameter("sort", "0");
            if (i == 0) {
                param1.addBodyParameter("sign", "e30a704efe8f8a2976da5e703795bc99");
                param1.addBodyParameter("timestamp", "1435470754");
                param1.addBodyParameter("class_id", "40");
                paramses.add(param1);
            } else if (i == 1) {
                param1.addBodyParameter("sign", "417bcc6ac3ab6252ac80321c89b0890c");
                param1.addBodyParameter("timestamp", "1435471025");
                param1.addBodyParameter("class_id", "80");
                paramses.add(param1);
            } else if (i == 2) {
                param1.addBodyParameter("sign", "c4084464e67d082b61a53849bb79c9ba");
                param1.addBodyParameter("timestamp", "1435471211");
                param1.addBodyParameter("class_id", "81");
                paramses.add(param1);
            }
        }
        return paramses;
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        Toast.makeText(getActivity(), "点击了" + position, Toast.LENGTH_SHORT).show();
//        CategorySonAdapter.ViewHolder holder= (CategorySonAdapter.ViewHolder) view.getTag();
//        holder.addCar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"点击了item"+position+"的添加购物车",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
