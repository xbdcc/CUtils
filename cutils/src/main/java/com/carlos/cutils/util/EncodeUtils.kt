package com.carlos.cutils.util

import android.net.Uri

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-12-08.
 */
object EncodeUtils {

    fun encodeChineseUrl(url: String): String {
        return Uri.encode(url, "-![.:/,%?&=]")
    }
}