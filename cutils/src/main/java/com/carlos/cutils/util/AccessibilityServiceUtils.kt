package com.carlos.cutils.util

import android.view.accessibility.AccessibilityNodeInfo

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/2/20.
 */
object AccessibilityServiceUtils {

    fun findAndClickFirstNodeInfoByText(
        text: String,
        isReverse: Boolean = false,
        accessibilityNodeInfo: AccessibilityNodeInfo?
    ) {
        val node = accessibilityNodeInfo?.findAccessibilityNodeInfosByText(text)
        clickFirstNodeInfo(node, isReverse)
    }

    fun findAndClickFirstNodeInfoByViewId(
        viewId: String,
        isReverse: Boolean = false,
        accessibilityNodeInfo: AccessibilityNodeInfo?
    ) {
        val accessibilityNodeInfos =
            accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(viewId)
        clickFirstNodeInfo(accessibilityNodeInfos, isReverse)
    }

    fun clickFirstNodeInfo(
        accessibilityNodeInfos: MutableList<AccessibilityNodeInfo>?,
        isReverse: Boolean = false
    ) {
        if (accessibilityNodeInfos.isNullOrEmpty()) {
            return
        }
        if (isReverse) {
            accessibilityNodeInfos.last().performAction(AccessibilityNodeInfo.ACTION_CLICK)
        } else {
            accessibilityNodeInfos.first().performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    fun isExistNodeInfosByText(text: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByText(text)?.isNotEmpty() ?: false

    fun isExistNodeInfosByViewId(viewId: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(viewId)?.isNotEmpty() ?: false

    fun getNodeInfosByText(text: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByText(text)

    fun getNodeInfosByViewId(viewId: String, accessibilityNodeInfo: AccessibilityNodeInfo?) =
        accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(viewId)

    fun findAndClickFirstNodeInfoByViewId(
        viewId: String,
        childExistId: String,
        childNotExistIds: String,
        isReverse: Boolean = false,
        accessibilityNodeInfo: AccessibilityNodeInfo?
    ): Boolean {
        var accessibilityNodeInfos =
            accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(viewId) ?: return false
        if (isReverse) accessibilityNodeInfos = accessibilityNodeInfos.reversed()
        for (accessibilityNodeInfo in accessibilityNodeInfos) {
            if (isExistNodeInfosByViewId(childNotExistIds, accessibilityNodeInfo))
                continue
            if (!isExistNodeInfosByViewId(childExistId, accessibilityNodeInfo))
                continue
            accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            return true

        }
        return false
    }

    fun findAndClickFirstNodeInfoByViewIdContainsText(
        viewId: String,
        childId: String,
        childIdContainsText: String,
        isReverse: Boolean = false,
        accessibilityNodeInfo: AccessibilityNodeInfo?
    ): Boolean {
        var accessibilityNodeInfos =
            accessibilityNodeInfo?.findAccessibilityNodeInfosByViewId(viewId) ?: return false
        if (isReverse) accessibilityNodeInfos = accessibilityNodeInfos.reversed()
        for (accessibilityNodeInfo in accessibilityNodeInfos) {
            val childNodeInfo = getNodeInfosByViewId(childId, accessibilityNodeInfo)
            if (childNodeInfo.isNullOrEmpty()) {
                return false
            }
            if (childNodeInfo.first().text.contains(childIdContainsText)) {
                accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                return true
            }
        }
        return false
    }

}