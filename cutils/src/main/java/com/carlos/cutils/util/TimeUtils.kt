package com.carlos.cutils.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/2/22.
 */
object TimeUtils {

    private const val FORMAT_YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm"
    private const val FORMAT_YEAR_TO_SECOND = "yyyy-MM-dd HH:mm:ss"

    fun getYearToMinute(time: Long = System.currentTimeMillis()): String {
        return formatTime(time, FORMAT_YEAR_TO_MINUTE)
    }

    fun getYearToSecond(time: Long = System.currentTimeMillis()): String {
        return formatTime(time, FORMAT_YEAR_TO_SECOND)
    }

    fun formatTime(time: Long, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern)
        return dateFormat.format(Date(time))
    }

}