package com.carlos.cutils.helper

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import com.carlos.cutils.util.LogUtils

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-01-02.
 */
class SoundPoolHelper(maxStream: Int = 3, streamType: Int = AudioManager.STREAM_SYSTEM) {

    var soundPool: SoundPool? = null
    val defaultName = "sound"
    var soundsId: Int = 0
    var streamId: Int = 0
//    var leftVolume = 1f
//    var rightVolume = 1f
//    var priority = 1
//    var loop = 0
//    var rate = 1f

    init {
        soundPool = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            SoundPool(maxStream, streamType, 1)
        } else {
            val audioAttributes = AudioAttributes.Builder().setLegacyStreamType(streamType).build()
            SoundPool.Builder().setMaxStreams(maxStream)
                .setAudioAttributes(audioAttributes)
                .build()
        }
    }

    fun load(
        context: Context,
        resId: Int,
        soundName: String = defaultName,
        priority: Int = 1
    ): SoundPoolHelper {
        soundsId = soundPool!!.load(context, resId, priority)
        return this
    }

    /**
     * 需等待加载完播放
     */
    fun play(soundName: String = defaultName) {
        soundPool?.setOnLoadCompleteListener { soundPool, sampleId, status ->
            LogUtils.d("soundPool:$soundPool-sampleId:$sampleId-status:$status")
            // 左声道音量[0~1]，右声道音量[0~1]，播放优先级[0表示最低优先级]，循环模式[0循环1次，-1表示无限循环，其他数字表示循环多次]，播放速度[1正常，0.5~2.0]
            streamId = soundPool.play(soundsId, 0.2f, 0.2f, 0, 0, 1f)
//            if ((sampleId == soundsId) and (status == 0)) {
////                // 左声道音量[0~1]，右声道音量[0~1]，播放优先级[0表示最低优先级]，循环模式[0循环1次，-1表示无限循环，其他数字表示循环多次]，播放速度[1正常，0.5~2.0]
////                streamId = soundPool.play(soundsId, 0.5f, 0.5f, 0, 0, 1f)
//            }
        }
    }

    fun pause(soundName: String = defaultName) {
        soundPool?.pause(streamId)
    }

    fun release() {
        soundPool?.release()
        soundPool = null
    }
}