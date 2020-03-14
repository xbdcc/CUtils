package com.carlos.cutils.extend

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-02-21.
 */
fun <T> List<T>.filter(predicate: (T) -> Boolean): MutableList<T> {
    val result = ArrayList<T>()
    this.forEach {
        //this指的是调用者对象
        if (predicate(it)) {//如果满足循环条件
            result.add(it)
        }
    }
    return result
}

fun test() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7)
    val filter = list.filter { it % 2 == 0 }
    println(filter)
}