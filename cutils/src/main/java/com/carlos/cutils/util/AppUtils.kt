package com.carlos.cutils.util

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

/**
 * if not pass packageName field is to get app yourself, otherwise to get other app.
 * Created by Carlos on 2019-05-29.
 */
object AppUtils {

    fun getAppVersionName(context: Context, packageName: String = context.packageName) = try {
        context.packageManager.getPackageInfo(packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        ""
    }

    fun getVersionCode(context: Context, packageName: String = context.packageName) = try {
        val packageInfo = context.packageManager.getPackageInfo(packageName, 0)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) packageInfo.longVersionCode
        else packageInfo.versionCode.toLong()
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        1L
    }

}