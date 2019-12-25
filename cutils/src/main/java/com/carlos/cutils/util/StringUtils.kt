package com.carlos.cutils.util

import com.carlos.cutils.constants.ONLY_ONE_CHINESE
import java.util.regex.Pattern


/**
 * Created by Carlos on 2019-12-17.
 */
object StringUtils {

    fun containsChinese(string: String): Boolean {
        return Pattern.compile(ONLY_ONE_CHINESE).matcher(string).find()
    }
}