package com.carlos.cutils.util

import android.util.Log

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2018/3/6.
 */

object LogUtils {

    var TAG = "LogUtils"

    @JvmField
    var isShowLog = true

    @JvmStatic
    fun i(msg: String) {
        if (isShowLog)
            Log.i(TAG, "$logTitle$msg")
    }

    @JvmStatic
    fun i(msg: String, throwable: Throwable) {
        if (isShowLog)
            Log.i(TAG, "$logTitle$msg", throwable)
    }

    @JvmStatic
    fun d(msg: String) {
        if (isShowLog)
            Log.d(TAG, "$logTitle$msg")
    }

    @JvmStatic
    fun d(msg: String, throwable: Throwable) {
        if (isShowLog)
            Log.d(TAG, "$logTitle$msg", throwable)
    }

    @JvmStatic
    fun w(msg: String) {
        if (isShowLog)
            Log.w(TAG, "$logTitle$msg")
    }

    @JvmStatic
    fun w(msg: String, throwable: Throwable) {
        if (isShowLog)
            Log.w(TAG, "$logTitle$msg", throwable)
    }

    @JvmStatic
    fun e(msg: String) {
        if (isShowLog)
            Log.e(TAG, "$logTitle$msg")
    }

    @JvmStatic
    fun e(msg: String, throwable: Throwable) {
        if (isShowLog)
            Log.e(TAG, "$logTitle$msg", throwable)
    }

    private val logTitle: String
        get() {
            val stringBuilder = StringBuilder()
            val stackTraceElements = Thread.currentThread().stackTrace
            val index = if (stackTraceElements.size > 4) 4 else stackTraceElements.size - 1
            stringBuilder.append("[")
            stringBuilder.append(stackTraceElements[index].className).append(".")
            stringBuilder.append(stackTraceElements[index].methodName).append("(")
            stringBuilder.append(stackTraceElements[index].fileName).append(":")
                .append(stackTraceElements[index].lineNumber).append(")")
            stringBuilder.append("]")
            return stringBuilder.toString()
        }
}