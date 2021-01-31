package com.carlos.cutils.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Created by Carlos on 2020/11/28.
 * TV文字落焦跑马灯
 */
class TextViewAlwaysMarquee(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        ellipsize = TextUtils.TruncateAt.MARQUEE
        marqueeRepeatLimit = -1
        setSingleLine()
    }

    /**
     * 用于外部获取焦点
     */
    fun showMarquee(isShow: Boolean) {
        ellipsize = if (isShow)
            TextUtils.TruncateAt.MARQUEE
        else
            null
    }

    override fun isFocused(): Boolean {
        return true
    }

}