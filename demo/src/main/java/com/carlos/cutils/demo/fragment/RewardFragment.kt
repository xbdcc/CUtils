package com.carlos.cutils.demo.fragment

import android.graphics.BitmapFactory
import android.os.Environment
import android.util.Log
import android.view.View
import com.carlos.cutils.demo.R
import com.carlos.cutils.demo.utils.BitmapUtils
import com.carlos.cutils.thirdparty.AlipayReward
import com.carlos.cutils.thirdparty.WechatReward
import com.carlos.cutils.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_reward.*
import java.io.File

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/2/23.
 */
class RewardFragment : BaseFragment(R.layout.fragment_reward) {

    override fun initView(view: View) {
        super.initView(view)
        b_alipay_reward.setOnClickListener {
            AlipayReward(view.context)
        }
        b_wechat_reward.setOnClickListener {
            WechatReward(view.context)
        }
        iv_alipay.setOnLongClickListener {
            val filedir = filedir
            val output = File(filedir, "xbd_alipay.jpg")
            if (!output.exists()) {
                val bitmap = BitmapFactory.decodeResource(resources, R.drawable.alipay)
                BitmapUtils.saveBitmap(view.context, output, bitmap)
            }
            ToastUtil.Builder(view.context).setLongToast().setText("已保存到:" + output.absolutePath).build()
            true
        }
        iv_wechat.setOnLongClickListener {
            val filedir = filedir
            val output = File(filedir, "xbd_wechat.jpg")
            if (!output.exists()) {
                val bitmap = BitmapFactory.decodeResource(resources, R.drawable.alipay)
                BitmapUtils.saveBitmap(view.context, output, bitmap)
            }
            ToastUtil.Builder(view.context).setLongToast().setText("已保存到:" + output.absolutePath).build()
            true
        }
    }

    /**
     * 得到安装路径
     * @return
     */
    internal val filedir: File
        get() {
            val sd = Environment.getExternalStorageDirectory()
            val path = sd.path + "/GrabRedEnvelope"
            val filedir = File(path)
            if (!filedir.exists()) {
                filedir.mkdir()
                Log.e("GrabRedEnvelope", "新建一个文件夹")
            }
            return filedir
        }

}