package com.carlos.cutils.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/2/22.
 */
object DateUtils {

    private const val FORMAT_YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm"
    private const val FORMAT_YEAR_TO_SECOND = "yyyy-MM-dd HH:mm:ss"

    fun getYearToSecond(): String {
        return formateToSecond(System.currentTimeMillis())
    }

    fun formateToMinute(time: Long): String {
        return format(time, FORMAT_YEAR_TO_MINUTE)
    }

    fun formateToSecond(time: Long): String {
        return format(time, FORMAT_YEAR_TO_SECOND)
    }

    fun format(time: Long, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern)
        return dateFormat.format(Date(time))
    }

}