package com.example.administrator.tiantgy.utils;

import android.content.Context;
import android.os.Environment;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2015/6/16.
 */
public class BitmapHelper {
    private Context context;
    private BitmapUtils bitmapUtils=new BitmapUtils(context,Environment.getExternalStorageDirectory().getAbsolutePath(),1/8.0f);

    public void imageDisplay(ImageView imageView, String imagUrl) {
        bitmapUtils.display(imageView, imagUrl);
    }


}
