package com.carlos.cutils.demo

import android.app.Application
import android.util.Log
import java.util.*

/**
 * Created by Carlos on 2018/2/27.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("xbd", Date().toString())
//        Thread.sleep(3000)
        Log.d("xbd", Date().toString())
//        Thread.sleep(18000)
        Log.d("xbd", Date().toString())
    }

    companion object {

        @get:Synchronized
        lateinit var instance: MyApplication
    }
}
