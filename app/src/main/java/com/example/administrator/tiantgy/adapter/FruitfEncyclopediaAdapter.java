package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.bean.Main;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/7/3.
 */
public class FruitfEncyclopediaAdapter extends BeanBaseAdapter {
    private List<Main> mains;

    public FruitfEncyclopediaAdapter(List list, Context context) {
        super(list, context);
        this.mains = list;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder = null;
        Main main = mains.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fruitf_encyclopedia_lv_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bitmapUtils.configDefaultLoadingImage(R.drawable.no_pic_5);
        bitmapUtils.display(holder.photo, main.getPhoto_arr().get(0));
        holder.commentnum.setText(main.getComment_num()+"");
        holder.worthnum.setText(main.getWorth_num()+"");
        if (main.getType().equals("0")) {
            holder.jingxuan.setVisibility(View.GONE);
            holder.summary.setText(main.getSummary());
        } else {
            holder.jingxuan.setVisibility(View.VISIBLE);
            holder.summary.setText("       " + main.getSummary());
        }
//        main.getCtime()



        return convertView;
    }


    private static class ViewHolder {
        private ImageView photo;
        private TextView summary, time, worthnum, commentnum, jingxuan;

        private ViewHolder(View itemView) {
            photo = (ImageView) itemView.findViewById(R.id.fruitfood_encyclopedia_photo);
            summary = (TextView) itemView.findViewById(R.id.fruitfood_encyclopedia_summary);
            time = (TextView) itemView.findViewById(R.id.fruitfood_encyclopedia_time);
            worthnum = (TextView) itemView.findViewById(R.id.fruitfood_encyclopedia_worthnum);
            commentnum = (TextView) itemView.findViewById(R.id.fruitfood_encyclopedia_commentnum);
            jingxuan = (TextView) itemView.findViewById(R.id.fruitfood_encyclopedia_jingxuan);

        }
    }
}
