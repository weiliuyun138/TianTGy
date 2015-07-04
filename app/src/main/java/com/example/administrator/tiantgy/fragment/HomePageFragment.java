package com.example.administrator.tiantgy.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.activity.HomeSearchActivity;
import com.example.administrator.tiantgy.adapter.HomePageHeadGVAdapter;
import com.example.administrator.tiantgy.adapter.HomePageHeadListViewAdapter;
import com.example.administrator.tiantgy.adapter.HomePageLVAdapter;
import com.example.administrator.tiantgy.adapter.HomepageViewPagerAdapter;
import com.example.administrator.tiantgy.bean.Banner;
import com.example.administrator.tiantgy.bean.HomePageBasebean;
import com.example.administrator.tiantgy.bean.MixProductBanner;
import com.example.administrator.tiantgy.bean.MobileProductList;
import com.example.administrator.tiantgy.bean.QiangxianProductList;
import com.example.administrator.tiantgy.bean.Rotation;
import com.example.administrator.tiantgy.bean.TopBanner;
import com.example.administrator.tiantgy.config.ContantsUrl;
import com.example.administrator.tiantgy.utils.HttpUtils;
import com.example.administrator.tiantgy.utils.Utility;
import com.example.administrator.tiantgy.widget.AutoScrollViewPager;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.View.OnClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements ViewPager.OnPageChangeListener, OnClickListener {
    /**
     * 主、头部 listView
     */
    private ListView listView, headListView;
    private List<String> name;
    /**
     * gridview
     */
    private HashMap<String, String> map; //params
    private List<Banner> bannerList; //主listView
    private List<Rotation> rotationList; //广告栏
    private List<TopBanner> topBannerList; //头部listView
    private List<MobileProductList> mobileProductListList;
    private List<QiangxianProductList> qiangxianProductListList;
    private List<MixProductBanner> mixProductBannerList;
    private List<View> rotationViews = new ArrayList<>(); //广告栏

    private View headView; //头部
    private EditText homeSearch;
    private HomePageLVAdapter adapter;
    private HomePageHeadListViewAdapter headListViewAdapter;
    private HomePageHeadGVAdapter gridViewAdapter;
    private HomepageViewPagerAdapter viewPagerAdapter; //广告栏
    private BitmapUtils bitmapUtils;
    private HeadHolder holder;
    private ListAdapter listAdapter;

    public HomePageFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        bitmapUtils = new BitmapUtils(getActivity(), Environment.getExternalStorageDirectory().getAbsolutePath(), 1 / 8.0f);
        initView(view, inflater);

        return view;
    }

    /**
     * 初始化
     *
     * @param view
     * @param inflater
     */
    private void initView(View view, LayoutInflater inflater) {
//        bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
//        bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
        listView = (ListView) view.findViewById(R.id.homepage_listview);
        homeSearch = (EditText) view.findViewById(R.id.homepage_actionbar_search);
        homeSearch.setInputType(InputType.TYPE_NULL);
//        listView.setMode(PullToRefreshBase.Mode.DISABLED);
//        ListView listView1 = listView.getRefreshableView();
        bannerList = new ArrayList<>();
        rotationList = new ArrayList<>();
        topBannerList = new ArrayList<>();
        mobileProductListList = new ArrayList<>();
        qiangxianProductListList = new ArrayList<>();
        mixProductBannerList = new ArrayList<>();
        map = new HashMap<>();

        new HomePagerTask().execute(ContantsUrl.HOME_PAGE_URL); //开启异步下载
        headView = getHeadView(inflater, topBannerList); //获取头部视图

        adapter = new HomePageLVAdapter(bannerList, getActivity());  //头部listview

        listView.addHeaderView(headView); //主listView
        listView.setAdapter(adapter);

        homeSearch.setOnClickListener(this);

    }


    /**
     * 获取头部view
     *
     * @param inflater
     */
    public View getHeadView(LayoutInflater inflater, List<TopBanner> topBannerList) {
        View headView = inflater.inflate(R.layout.homepage_headview, null);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.page);
        holder = new HeadHolder(headView);
        name = new ArrayList<>();
        name.add("新鲜点");
        name.add("抢鲜啦!");
        name.add("摇一摇");
        name.add("充值有礼");
        name.add("物流·售后");
        name.add("提货券");
        name.add("企业团购");
        name.add("免费试吃");
        /**头部gridView*/
        gridViewAdapter = new HomePageHeadGVAdapter(name, getActivity());
        holder.headGridView.setAdapter(gridViewAdapter);
        /**广告栏*/
        viewPagerAdapter = new HomepageViewPagerAdapter(rotationViews);
        holder.headViewPager.setAdapter(viewPagerAdapter);

        //头部listView
        headListViewAdapter = new HomePageHeadListViewAdapter(topBannerList, getActivity());
        holder.headListView.setAdapter(headListViewAdapter);

//        holder.asymmetricGridView.setRequestedColumnWidth(Utils.dpToPx(getActivity(),120));
//        final List<AsymmetricItem> items=new ArrayList<>();
//        listAdapter=new ListAdapter(this,holder.asymmetricGridView,items);

//        initDots(holder,bitmap);
//        holder.headViewPager.setOnPageChangeListener(this);//设置监听
        return headView;
    }

    /**
     * 底部小圆点
     */
    private void initDots(HeadHolder holder, Bitmap bitmap) {

        //循环取得小图片
        for (int i = 0; i < rotationViews.size(); i++) {
            Button imageView = new Button(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
            imageView.setBackgroundResource(R.drawable.page);
            holder.headDot.addView(imageView);
        }

    }


    /**
     * ViewPager page改变监听
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        setCurrentDot(position);
//        if (imageViewdot != null) {
//            imageViewdot.setBackgroundResource(R.drawable.page);
//        }
//        Button currentImage = (Button) holder.headDot.getChildAt(position);
//        currentImage.setBackgroundResource(R.drawable.page_now);
//        imageViewdot = currentImage;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.homepage_actionbar_search:
                intent.setClass(getActivity(), HomeSearchActivity.class);
                break;

        }
        startActivity(intent);

    }

    private class HeadHolder {
        @ViewInject(R.id.homepage_head_viewpager)
        AutoScrollViewPager headViewPager;
        @ViewInject(R.id.homepage_head_asygridview)
        AsymmetricGridView asymmetricGridView;
        @ViewInject(R.id.homepage_head_asygridview2)
        AsymmetricGridView asymmetricGridView2;
        @ViewInject(R.id.homepage_head_gridview)
        GridView headGridView;
        @ViewInject(R.id.homepage_head_listview)
        ListView headListView;
        @ViewInject(R.id.homepage_head_dotll)
        LinearLayout headDot;

        private HeadHolder(View view) {
            ViewUtils.inject(this, view);
        }
    }


    /**
     * 异步下载 解析
     */
    private class HomePagerTask extends AsyncTask<String, Void, HomePageBasebean> {

        @Override
        protected HomePageBasebean doInBackground(String... params) {
            getParams();
            String post = HttpUtils.post(params[0], map);
            HomePageBasebean homePageBasebean = JSONObject.parseObject(post, HomePageBasebean.class);
            if (homePageBasebean != null) {
                return homePageBasebean;
            }
            return null;
        }

        @Override
        protected void onPostExecute(HomePageBasebean s) {
            super.onPostExecute(s);
            if (s != null) {
                List<Banner> banners = s.getBanner();//主listView


                if (banners != null && !banners.isEmpty()) {
                    bannerList.addAll(banners);//listView列表
                }
            }
            List<TopBanner> topBanners = s.getTop_banner();//头部listView
            List<Rotation> rotation = s.getRotation();//广告栏
            if (topBanners != null && !topBanners.isEmpty()) {
                topBannerList.addAll(topBanners);
            }
            Utility.setListViewHeightBasedOnChildren(holder.headListView);//解决头部listview item显示不全问题
            headListViewAdapter.notifyDataSetChanged();
            adapter.notifyDataSetChanged();
//            bitmapUtils.display(holder.mixproduct1, s.getMix_product_banner().get(0).getPhoto());
//            bitmapUtils.display(holder.mixproduct2, s.getMix_product_banner().get(1).getPhoto());
//            bitmapUtils.display(holder.mixproduct3, s.getMix_product_banner().get(2).getPhoto());
//            bitmapUtils.display(holder.mixproduct4, s.getMix_product_banner().get(3).getPhoto());
//            bitmapUtils.display(holder.mixproduct5, s.getMix_product_banner().get(4).getPhoto());
//            bitmapUtils.display(holder.mixproduct6, s.getMix_product_banner().get(5).getPhoto());

            if (rotation != null && !rotation.isEmpty()) {
                refreshRotation(rotation);
            }
        }

        /**
         * 获取map
         */
        private void getParams() {
            map.put("sign", "f8257b7dd195415f4ad65e851844b762");
            map.put("timestamp", "1434703913");
            map.put("platform", "ANDROID");
            map.put("source", "app");
            map.put("connect_id", "");
            map.put("region_id", "143949");
            map.put("service", "marketing.banner");
            map.put("device_id", "a781ff387d0fd135e5a97ed41f71838c");
            map.put("channel", "qq");
            map.put("version", "2.1.1");
        }

        /**
         * 数据广告栏的
         */
        private void refreshRotation(List<Rotation> rotations) {
            for (int i = 0; i < rotations.size(); i++) {
                ImageView imageView = new ImageView(getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                bitmapUtils.display(imageView, rotations.get(i).getPhoto());
                rotationViews.add(imageView);
            }
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        holder.headViewPager.startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        holder.headViewPager.stopAutoScroll();
    }
}
