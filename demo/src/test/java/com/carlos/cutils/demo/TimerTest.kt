package com.carlos.cutils.demo

import org.junit.Test

import java.util.Timer
import java.util.TimerTask

/**
 * Created by Carlos on 2018/3/12.
 */

class TimerTest {
    internal var count = -1
    internal var imageCount = -1

    @Test
    fun testa() {
        val timer = Timer()
        println("timestart:" + System.currentTimeMillis())
        val timerTask = object : TimerTask() {
            override fun run() {
                println("time:" + System.currentTimeMillis())

                imageCount++
                if (imageCount == 1) println("上移")
                if (imageCount == 2) println("回中间")
                if (imageCount == 3) println("下移")
                if (imageCount == 4) {
                    println("回中间")
                    imageCount = 0
                }
                count++
                if (count == 2)
                    println("努力加载中 ·")
                if (count == 4)
                    println("努力加载中 ··")
                if (count == 5)
                    println("努力加载中 ···")
                if (count == 8) {
                    count = 0
                    println("timereload:" + System.currentTimeMillis())
                }

            }
        }
        timer.scheduleAtFixedRate(timerTask, 0, 120)

        try {
            Thread.sleep((2 * 1000).toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}
