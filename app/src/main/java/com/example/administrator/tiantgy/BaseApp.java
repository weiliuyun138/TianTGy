package com.example.administrator.tiantgy;

import android.app.Application;

import com.example.administrator.tiantgy.config.AppConfig;
import com.example.administrator.tiantgy.utils.FileUtils;
import com.lidroid.xutils.DbUtils;

/**
 * Created by Administrator on 2015/6/20.
 */
public class BaseApp extends Application {
    private static BaseApp app;
    private DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApp getInstance() {
        return app;
    }

    public DbUtils getDbUtils() {
        if (dbUtils == null) {
            DbUtils.DaoConfig config = new DbUtils.DaoConfig(this);
            config.setDbDir(FileUtils.getDbPath());
            config.setDbVersion(AppConfig.VERSION);
            config.setDbName(AppConfig.DB_NAME);
            //        config.setDbUpgradeListener(new DbUtils.DbUpgradeListener() {
//            @Override
//            public void onUpgrade(DbUtils dbUtils, int i, int i1) {
//
//            }
//        });
            dbUtils = DbUtils.create(config);
        }

        return dbUtils;
    }

}
