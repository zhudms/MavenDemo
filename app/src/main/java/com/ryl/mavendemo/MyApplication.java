package com.ryl.mavendemo;

import android.app.Application;

import com.ryl.commonlib.utils.IsOnDebug;

/**
 * Created by rongyile on 2018/1/18.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication();
    }

    private void initApplication() {
        IsOnDebug.setIsDebug(false);
    }


}
