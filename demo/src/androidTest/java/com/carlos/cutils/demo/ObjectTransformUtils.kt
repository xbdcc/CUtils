package com.carlos.cutils.demo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.carlos.cutils.util.LogUtils
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Carlos on 2019-11-20.
 */
@RunWith(AndroidJUnit4::class)
class ObjectTransformUtils {

    @Test
    fun testaaa() {
//        val map = HashMap<String, Any>()
        val map = mutableMapOf<String, Any>()
        map["a"] = "a"
        map["b"] = "123"

        val json = JSONObject(map)
        LogUtils.d("json:" + json.get("a"))
        LogUtils.d("json:" + json["b"])

    }


    fun abc() {

    }
    
}