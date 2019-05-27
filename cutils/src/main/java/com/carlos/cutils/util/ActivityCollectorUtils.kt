package com.carlos.cutils.util

import android.app.Activity

/**
 * A tool class to controll finish activity.
 * add in onCreate method, remove in onDestroy method.
 * Created by Carlos on 2019-05-27.
 */
object ActivityCollectorUtils {

    val sActivities = arrayListOf<Activity>()

    fun addActivity(activity: Activity) {
        sActivities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        sActivities.remove(activity)
    }

    fun finishAll() {
        for (activity in sActivities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }
}