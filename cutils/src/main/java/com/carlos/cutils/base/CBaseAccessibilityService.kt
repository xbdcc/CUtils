package com.carlos.cutils.base

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

/**
 * {@link CBaseAccessibilityService}
 * Created by Carlos on 2020/3/5.
 */
abstract class CBaseAccessibilityService : AccessibilityService() {

    open var monitorPackageName: String = ""
    var currentClassName: String = ""
    var isMonitor: Boolean = true
    var isMonitorNotification = true
    var isMonitorWindow = true
    var isMonitorContent = true

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (isMonitor.not()) {
            return
        }
        if (rootInActiveWindow == null) {
            return
        }
        if (monitorPackageName.isNotEmpty() and (monitorPackageName != event.packageName)) {
            return
        }
        currentClassName = event.className.toString()
        monitorAccessibilityEvent(event)
    }

    private fun monitorAccessibilityEvent(event: AccessibilityEvent) {
        when (event.eventType) {
            AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED -> {
                if (isMonitorNotification) {
                    monitorNotificationChanged(event)
                }
            }
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                if (isMonitorWindow) {
                    monitorWindowChanged(event)
                }
            }
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                if (isMonitorContent) {
                    monitorContentChanged(event)
                }
            }
        }
    }

    abstract fun monitorNotificationChanged(event: AccessibilityEvent)

    abstract fun monitorWindowChanged(event: AccessibilityEvent)

    abstract fun monitorContentChanged(event: AccessibilityEvent)

//    override fun onServiceConnected() {
//        super.onServiceConnected()
//        val accessibilityServiceInfo = AccessibilityServiceInfo()
//        accessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK
//        accessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
//        accessibilityServiceInfo.notificationTimeout = 100
//        accessibilityServiceInfo.flags =
//            serviceInfo.flags or AccessibilityServiceInfo.FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY
//        serviceInfo = accessibilityServiceInfo
//    }

}