package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.bean.Banner;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/6/23.
 */
public class HomePageLVAdapter extends BeanBaseAdapter {
    private List<Banner> list;

    public HomePageLVAdapter(List list, Context context) {
        super(list, context);
        this.list = list;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder = null;
        Banner banner = list.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.homepage_listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setTag(banner.getPhoto());
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.no_pic_3);
        bitmapUtils.configDefaultLoadingImage(R.drawable.no_pic_2);
        bitmapUtils.display(holder.imageView, banner.getPhoto());

        return convertView;
    }

    public class ViewHolder {
        private ImageView imageView;

        public ViewHolder(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.homepage_listview_image);
        }
    }
}
