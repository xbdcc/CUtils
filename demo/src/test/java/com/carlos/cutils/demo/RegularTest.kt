package com.carlos.cutils.demo

import com.carlos.cutils.util.StringUtils
import org.junit.Test

/**
 * Created by Carlos on 2019-12-17.
 */
class RegularTest {

    var string = "23fdg哥发的"

    @Test
    fun testIsOnly() {
        val isOnly = StringUtils.isOnlyChinese(string)
        println(isOnly)
    }

    @Test
    fun testIsContains() {
        val isContaions = StringUtils.isContainsChinese(string)
        println(isContaions)
    }

    @Test
    fun testOnly() {
        string = StringUtils.onlyChinese(string)
        println(string)
    }
}