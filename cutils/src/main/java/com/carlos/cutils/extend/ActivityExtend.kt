package com.carlos.cutils.extend

import android.app.Activity
import android.content.Intent

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-12-17.
 */
fun <T : Activity> T.defaultStartActivity(clazz: Class<*>) {
    val intent = Intent(this, clazz)
    this.startActivity(intent)
}