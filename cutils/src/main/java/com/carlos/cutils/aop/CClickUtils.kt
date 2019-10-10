package com.carlos.cutils.aop

import android.view.View

/**
 * Created by Carlos on 2019-09-28.
 */
object CClickUtils {
    private var lastClickTime: Long = 0L
    private var lastClickId: Int = 0

    fun isFastDoubleClick(view: View, intervalMillis: Long): Boolean {
        val viewId = view.id
        val time = System.currentTimeMillis()
        val timeInterval = Math.abs(time - lastClickTime)
        return if (timeInterval < intervalMillis && viewId == lastClickId)
            true
        else {
            lastClickTime = time
            lastClickId = viewId
            false
        }
    }
}