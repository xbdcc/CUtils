package com.carlos.cutils.util

import android.util.Log
import android.view.Choreographer
import android.view.Choreographer.FrameCallback

/**
 * Created by Carlos on 2020/12/7.
 */
class MyFrameCallback : FrameCallback {
    private val TAG = "性能检测"
    private var lastTime: Long = 0
    override fun doFrame(frameTimeNanos: Long) {
        lastTime = if (lastTime == 0L) {
            //代码第一次初始化。不做检测统计。
            frameTimeNanos
        } else {
            val times = (frameTimeNanos - lastTime) / 1000000
            val frames = (times / 16).toInt()
            if (times > 16) {
                Log.w(TAG, "UI线程超时(超过16ms):" + times + "ms" + " , 丢帧:" + frames)
            }
            frameTimeNanos
        }
        Choreographer.getInstance().postFrameCallback(this)
    }
}