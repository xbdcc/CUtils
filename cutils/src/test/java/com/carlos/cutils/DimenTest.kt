package com.carlos.cutils

import org.junit.Test
import java.lang.StringBuilder

/**
 * Created by Carlos on 2020/11/24.
 * dimen适配转换测试
 */
class DimenTest {

    @Test
    fun convert1080to720() {
        convertDimen(data, 1080, 720)
    }

    @Test
    fun printlnPx() {
        for (i in 1..1180) {
            println(" <dimen name=\"px$i\">${i}px</dimen>")
        }
    }

    private fun convertDimen(data: String, oldDimen: Int, newDimen: Int) {
        val result = StringBuilder()
        for (line in data.lines()) {
            val dataRegex = Regex("(?<=>).*(?=[dp][px])")
            val string =
                dataRegex.replace(line) { (it.value.toInt() * newDimen / oldDimen).toString() }
            result.appendLine(string)
        }
        println(result)
    }

    private val data: String = """
    <dimen name="dimen_3600px">360px</dimen>
    <dimen name="dimen_720px">720px</dimen>
    <dimen name="dimen_1080px">1080px</dimen>
    """.trimIndent()
}