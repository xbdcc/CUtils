package com.carlos.cutils.demo.anno

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by Carlos on 2019/1/24.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(RetentionPolicy.RUNTIME)
annotation class PermissionFail(val requestCode: Int)
