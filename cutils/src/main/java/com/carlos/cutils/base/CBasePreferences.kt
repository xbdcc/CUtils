package com.carlos.cutils.base

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Carlos on 2019/2/21.
 * Same proccess to use.
 */
open class CBasePreferences(private val fileName: String) {

    open fun setString(context: Context, key: String, value: String) {
        getEditor(context).putString(key, value).apply()
    }

    open fun getString(context: Context, key: String, defaultValue: String): String {
        return getSharedPreferences(context).getString(key, defaultValue)
    }

    open fun setInt(context: Context, key: String, value: Int) {
        getEditor(context).putInt(key, value).apply()
    }

    open fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    open fun setLong(context: Context, key: String, value: Long) {
        getEditor(context).putLong(key, value).apply()
    }

    open fun getLong(context: Context, key: String, defaultValue: Long): Long {
        return getSharedPreferences(context).getLong(key, defaultValue)
    }

    open fun setBoolean(context: Context, key: String, value: Boolean) {
        getEditor(context).putBoolean(key, value).apply()
    }

    open fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit()
    }

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

}