package com.carlos.cutils.util

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

/**
 * Created by Carlos on 2019-05-20.
 */
object ThemeUtils {

    /**
     * set the background fullscreen and the statusbar translucent on it.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun setBarTranslucent(activity: Activity, isFitSystemWindow: Boolean = true) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = activity.window
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
        setFitSystemWindow(activity, isFitSystemWindow)
    }

    /**
     * if need top closed to statusbar, should uses this method or set "fitsSystemWindows=true" to xml root.
     */
    fun setFitSystemWindow(activity: Activity, isFitSystemWindow: Boolean) {
        if (isFitSystemWindow)
            activity.findViewById<ViewGroup>(android.R.id.content).getChildAt(0).fitsSystemWindows =
                isFitSystemWindow
    }

}