package com.carlos.cutils

import android.content.Context

/**
 * Created by Carlos on 2020/3/14.
 */
object CUtils {

    lateinit var cContext: Context

    fun init(context: Context) {
        this.cContext = context
    }
}