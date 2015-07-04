package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.bean.CategoryCommon;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2015/6/28.
 */
public class CategoryAdapter extends BeanBaseAdapter {
    private List<CategoryCommon> list;

    public CategoryAdapter(List list, Context context) {
        super(list, context);
        this.list = list;

    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder = null;
        CategoryCommon common = list.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.category_lv_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ename.setText(common.getEname());
        holder.name.setText(common.getName());
        bitmapUtils.display(holder.photo, common.getPhoto());
        return convertView;
    }

    private class ViewHolder {
        @ViewInject(R.id.category_photo)
        private ImageView photo;
        @ViewInject(R.id.category_name)
        private TextView name;
        @ViewInject(R.id.category_ename)
        private TextView ename;

        private ViewHolder(View itemView) {
            ViewUtils.inject(this, itemView);

        }
    }
}
