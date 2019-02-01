package com.carlos.cutils.demo

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by Carlos on 2018/3/1.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CLASS,
    AnnotationTarget.FILE
)
annotation class QueryPermission(val permission: Array<String>)
