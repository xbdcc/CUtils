package com.carlos.cutils.demo

import android.Manifest
import android.os.Bundle
import android.view.View
import com.carlos.cutils.activity.CBaseActivity
import com.carlos.cutils.listener.PermissionListener
import com.carlos.cutils.util.LogUtils
import com.carlos.cutils.util.ToastUtil


class MainActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()

    }

    fun click(view: View) {

        showToast("test")
        requestPermission()

        if (!isHasPermission()) {
            showToast("Please get permission first!")
            return
        }

    }

    private fun showToast(text: String) {
        ToastUtil.Builder(this@MainActivity).setText(text).build()
    }

    private fun isHasPermission() =
        isHasPermission(Manifest.permission.RECORD_AUDIO) && isHasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    private fun requestPermission() {
        requestPermission(300, object : PermissionListener {
            override fun permissionSuccess() {
                LogUtils.d("permission get success"); }

            override fun permissionFail() {

            }

        }, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }
}
