package com.carlos.cutils.util;

import android.util.Log;

/**
 * Created by Carlos on 2018/3/6.
 */

public class LogUtil {
    private static final String TAG="LogUtil";

    public static void i(String msg){
        Log.i(TAG,getLogTitle()+msg);
    }

    public static void i(String msg,Throwable throwable){
        Log.i(TAG,getLogTitle()+msg,throwable);
    }

    public static void d(String msg){
        Log.d(TAG,getLogTitle()+msg);
    }

    public static void d(String msg,Throwable throwable){
        Log.d(TAG,getLogTitle()+msg,throwable);
    }

    public static void e(String msg){
        Log.i(TAG,getLogTitle()+msg);
    }

    public static void e(String msg,Throwable throwable){
        Log.e(TAG,getLogTitle()+msg,throwable);
    }

    public static String getLogTitle(){
        StringBuilder stringBuilder=new StringBuilder();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        int index=stackTraceElements.length>4?4:stackTraceElements.length-1;
        stringBuilder.append("[");
        stringBuilder.append(stackTraceElements[index].getClassName()).append(".");
        stringBuilder.append(stackTraceElements[index].getMethodName()).append("()").append(":");
        stringBuilder.append("lineNumber=").append(stackTraceElements[index].getLineNumber());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
