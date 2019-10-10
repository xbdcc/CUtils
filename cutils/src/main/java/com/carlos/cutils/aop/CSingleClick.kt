package com.carlos.cutils.aop

/**
 * Created by Carlos on 2019-09-27.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class CSingleClick(val value: Long = 100)