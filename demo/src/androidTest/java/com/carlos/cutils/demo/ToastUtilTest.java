package com.carlos.cutils.demo;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Carlos on 2018/2/27.
 */
@RunWith(AndroidJUnit4.class)
public class ToastUtilTest {

    String packageName="com.carlos.utils.demo";
    Context mContext;

    @Before
    public void startApp(){
        mContext= InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void test(){
        Intent intent=mContext.getPackageManager().getLaunchIntentForPackage(packageName);
        mContext.startActivity(intent);
    }

}