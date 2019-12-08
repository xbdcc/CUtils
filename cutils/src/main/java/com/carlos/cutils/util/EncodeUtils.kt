package com.carlos.cutils.util

import android.net.Uri

/**
 * Created by Carlos on 2019-12-08.
 */
object EncodeUtils {

    fun encodeChineseUrl(url: String): String {
        return Uri.encode(url, "-![.:/,%?&=]")
    }
}