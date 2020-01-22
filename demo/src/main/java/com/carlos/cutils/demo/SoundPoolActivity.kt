package com.carlos.cutils.demo

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import com.carlos.cutils.base.activity.CBaseActivity
import com.carlos.cutils.extend.clickSound
import com.carlos.cutils.helper.SoundPoolHelper
import com.carlos.cutils.util.SoundPoolUtils
import kotlinx.android.synthetic.main.activity_sound.*

/**
 * Created by Carlos on 2020-01-02.
 */
class SoundPoolActivity : CBaseActivity() {

    lateinit var soundPool: SoundPool
    var soundId1: Int = 0
    var streamId1: Int = 0
    var soundId2: Int = 0
    lateinit var soundPoolHelper: SoundPoolHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)
        init()
    }

    fun init() {
        initSound()
        soundPoolHelper = SoundPoolHelper()
//        b_play.setOnClickListener{
////            play()
//            SoundPoolUtils.play(R.raw.radio, this)
//        }
        b_play.clickSound(R.raw.radio) {}
        b_pause.setOnClickListener {
//            pause()
            SoundPoolUtils.pause()
        }
    }

    /**
     * 测试发现播放radio到大概11秒左右，后面会被截断
     */
    fun initSound(){
        val audioAttributes = AudioAttributes.Builder().setLegacyStreamType(AudioManager.STREAM_SYSTEM).build()
        soundPool = SoundPool.Builder().setMaxStreams(3)
            .setAudioAttributes(audioAttributes)
            .build()


//        soundPool = SoundPool(3, AudioManager.STREAM_SYSTEM, 1)
//        soundId = soundPool.load(this, R.raw.metro, 1)
        soundId1 = soundPool.load(this, R.raw.radio, 1)
//        soundId2 = soundPool.load(this, R.raw.hua, 1)
//        soundId = soundPool.load(this, R.raw.cao, 1)

    }

    fun play() {
        // 左声道音量[0~1]，右声道音量[0~1]，播放优先级[0表示最低优先级]，循环模式[0循环1次，-1表示无限循环，其他数字表示循环多次]，播放速度[1正常，0.5~2.0]
        soundPool.setOnLoadCompleteListener { soundPool, sampleId, status ->
            streamId1 = soundPool.play(soundId1, 0.3f, 0.3f, 0, 0, 1f)

        }
//        streamId1 = soundPool.play(soundId1, 0.3f, 0.3f, 0, 0, 1f)
//        soundPool.play(soundId2, 1f, 1f, 0, 0, 1f)
    }

    fun pause() {
        soundPool.pause(streamId1)
//        soundPool.pause(soundId2)
    }
}