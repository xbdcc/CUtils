package com.carlos.cutils.base

import android.content.Context
import android.content.SharedPreferences
import com.carlos.cutils.CUtils

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/2/21.
 * Same proccess to use.
 */
open class CBasePreferences(
    private val fileName: String,
    private val cContext: Context = CUtils.cContext
) {

    open fun setString(key: String, value: String): Boolean {
        return getEditor(cContext).putString(key, value).commit()
    }

    open fun setStringAsyn(key: String, value: String) {
        getEditor(cContext).putString(key, value).apply()
    }

    open fun getString(key: String, defaultValue: String): String {
        return getSharedPreferences(cContext).getString(key, defaultValue)
    }

    open fun setInt(key: String, value: Int): Boolean {
        return getEditor(cContext).putInt(key, value).commit()
    }

    open fun setIntAsyn(key: String, value: Int) {
        getEditor(cContext).putInt(key, value).apply()
    }

    open fun getInt(key: String, defaultValue: Int): Int {
        return getSharedPreferences(cContext).getInt(key, defaultValue)
    }

    open fun setLong(key: String, value: Long): Boolean {
        return getEditor(cContext).putLong(key, value).commit()
    }

    open fun setLongAsyn(key: String, value: Long) {
        getEditor(cContext).putLong(key, value).apply()
    }

    open fun getLong(key: String, defaultValue: Long): Long {
        return getSharedPreferences(cContext).getLong(key, defaultValue)
    }

    open fun setBoolean(key: String, value: Boolean): Boolean {
        return getEditor(cContext).putBoolean(key, value).commit()
    }

    open fun setBooleanAsyn(key: String, value: Boolean) {
        getEditor(cContext).putBoolean(key, value).apply()
    }

    open fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences(cContext).getBoolean(key, defaultValue)
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit()
    }

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

}