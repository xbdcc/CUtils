package com.carlos.cutils.demo

import android.Manifest
import android.os.Bundle
import android.view.View
import com.carlos.cutils.base.activity.CBaseActivity
import com.carlos.cutils.listener.PermissionListener
import com.carlos.cutils.thirdparty.AlipayReward
import com.carlos.cutils.thirdparty.WechatReward
import com.carlos.cutils.util.LogUtils
import com.carlos.cutils.util.ToastUtil

/**
 * Created by Carlos on 2019-12-17.
 */
class RewardActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

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

    fun alipayReward(view: View) {
        AlipayReward(this)
    }

    fun wechatReward(view: View) {
        WechatReward(this)
    }

    private fun showToast(text: String) {
        ToastUtil.Builder(this@RewardActivity).setText(text).build()
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