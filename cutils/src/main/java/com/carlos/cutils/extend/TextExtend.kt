package com.carlos.cutils.extend

import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*
import android.widget.TextView
import com.carlos.cutils.util.ClipboardManagerUtils


/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-02-20.
 */
fun <T : TextView> T.clipText() {
    ClipboardManagerUtils.clipText(this.context, this.text)
}

fun <T : TextView> T.setClipText() {
    val text = ClipboardManagerUtils.getClipText(this.context)
    this.text = text
}

/**
 * [spannableFlags]：取值有如下四个
 * [Spannable.SPAN_EXCLUSIVE_EXCLUSIVE] ：前后都不包括，即在指定范围的前面和后面插入新字符都不会应用新样式
 * [Spannable.SPAN_EXCLUSIVE_INCLUSIVE] ：前面不包括，后面包括。即仅在范围字符的后面插入新字符时会应用新样式
 * [Spannable.SPAN_INCLUSIVE_EXCLUSIVE] ：前面包括，后面不包括。
 * [Spannable.SPAN_INCLUSIVE_INCLUSIVE] ：前后都包括。
 */
fun <T : TextView> T.underLine(
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spanString = SpannableString(text)
    spanString.setSpan(UnderlineSpan(), start, end, spannableFlags)
    text = spanString
}

fun <T : TextView> T.centerLine(
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spannableStringBuilder = SpannableStringBuilder(text)
    spannableStringBuilder.setSpan(StrikethroughSpan(), start, end, spannableFlags)
    text = spannableStringBuilder
}

fun <T : TextView> T.textColor(
    color: Int,
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spannableString = SpannableString(text)
    spannableString.setSpan(ForegroundColorSpan(color), start, end, spannableFlags)
    text = spannableString
}

fun <T : TextView> T.textBackgroundColor(
    color: Int,
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spannableString = SpannableString(text)
    spannableString.setSpan(BackgroundColorSpan(color), start, end, spannableFlags)
    text = spannableString
}

fun <T : TextView> T.textSize(
    size: Int,
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spannableString = SpannableString(text)
    spannableString.setSpan(AbsoluteSizeSpan(size), start, end, spannableFlags)
    text = spannableString
}

fun <T : TextView> T.textStyle(
    style: Int,
    start: Int = 0,
    end: Int = text.length,
    spannableFlags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
) {
    val spannableString = SpannableString(text)
    spannableString.setSpan(StyleSpan(style), start, end, spannableFlags)
    text = spannableString
}

