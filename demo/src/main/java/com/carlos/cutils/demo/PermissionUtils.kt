package com.carlos.cutils.demo

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.carlos.cutils.demo.anno.PermissionFail
import com.carlos.cutils.demo.anno.PermissionSucceed
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.*

/**
 * Created by Carlos on 2018/3/2.
 */

class PermissionUtils private constructor() {

    init {
        throw UnsupportedOperationException("不能被实例化")
    }

    companion object {

        /**
         * 判断当前系统是否大于6.0
         * @return
         */
        val isOverMarshmallow: Boolean
            get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

        fun executeSuccessMethod(reflectObject: Any, requestCode: Int) {
            // 获取class中所有方法去
            val methods = reflectObject.javaClass.declaredMethods
            for (method in methods) {
                val succeedMethod = method.getAnnotation(PermissionSucceed::class.java)
                if (succeedMethod != null) {
                    val methodCode = succeedMethod.requestCode
                    if (methodCode == requestCode) {
                        executeMethod(reflectObject, method)
                    }
                }
            }
        }

        fun executeFailMethod(reflectObject: Any, requestCode: Int) {
            val methods = reflectObject.javaClass.declaredMethods
            for (method in methods) {
                val failMethod = method.getAnnotation(PermissionFail::class.java)
                if (failMethod != null) {
                    val methodCode = failMethod.requestCode
                    if (methodCode == requestCode) {
                        executeMethod(reflectObject, method)
                    }
                }
            }
        }

        private fun executeMethod(reflectObject: Any, method: Method) {
            method.isAccessible = true
            try {
                method.invoke(reflectObject, *arrayOf())
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }

        }

        fun getDeniedPermissions(`object`: Any, requestPermissions: Array<String>): List<String> {
            val deniedPermissions = ArrayList<String>()
            for (requestPermission in requestPermissions) {
                // 将用户拒绝的权限添加集合
                if (ContextCompat.checkSelfPermission(
                        getActivity(`object`)!!,
                        requestPermission
                    ) == PackageManager.PERMISSION_DENIED
                ) {
                    deniedPermissions.add(requestPermission)
                }
            }
            return deniedPermissions
        }

        fun getActivity(mObject: Any): Activity? {
            if (mObject is Activity) {
                return mObject
            }
            return if (mObject is Fragment) {
                mObject.activity
            } else null
        }
    }
}
