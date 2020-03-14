package com.carlos.cutils.util

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.webkit.WebView
import com.carlos.cutils.CUtils

/**
 * Github: https://github.com/xbdcc/.
 * if not pass packageName field is to get app yourself, otherwise to get other app.
 * Created by Carlos on 2019-05-29.
 */
object AppUtils {

    const val WECHAT_PACKAGE = "com.tencent.mm"

    @JvmStatic
    fun getVersionName(
        packageName: String = CUtils.cContext.packageName,
        context: Context = CUtils.cContext
    ) = try {
        context.packageManager.getPackageInfo(packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        ""
    }

    @JvmStatic
    fun getVersionCode(
        packageName: String = CUtils.cContext.packageName,
        context: Context = CUtils.cContext
    ) = try {
        val packageInfo = context.packageManager.getPackageInfo(packageName, 0)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) packageInfo.longVersionCode
        else packageInfo.versionCode.toLong()
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        1L
    }

    @JvmStatic
    fun getMetaData(key: String, context: Context = CUtils.cContext): String {
        val applicationInfo = context.packageManager.getApplicationInfo(
            context.packageName,
            PackageManager.GET_META_DATA
        )
        return applicationInfo.metaData.getString(key) ?: ""
    }

    @JvmStatic
    fun startWechatPayRefer(webview: WebView, url: String, authorizedDomainName: String): Boolean {
        if (!url.startsWith("http") or !url.contains("wx.tenpay.com")) return false
        val extraHeaders = mutableMapOf<String, String>()
        extraHeaders["Referer"] = authorizedDomainName;//例如 http://www.baidu.com ))
        //如果需要支付跳转链接，详情link中mweb_url:https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_20&index=1
        webview.loadUrl(url, extraHeaders)
        return true
    }

    @JvmStatic
    fun startWechatPay(context: Context, url: String) {
        if (!url.startsWith("weixin://wap/pay?")) return
        startActivity(context, url)
    }

    @JvmStatic
    fun startAlipay(context: Context, url: String) {
        if (!url.startsWith("alipay")) return
        if (url.contains("platformapi/startApp")) {
            startActivity(context, url)
        } else if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
            && (url.contains("platformapi") && url.contains("startApp"))
        ) {
            startActivity(context, url)
        }
    }

    @JvmStatic
    fun startActivity(context: Context, url: String): Boolean {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        return queryIntent(context, intent)
    }


    @JvmStatic
    fun queryIntent(context: Context, intent: Intent, start: Boolean = true): Boolean {
        val resolveInfo = context.packageManager.queryIntentActivities(intent, 0)
        return if (resolveInfo.isNotEmpty()) {
            if (start) context.startActivity(intent)
            true
        } else {
            false
        }
    }

    @JvmStatic
    fun startWechat(context: Context): Boolean {
        return isAppInstalled(context, WECHAT_PACKAGE, true)
    }

    @JvmStatic
    fun isAppInstalled(context: Context, packageName: String, start: Boolean = false): Boolean {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        return if (intent == null) {
            false
        } else {
            if (start)
                context.startActivity(intent)
            true
        }
    }

}