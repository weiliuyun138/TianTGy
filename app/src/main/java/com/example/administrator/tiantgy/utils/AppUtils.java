package com.example.administrator.tiantgy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2015/6/15.
 */
public class AppUtils {

    public static boolean isFirst(Context context) {
        /**只有卸载的时候才会清空数据*/
        //本地存储   存储量小
        SharedPreferences sharedPreferences = context.getSharedPreferences("isfirst", Context.MODE_PRIVATE);
        int version = sharedPreferences.getInt("version", 0);
        boolean isFirst = sharedPreferences.getBoolean("first", true);
        if (version != getVersion(context) || isFirst) {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("first", false);
            editor.putInt("version",getVersion(context));
            editor.commit();
        }
        return isFirst;
    }


    public static int getVersion(Context context) {
        int version = 0;

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

}
