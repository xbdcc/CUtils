package com.carlos.cutils.demo

import com.carlos.cutils.extend.getYearToSecond
import org.junit.Test

/**
 * Created by Carlos on 2020-02-21.
 */
class DateTest {

    @Test
    fun testDate() {
        println(getYearToSecond(System.nanoTime()))
        println(getYearToSecond(System.currentTimeMillis()))
    }
}