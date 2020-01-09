package com.carlos.cutils.util

import android.content.Context
import com.carlos.cutils.helper.SoundPoolHelper

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-01-02.
 */
object SoundPoolUtils {

    var soundPoolHelper: SoundPoolHelper = SoundPoolHelper()

    fun play(resId: Int, context: Context) {
        soundPoolHelper.pause()
        soundPoolHelper.load(context, resId).play()
    }

    fun pause() {
        soundPoolHelper.pause()
    }

    fun release() {
        soundPoolHelper.release()
    }
}