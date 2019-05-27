package com.carlos.cutils.demo.anno;

/**
 * Created by Carlos on 2018/3/23.
 */

//实现泛型接口的类
class DemoClass
{
    public void a(){
        DemoInterface<String> demoInterface;
//        demoInterface.doSomeOperation("");
    }

    interface DemoInterface<T>
    {
        void doSomeOperation(T t);
    }

//    // 泛型接口的定义
//    interface DemoInterface<T1, T2>
//    {
//        T2 doSomeOperation(T1 t);
//        T1 doReverseOperation(T2 t);
//    }

}