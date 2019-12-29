package com.carlos.cutils.util

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder

import com.carlos.cutils.listener.VoiceListener

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2018/3/6.
 */

class VoiceUtil {
    private var mAudioRecord: AudioRecord? = null
    private var isGetVoiceRun: Boolean = false
    private var mLock = java.lang.Object()

    fun startRecordVoice(voiceListener: VoiceListener) {
        if (isGetVoiceRun) {
            LogUtils.d("还在录着呢")
            return
        }

        isGetVoiceRun = true
        mAudioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            SAMPLE_RATE_IN_HZ, AudioFormat.CHANNEL_IN_DEFAULT,
            AudioFormat.ENCODING_PCM_16BIT, BUFFER_SIZE
        )
        if (mAudioRecord == null) {
            LogUtils.e("mAudioRecord初始化失败")
            return
        } else {
            LogUtils.d("mAudioRecord初始化成功")
        }

        Thread(Runnable {
            mAudioRecord!!.startRecording()
            val buffer = ShortArray(BUFFER_SIZE)
            while (isGetVoiceRun) {
                //r是实际读取的数据长度，一般而言r会小于buffersize
                val r = mAudioRecord!!.read(buffer, 0, BUFFER_SIZE)
                var v: Long = 0
                // 将 buffer 内容取出，进行平方和运算
                for (i in buffer.indices) {
                    v += (buffer[i] * buffer[i]).toLong()
                }
                // 平方和除以数据总长度，得到音量大小。
                val mean = v / r.toDouble()
                val volume = 10 * Math.log10(mean)//得到分贝大小
                voiceListener.getSize(volume)
                // 大概一秒十次
                synchronized(mLock) {
                    try {
                        mLock.wait(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }
            mAudioRecord!!.stop()
            mAudioRecord!!.release()
            mAudioRecord = null
            LogUtils.d("停止录制")
            isGetVoiceRun = false
        }).start()
    }

    /**
     * 停止录制，下次开启时要先取消本次操作。
     */
    fun stopRecordVoice() {
        isGetVoiceRun = false
    }

    companion object {

        @Volatile
        private var instance: VoiceUtil? = null
        internal val SAMPLE_RATE_IN_HZ = 8000
        internal val BUFFER_SIZE = android.media.AudioRecord.getMinBufferSize(
            SAMPLE_RATE_IN_HZ,
            AudioFormat.CHANNEL_IN_DEFAULT, AudioFormat.ENCODING_PCM_16BIT
        )

        fun getInstance(): VoiceUtil? {
            if (instance == null) {
                synchronized(VoiceUtil::class.java) {
                    if (instance == null)
                        instance = VoiceUtil()
                }
            }
            return instance
        }
    }

}
