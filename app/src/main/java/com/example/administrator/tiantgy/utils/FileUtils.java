package com.example.administrator.tiantgy.utils;

import android.os.Environment;

import com.example.administrator.tiantgy.config.AppConfig;

import java.io.File;

//import com.qianfeng.zhangwei.day38.config.AppConfig;

/**
 * @version v1.0
 * @类描述：
 * @项目名称：StudyDemo
 * @包 名： com.qianfeng.zhangwei.day38.utils
 * @类名称：BaseAdapter
 * @创建人：张唯
 * @创建时间：2015-06-25 10:53
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class FileUtils {
    /**
     * 获取应用程序根文件
     *
     *
     * sdk/ttgy
     *
     *
     * data/data/com.qianfeng.zhangwei.day38/ttgy
     *
     * @return
     */
    public static String getAppCache() {
        String appCache = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            appCache = Environment.getExternalStorageDirectory() + File.separator + AppConfig.APP_CACHE;
        } else {
            appCache = Environment.getDataDirectory() + File.separator + AppConfig.ROOT_CACHE;
        }
        File cacheFile = new File(appCache);
        if (!cacheFile.exists()) {
            cacheFile.mkdirs();
        }
        return appCache;

    }

    /**
     * data/data/com.qianfeng.zhangwei.day38/ttgy/image
     *
     * @return
     */
    public static String getImageCache() {
        String imageCache = getAppCache() + File.separator + AppConfig.IMAGE_CACHE;
        File file = new File(imageCache);
        if (!file.exists()) {
            file.mkdir();
        }
        return imageCache;
    }

    /**
     * sdk/ttgy/db
     *
     * @return
     */
    public static String getDbPath() {
        String dbPath = getAppCache() + File.separator + AppConfig.DB_PATH;

        File file = new File(dbPath);
        if (!file.exists()) {
            file.mkdir();
        }
        return dbPath;

    }


}
