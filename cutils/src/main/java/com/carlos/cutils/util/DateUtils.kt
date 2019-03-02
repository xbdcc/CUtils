package com.carlos.cutils.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Carlos on 2019/2/22.
 */
object DateUtils {

    private const val FORMAT_YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm"

    fun formatDate(time: Long): String {
        return format(time, FORMAT_YEAR_TO_MINUTE)
    }

    fun format(time: Long, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern)
        return dateFormat.format(Date(time))
    }

}