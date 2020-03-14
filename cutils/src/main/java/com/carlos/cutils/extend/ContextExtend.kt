package com.carlos.cutils.extend

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-12-17.
 */
fun Context.defaultStartActivity(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    this.startActivity(intent)
}

fun Context.startActivity(url: String): Boolean {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    val resolveInfo = packageManager.queryIntentActivities(intent, 0)
    return if (resolveInfo.isNotEmpty()) {
        startActivity(intent)
        true
    } else false
}

fun Context.startWechatPay(url: String) {
    if (url.startsWith("weixin://wap/pay?")) {
        startActivity(url)
    }
}

fun <T : Context> T.startAlipay(url: String) {
    if (url.contains("platformapi/startapp")) {
        startActivity(url)
    }
}