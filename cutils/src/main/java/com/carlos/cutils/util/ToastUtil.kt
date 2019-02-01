package com.carlos.cutils.util

import android.content.Context
import android.widget.Toast

/**
 * Created by Carlos on 2018/2/27.
 */

class ToastUtil private constructor() {

    private lateinit var mToast: Toast
    private lateinit var mContext: Context
    private var message = ""
    private var duration: Int = 0


    class Builder(context: Context) {
        private var mToastUtil = ToastUtil()

        init {
            mToastUtil.mContext = context
        }

        fun setText(message: String): Builder {
            mToastUtil.message = message
            return this
        }

        fun setShortToast(): Builder {
            mToastUtil.duration = Toast.LENGTH_SHORT
            return this
        }

        fun setLongToast(): Builder {
            mToastUtil.duration = Toast.LENGTH_LONG
            return this
        }

        fun build(): ToastUtil {
            mToastUtil.setLayoutView()
            return mToastUtil
        }

    }

    fun setLayoutView() {
        mToast = Toast.makeText(mContext, message, duration)
        mToast.show()
    }


}
