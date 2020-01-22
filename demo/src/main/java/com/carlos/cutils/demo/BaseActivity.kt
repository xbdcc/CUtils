package com.carlos.cutils.demo

import com.carlos.cutils.base.activity.CBaseActivity
import com.carlos.cutils.extend.defaultStartActivity

/**
 * Created by Carlos on 2019-12-17.
 */
open class BaseActivity : CBaseActivity() {

    fun startActivity(clazz: Class<*>) {
        defaultStartActivity(clazz)
    }

}