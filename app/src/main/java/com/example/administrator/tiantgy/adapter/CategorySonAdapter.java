package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tiantgy.BaseApp;
import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.bean.CategoryNewCate;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2015/7/2.
 */
public class CategorySonAdapter extends BeanBaseAdapter {
    private List<CategoryNewCate> list;
    private Context context;
    public DbUtils dbUtils;
    public CategorySonAdapter(List list, Context context) {
        super(list, context);
        this.context = context;
        this.list = list;
        dbUtils= BaseApp.getInstance().getDbUtils();
    }

    @Override
    public View getItemView(final int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder = null;
        CategoryNewCate bean = list.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.categoryde_listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bitmapUtils.display(holder.thumPhoto, bean.getThum_photo());
        holder.name.setText(bean.getProduct_name());
        holder.volume.setText(bean.getVolume());
        holder.price.setText("￥" + bean.getPrice());
        if (bean.getOld_price().equals("0")) {
            holder.oldPrice.setText("");
        } else {
            holder.oldPrice.setText("￥" + bean.getOld_price());
            holder.oldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
        holder.addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position + " 加到购物车", Toast.LENGTH_SHORT).show();
//                dbUtils = DbUtils.create();
                try {
                    dbUtils.createTableIfNotExist(CategoryNewCate.class);
                    CategoryNewCate categoryNewCate = list.get(position);
                    dbUtils.save(list.get(position));
                    dbUtils.configAllowTransaction(true);
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

        return convertView;
    }

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.category_detail_lv_addcar:
//                Toast.makeText(context,"加到购物车",Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }


    public class ViewHolder {
        @ViewInject(R.id.category_detail_lv_thumphoto)
        public ImageView thumPhoto;
        @ViewInject(R.id.category_detail_name)
        public TextView name;
        @ViewInject(R.id.category_detail_lv_volume)
        public TextView volume;
        @ViewInject(R.id.category_detail_lv_price)
        public TextView price;
        @ViewInject(R.id.category_detail_lv_oldprice)
        public TextView oldPrice;
        @ViewInject(R.id.category_detail_lv_addcar)
        public Button addCar;

        public ViewHolder(View itemView) {
            ViewUtils.inject(this, itemView);
        }


    }


}
