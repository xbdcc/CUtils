package com.carlos.cutils.base

import android.text.InputFilter
import android.text.Spanned
import com.carlos.cutils.util.StringUtils

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-12-27.
 */
open class CBaseInputFilter(max: Int) : InputFilter, InputFilter.LengthFilter(max) {
    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence {
        val string = filterChinese(source.toString())
        return if (string == source.toString()) {
            source
        } else {
            string
        }
    }

    fun filterChinese(text: String): String {
        return StringUtils.onlyChinese(text)
    }
}