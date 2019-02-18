package com.carlos.cutils.thirdparty

import android.content.Context
import android.content.Intent
import com.carlos.cutils.util.LogUtils

/**
 * Created by Carlos on 2019/2/15.
 * 跳转到微信扫码
 */
class WechatReward(
    context: Context
) {
    init {
        val intent = Intent("com.tencent.mm.action.BIZSHORTCUT")
        intent.setPackage("com.tencent.mm")
        intent.putExtra("LauncherUI.From.Scaner.Shortcut", true)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        )

        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            LogUtils.d("未安装微信")
        }
    }
}