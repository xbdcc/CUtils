package com.carlos.cutils.demo

import com.carlos.cutils.util.DateUtils
import org.junit.Test

/**
 * Created by Carlos on 2020-02-21.
 */
class DateTest {

    @Test
    fun testDate() {
        println(DateUtils.formateToSecond(System.nanoTime()))
        println(DateUtils.formateToSecond(System.currentTimeMillis()))
    }
}