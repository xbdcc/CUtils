package com.carlos.cutils.util

import android.view.accessibility.AccessibilityNodeInfo

/**
 * Created by Carlos on 2019/2/20.
 */
object AccessibilityServiceUtils {

    fun findAndClickFirstOneByText(text: String, accessibilityNodeInfo: AccessibilityNodeInfo) {
        val node = accessibilityNodeInfo.findAccessibilityNodeInfosByText(text)
        if (node.isNotEmpty()) {
            node[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    fun findAndClickFirstOneById(resId: String, accessibilityNodeInfo: AccessibilityNodeInfo) {
        val node = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(resId)
        if (node.isNotEmpty()) {
            node[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    fun isExistElementByText(text: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByText(text)?.isNotEmpty() ?: false

    fun isExistElementById(resId: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(resId)?.isNotEmpty() ?: false

}