package com.carlos.cutils.demo;

import android.app.Application;

/**
 * Created by Carlos on 2018/2/27.
 */

public class MyApplication extends Application{

    private static MyApplication instance;

    public static synchronized MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
