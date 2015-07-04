package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/6/23.
 */
public abstract class BeanBaseAdapter<T> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<T> list;
    private BitmapUtils bitmapUtils;
    public BeanBaseAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
        bitmapUtils=new BitmapUtils(context, Environment.getExternalStorageDirectory().getAbsolutePath(),1/8.0f);
    }

    @Override
    public int getCount() {
        return list!=null&&!list.isEmpty()?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent,bitmapUtils,inflater);
    }
    public abstract View getItemView(int position, View convertView,ViewGroup parent,BitmapUtils bitmapUtils,LayoutInflater inflater);
}
