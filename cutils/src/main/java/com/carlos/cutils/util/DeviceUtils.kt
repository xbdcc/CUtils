package com.carlos.cutils.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.RequiresPermission

/**
 * Created by Carlos on 2019/2/21.
 */
object DeviceUtils {

    @RequiresPermission(android.Manifest.permission.READ_PHONE_STATE)
    fun getImei(context: Context): String {
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var imei = "000000000000000"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
                return imei
            }
        }

        if (telephonyManager.deviceId != null)
            imei = telephonyManager.deviceId
        else
            imei =
                Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)

        return imei
    }

    fun getAppVersionName(context: Context) = try {
        context.packageManager.getPackageInfo(context.packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        ""
    }

    fun getAppVersionCode(context: Context) = try {
        context.packageManager.getPackageInfo(context.packageName, 0).versionCode
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        1
    }

    fun getPhoneModel() = Build.MODEL

    fun getPhoneBroad() = Build.BOARD

    fun getOSVersion() = Build.VERSION.RELEASE

    fun getDensity(context: Context) = context.resources.displayMetrics.densityDpi

    fun getScreenResolution(context: Context) =
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val display =
                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            "" + display.width + "x" + display.height
        } else {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getRealMetrics(displayMetrics)
            "" + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels
        }

    fun getLanguage(context: Context): String {
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            context.resources.configuration.locales.get(0)
        else
            context.resources.configuration.locale
        return locale.country + "-" + locale.language
    }

    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    fun getCurrentNetType(context: Context): String {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        var netType = "unknow"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_DENIED) {
                return netType
            }
        }
        if (networkInfo == null)
        else if (networkInfo.type == ConnectivityManager.TYPE_WIFI) {
            netType = "wifi"
        } else if (networkInfo.type == ConnectivityManager.TYPE_MOBILE) {
            val subType = networkInfo.subtype
            if (subType == TelephonyManager.NETWORK_TYPE_CDMA || subType == TelephonyManager.NETWORK_TYPE_GPRS
                || subType == TelephonyManager.NETWORK_TYPE_EDGE
            ) {
                netType = "2g"
            } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                || subType == TelephonyManager.NETWORK_TYPE_EVDO_A || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                || subType == TelephonyManager.NETWORK_TYPE_EVDO_B
            ) {
                netType = "3g"
            } else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
                netType = "4g"
            }
        }
        return netType
    }


}