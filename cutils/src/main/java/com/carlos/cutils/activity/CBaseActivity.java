package com.carlos.cutils.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.carlos.cutils.listener.PermissionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 2018/3/6.
 */

public class CBaseActivity extends AppCompatActivity{

    private int mRequestCode;
    private PermissionListener mPermissionListener;

    public void requestPermission(int requestCode,PermissionListener permissionListener,@NonNull String... permissions){
        mRequestCode=requestCode;
        mPermissionListener=permissionListener;
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.M)
            return;
        List<String> deniedPermissions=getDeniedPermissions(permissions);

        if (deniedPermissions.size()>0){
            ActivityCompat.requestPermissions(this,deniedPermissions.toArray(new String[deniedPermissions.size()]),requestCode);
        }else{
            mPermissionListener.permissionSuccess();
        }
    }

    /**
     * 检查被拒绝的权限
     * @param requestPermissions
     * @return
     */
    public List<String> getDeniedPermissions(@NonNull String[] requestPermissions){
        List<String> permissions=new ArrayList<>();
        for (String requestPermission : requestPermissions) {
            if (ContextCompat.checkSelfPermission(this,requestPermission)== PackageManager.PERMISSION_DENIED)
                permissions.add(requestPermission);
        }
        return permissions;
    }

    /**
     * 检查是否有某权限
     * @param permission
     * @return
     */
    public boolean isHasPermission(String permission){
        if (ContextCompat.checkSelfPermission(this,permission)== PackageManager.PERMISSION_DENIED)
            return false;
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mRequestCode==requestCode){
            if (verifyPermisssions(grantResults)) mPermissionListener.permissionSuccess();
            else mPermissionListener.permissionFail();
        }else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public boolean verifyPermisssions(int[] grantResults){
        if (grantResults.length<1)
            return false;
        for (int grantResult : grantResults) {
            if (grantResult!=PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }
}
