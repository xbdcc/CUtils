package com.carlos.cutils.extend

/**
 * Created by Carlos on 2020/3/1.
 */
fun Double.doubleCount(data: Double): Double {
    val result = this.toBigDecimal().plus(data.toBigDecimal())
    return result.toDouble()
}


