package com.carlos.cutils.demo

import org.junit.Test
import java.text.DecimalFormat

/**
 * Created by Carlos on 2020/2/29.
 */
class MathTest {

    @Test
    fun doubleCount() {
        println(2.05.plus(0.01))
        println(2.05 + 0.01)
        println(1.10 - 0.42)
        println(5.015 * 100)
        println(123.3 / 100)


        var total = 2.05.toBigDecimal() + "0.01".toBigDecimal()
        println(total)

        var total2 = DecimalFormat("0.00").format(2.05 + 0.01)
        println(total2)

    }

}
