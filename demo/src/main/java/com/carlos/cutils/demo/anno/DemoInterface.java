package com.carlos.cutils.demo.anno;

/**
 * Created by Carlos on 2018/3/23.
 */

// 泛型接口的定义
interface DemoInterface<T1, T2>
{
    T2 doSomeOperation(T1 t);
    T1 doReverseOperation(T2 t);
}