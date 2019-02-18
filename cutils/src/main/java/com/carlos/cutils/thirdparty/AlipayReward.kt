package com.carlos.cutils.thirdparty

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Carlos on 2019/2/15.
 */
class AlipayReward(
    context: Context,
    payUrl: String = "https://qr.alipay.com/tsx0624773cyneo7fzub5cf"
) {

    init {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data =
            Uri.parse("alipayqr://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=$payUrl")
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            intent.data = Uri.parse(payUrl)
            context.startActivity(intent)
        }
    }

}