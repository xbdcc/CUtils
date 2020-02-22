package com.carlos.cutils.aop

import android.view.View
import com.carlos.cutils.util.LogUtils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019-09-28.
 */
@Aspect
class CSingleClickAspect {

    /**
     * 定义切点，标记切点为所有被@SingleClick注解的方法
     */
    @Pointcut("execution(@com.carlos.cutils.aop.CSingleClick * *(..))")
    fun methodAnnotated() {}

    @Around("methodAnnotated()")
    @Throws(Throwable::class)
    fun aroundJoinPoint(joinPoint: ProceedingJoinPoint) {
        //get out the parameters of the method
        var view: View? = null
        for(arg in joinPoint.args) {
            if (arg is View) {
                view = arg
                break
            }
        }
        if (view == null) {
            return
        }

        //取出方法的注解
        val methodSignature = joinPoint.signature as MethodSignature
        val method = methodSignature.method
        if (!method.isAnnotationPresent(CSingleClick::class.java)) {
            return
        }
        val singleClick = method.getAnnotation(CSingleClick::class.java)
        //判断是否是快速点击
        if (!CClickUtils.isFastDoubleClick(view, singleClick.value)) {
            //不是快速点击，执行原方法
            joinPoint.proceed()
            LogUtils.d("点击")
        }

    }

}