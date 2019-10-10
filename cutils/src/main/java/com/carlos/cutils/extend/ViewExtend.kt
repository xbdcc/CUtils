package com.carlos.cutils.extend

import android.view.View
import android.widget.Checkable
import com.carlos.cutils.util.LogUtils

/**
 * Created by Carlos on 2019-09-28.
 */

inline fun <T : View> T.singleClick(spaceTime: Long = 100, crossinline block: (T) -> Unit) {
    setOnClickListener {
        val currentTimeMillis = System.currentTimeMillis()
        if ((currentTimeMillis - lastClickTime > spaceTime || this is Checkable)) {
            lastClickTime = currentTimeMillis
            block(this)
            LogUtils.d("点击了")
        }
    }
}


var <T : View> T.lastClickTime: Long
    set(value) = setTag(176613352, value)
    get() = getTag(176613352) as? Long ?: 0