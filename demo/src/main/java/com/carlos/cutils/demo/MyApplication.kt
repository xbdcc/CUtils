package com.carlos.cutils.demo

import android.app.Application

/**
 * Created by Carlos on 2018/2/27.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        @get:Synchronized
        lateinit var instance: MyApplication
    }
}
