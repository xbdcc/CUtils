package com.carlos.cutils.util

import java.util.*

/**
 * Created by Carlos on 2019-09-24.
 */
class TimerHelper(private val spaceTime: Long, private val mTimeProcessor: TimeProcessor) {
    private lateinit var mTimer: Timer
    private lateinit var mTimerTask: TimerTask

    fun startDelayTime(delayTime: Long) {
        mTimer = Timer()
        mTimerTask = object : TimerTask() {
            override fun run() {
                mTimeProcessor.process()
            }
        }
        mTimer.schedule(mTimerTask, delayTime)
    }

    fun startTime() {
        mTimer = Timer()
        mTimerTask = object : TimerTask() {
            override fun run() {
                mTimeProcessor.process()
            }
        }
        val date = Date(System.currentTimeMillis())
        mTimer.scheduleAtFixedRate(mTimerTask, date, spaceTime)
    }

    fun stopTime() {
        if (this::mTimer.isInitialized)
            mTimer.cancel()
        if (this::mTimerTask.isInitialized)
            mTimerTask.cancel()
    }

    interface TimeProcessor {
        fun process()
    }

    fun abc() {
        TimerHelper(100, object : TimeProcessor {
            override fun process() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}