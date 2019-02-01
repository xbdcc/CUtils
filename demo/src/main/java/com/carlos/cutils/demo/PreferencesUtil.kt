package com.carlos.cutils.demo

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Carlos on 2018/3/21.
 */

object PreferencesUtil {

    private var FILE_NAME = "preference_control"

    fun setString(context: Context, key: String, value: String) {
        getEditor(context).putString(key, value).commit()
    }

    fun getString(context: Context, key: String, defaultValue: String): String? {
        return getSharedPreferences(context).getString(key, defaultValue)
    }


    fun setInt(context: Context, key: String, value: Int) {
        getEditor(context).putInt(key, value).commit()
    }

    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    fun setFloat(context: Context, key: String, value: Float) {
        getEditor(context).putFloat(key, value).commit()
    }

    fun getFloat(context: Context, key: String, defaultValue: Float): Float {
        return getSharedPreferences(context).getFloat(key, defaultValue)
    }

    fun setBoolean(context: Context, key: String, defaultValue: Boolean) {
        getEditor(context).putBoolean(key, defaultValue).commit()
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }


    fun setFileName(fileName: String) {
        FILE_NAME = fileName
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        val sharedPreferences = context
            .getSharedPreferences(FILE_NAME, Context.MODE_MULTI_PROCESS)
        return sharedPreferences.edit()
    }


    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_MULTI_PROCESS)
    }

}
