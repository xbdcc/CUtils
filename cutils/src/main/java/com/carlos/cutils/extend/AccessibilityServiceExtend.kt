package com.carlos.cutils.extend

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.Rect
import android.os.Build
import android.view.accessibility.AccessibilityNodeInfo
import com.carlos.cutils.util.AccessibilityServiceUtils
import com.carlos.cutils.util.LogUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Carlos on 2020/3/3.
 */

fun AccessibilityService.findAndClickFirstNodeInfoByText(
    text: String,
    isReverse: Boolean = false,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) {
    AccessibilityServiceUtils.findAndClickFirstNodeInfoByText(
        text,
        isReverse,
        accessibilityNodeInfo
    )
}

fun AccessibilityService.findAndClickFirstNodeInfoByViewId(
    viewId: String,
    isReverse: Boolean = false,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) {
    AccessibilityServiceUtils.findAndClickFirstNodeInfoByViewId(
        viewId,
        isReverse,
        accessibilityNodeInfo
    )
}


fun AccessibilityService.clickFirstNodeInfo(
    accessibilityNodeInfos: MutableList<AccessibilityNodeInfo>?,
    isReverse: Boolean = false
) {
    AccessibilityServiceUtils.clickFirstNodeInfo(accessibilityNodeInfos, isReverse)
}

fun AccessibilityService.clickLastNodeInfo(accessibilityNodeInfos: MutableList<AccessibilityNodeInfo>?) {
    AccessibilityServiceUtils.clickFirstNodeInfo(accessibilityNodeInfos, true)
}

fun AccessibilityService.isExistNodeInfosByText(
    text: String,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) = AccessibilityServiceUtils.isExistNodeInfosByText(text, accessibilityNodeInfo)


fun AccessibilityService.isExistNodeInfosByViewId(
    viewId: String,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) = AccessibilityServiceUtils.isExistNodeInfosByViewId(viewId, accessibilityNodeInfo)

fun AccessibilityService.getNodeInfosByText(
    text: String,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) = AccessibilityServiceUtils.getNodeInfosByText(text, accessibilityNodeInfo)

fun AccessibilityService.getNodeInfosByViewId(
    viewId: String,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) = AccessibilityServiceUtils.getNodeInfosByViewId(viewId, accessibilityNodeInfo)

fun AccessibilityService.findAndClickFirstNodeInfoByViewId(
    viewId: String,
    childExistId: String,
    childNotExistIds: String,
    isJustClickLeft: Boolean,
    isReverse: Boolean = false,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
): Boolean = AccessibilityServiceUtils.findAndClickFirstNodeInfoByViewId(
    viewId,
    childExistId,
    childNotExistIds,
    isJustClickLeft,
    isReverse,
    accessibilityNodeInfo
)

fun AccessibilityService.findAndClickFirstNodeInfoByViewIdContainsText(
    viewId: String,
    childId: String,
    childIdContainsText: String,
    isReverse: Boolean = false,
    accessibilityNodeInfo: AccessibilityNodeInfo? = rootInActiveWindow
) = AccessibilityServiceUtils.findAndClickFirstNodeInfoByViewIdContainsText(
    viewId,
    childId,
    childIdContainsText,
    isReverse,
    accessibilityNodeInfo
)

fun AccessibilityService.gesturePath(path: Path, startTime: Long = 200L, duration: Long = 100L) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        val build = GestureDescription.Builder()
        val gestureDescription =
            build.addStroke(GestureDescription.StrokeDescription(path, startTime, duration)).build()
        dispatchGesture(gestureDescription, object : AccessibilityService.GestureResultCallback() {

            override fun onCompleted(gestureDescription: GestureDescription?) {
                super.onCompleted(gestureDescription)
            }

            override fun onCancelled(gestureDescription: GestureDescription?) {
                super.onCancelled(gestureDescription)
            }
        }, null)
    }
}

fun AccessibilityService.gestureViewCenter(
    viewId: String,
    startTime: Long = 200L,
    duration: Long = 100L
) {
    val accessibilityNodeInfos = getNodeInfosByViewId(viewId)
    if (accessibilityNodeInfos.isNullOrEmpty()) return
    val rect = Rect()
    accessibilityNodeInfos.reversed().first().getBoundsInScreen(rect)
    val path = Path()
    path.moveTo(rect.centerX().toFloat(), rect.centerY().toFloat())
    gesturePath(path, startTime, duration)
}

fun AccessibilityService.back() {
    performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
}

suspend fun AccessibilityService.getNodeInfosByViewId(viewId: String, interval: Long, times: Int): MutableList<AccessibilityNodeInfo>? {
    for(i in 0 until  times) {
        val data = getNodeInfosByViewId(viewId)
        if (data.isNullOrEmpty().not()) {
            return data
        }
        delay(interval)
    }
    return null
}

fun AccessibilityService.gesturePath(path: Path, startTime: Long = 200L, duration: Long = 100L, interval: Long, times: Int) {
    GlobalScope.launch {
        for(i in 0 until  times) {
            LogUtils.d("times:$i");
            gesturePath(path, startTime)
            delay(interval)
        }
    }
}