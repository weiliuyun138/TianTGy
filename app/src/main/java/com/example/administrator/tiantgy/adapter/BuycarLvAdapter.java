package com.example.administrator.tiantgy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tiantgy.R;
import com.example.administrator.tiantgy.bean.CategoryNewCate;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/7/2.
 */
public class BuycarLvAdapter extends BeanBaseAdapter {
    private List<CategoryNewCate> list;
    private TextView price;
    private int sum=1;
    public BuycarLvAdapter(List list, Context context) {
        super(list, context);
        this.list = list;
//        this.price=price;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, BitmapUtils bitmapUtils, LayoutInflater inflater) {
        ViewHolder holder = null;
        CategoryNewCate categoryNewCate = list.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.buycar_listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        bitmapUtils.display(holder.photo, categoryNewCate.getThum_photo());
        holder.name.setText(categoryNewCate.getProduct_name());
        holder.vulome.setText(categoryNewCate.getVolume());
        holder.price.setText(categoryNewCate.getPrice());


//        for (int i = 0; i < list.size(); i++) {
//            sum += Integer.parseInt(list.get(i).getPrice());
//        }
//        price.setText(sum+"");

        return convertView;
    }

    public class ViewHolder {

        private ImageView photo, add, minus;
        private TextView num, name, vulome, price;

        public ViewHolder(View itemView) {
            photo = (ImageView) itemView.findViewById(R.id.buycar_listview_photo);
            minus = (ImageView) itemView.findViewById(R.id.buycar_listview_Minus);
            add = (ImageView) itemView.findViewById(R.id.buycar_listview_add);
            num = (TextView) itemView.findViewById(R.id.buycar_listview_num);
            name = (TextView) itemView.findViewById(R.id.buycar_listview_name);
            vulome = (TextView) itemView.findViewById(R.id.buycar_listview_volume);
            price = (TextView) itemView.findViewById(R.id.buycar_listview_price);
        }
    }


}
