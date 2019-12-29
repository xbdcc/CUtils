package com.carlos.cutils.util

import com.carlos.cutils.constants.LEAVE_ONLY_CHINESE
import com.carlos.cutils.constants.ONLY_CHINESE
import com.carlos.cutils.constants.ONLY_ONE_CHINESE
import java.util.regex.Pattern


/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-12-17.
 */
object StringUtils {

    fun isContainsChinese(string: String): Boolean {
        return Pattern.compile(ONLY_ONE_CHINESE).matcher(string).find()
    }

    fun isOnlyChinese(string: String): Boolean {
        return Pattern.compile(ONLY_CHINESE).matcher(string).matches()
    }

    fun onlyChinese(string: String): String {
        return Pattern.compile(LEAVE_ONLY_CHINESE).matcher(string).replaceAll("")
    }
}