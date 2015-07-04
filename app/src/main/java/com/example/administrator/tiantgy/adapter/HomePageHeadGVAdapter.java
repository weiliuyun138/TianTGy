package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/6/26.
 */
public class HomePageHeadGVAdapter extends BeanBaseAdapter {
    private int [] imgs={R.drawable.icon_juice,R.drawable.icon_flash,R.drawable.icon_shake,
            R.drawable.icon_topup,R.drawable.home_order,R.drawable.redemption,
            R.drawable.enterprise,R.drawable.icon_eattry};
    private List<String> name;
    public HomePageHeadGVAdapter(List list, Context context) {
        super(list, context);
        this.name=list;

    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.homepage_gridview_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(imgs[position]);
        holder.textView.setText(name.get(position));


        return convertView;
    }

    private class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private ViewHolder(View itemView) {
            imageView= (ImageView) itemView.findViewById(R.id.homepage_head_gridview_iv);
            textView= (TextView) itemView.findViewById(R.id.homepage_head_gridview_tv);
        }
    }

}
