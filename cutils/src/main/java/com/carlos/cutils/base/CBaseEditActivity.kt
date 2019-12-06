package com.carlos.cutils.base

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ScrollView
import com.carlos.cutils.util.LogUtils.d

/**
 * Created by Carlos on 2019-12-06.
 */
class CBaseEditActivity : CBaseActivity() {

    fun openSoftInput(view: View) {
        val imm =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val isOpen = imm.isActive
        if (isOpen) {
            view.postDelayed({ imm.showSoftInput(view, 0) }, 200)
        }
    }

    fun hideSoftInput(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val isOpen = imm.isActive
        if (isOpen) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun isOpen(view: View): Boolean {
        val imm =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive
    }

    interface OpenListener {
        val isOpen: Unit
        val isHide: Unit
    }

    fun openOrhide(
        view: View,
        activity: Activity,
        openListener: OpenListener
    ) { //当键盘弹出隐藏的时候会 调用此方法。
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            //获取当前界面可视部分
            activity.window.decorView.getWindowVisibleDisplayFrame(r)
            //获取屏幕的高度
            val screenHeight = activity.window.decorView.rootView.height
            //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
            val heightDifference = screenHeight - r.bottom
            d("Keyboard Size: $heightDifference")
            if (heightDifference > 0) openListener.isOpen else openListener.isHide
        }
    }

    /**
     * 点击非Edittext区域隐藏键盘
     *
     * @param view
     */
    fun outsideHideKeyboard(
        view: View,
        ignoreList: List<Int>,
        clearFocusList: List<Int>
    ) { //Set up touch listener for non-text box views to hide keyboard.
        if (view is EditText) return
        for (i in ignoreList) {
            if (view.id == i) return
        }
        view.setOnTouchListener { v: View?, event: MotionEvent? ->
            hideSoftInput(view)
            false
        }

//If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                outsideHideKeyboard(innerView, ignoreList, clearFocusList)
            }
        }
    }

    fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is ScrollView) {
            val leftTop = intArrayOf(0, 0)
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.getHeight()
            val right = left + v.getWidth()
            return if (event.x > left && event.x < right && event.y > top && event.y < bottom
            ) { // 点击的是输入框区域，保留点击EditText的事件
                false
            } else {
                true
            }
        }
        return false
    }

}