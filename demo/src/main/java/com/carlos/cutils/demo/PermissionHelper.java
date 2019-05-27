package com.carlos.cutils.demo;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.util.List;

/**
 * Created by Carlos on 2018/3/2.
 */

public class PermissionHelper {


    // 需要反射的类
    private Object mObject;
    // 请求码
    private int mRequestCode;
    // 请求权限数组
    private String[] mRequestPermission;

    private PermissionHelper(Object object){
        this.mObject=object;
    }

    /**
     * 兼容Activity
     * @param activity
     * @return
     */
    public static PermissionHelper with(Activity activity){
        return new PermissionHelper(activity);
    }

    /**
     * 兼容 Fragment
     * @param fragment
     * @return
     */
    public static PermissionHelper with(Fragment fragment){
        return new PermissionHelper(fragment);
    }

    /**
     * 添加请求码
     * @param requestCode
     * @return
     */
    public PermissionHelper requestCode(int requestCode){
        this.mRequestCode=requestCode;
        return this;
    }

    /**
     * 添加请求权限数组
     * @param permissions
     * @return
     */
    public PermissionHelper requestPermission(String... permissions){
        this.mRequestPermission=permissions;
        return this;
    }

    public void request(){
        // 判断当前系统版本是否大于等于6.0
        if(!PermissionUtils.Companion.isOverMarshmallow()){
            PermissionUtils.Companion.executeSuccessMethod(mObject,mRequestCode);
            return;
        }

        List<String> deniedPermissions= PermissionUtils.Companion.getDeniedPermissions(mObject,mRequestPermission);
        // 权限被授予 反射获取执行方法
        if (deniedPermissions.size()==0){
            // 用户授予请求权限
            PermissionUtils.Companion.executeSuccessMethod(mObject,mRequestCode);
        }else {
            // 权限被拒绝 申请权限
            ActivityCompat.requestPermissions(PermissionUtils.Companion.getActivity(mObject),deniedPermissions.toArray(new String[deniedPermissions.size()]),mRequestCode);
        }
    }

    public static void requestPermissionResult(Object object,int requestCode,String[] permissions){
        // 再次获取用户拒绝的权限
        List<String> deniedPermissions= PermissionUtils.Companion.getDeniedPermissions(object,permissions);
        if (deniedPermissions.size()==0){
            PermissionUtils.Companion.executeSuccessMethod(object,requestCode);
        }else{
            PermissionUtils.Companion.executeFailMethod(object,requestCode);
        }
    }
}
