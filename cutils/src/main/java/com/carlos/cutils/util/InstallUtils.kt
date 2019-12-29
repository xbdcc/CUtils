package com.carlos.cutils.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import java.io.File

/**
 * Github: https://github.com/xbdcc/.
 * 安装APK工具类
 * Created by Carlos on 2018/11/14.
 */
object InstallUtils {

    fun install(context: Context, apkPath: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val downFile = File(apkPath)
        //版本在7.0以上特殊处理
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            val uri =
                FileProvider.getUriForFile(context, context.packageName + ".fileProvider", downFile)
            intent.setDataAndType(uri, "application/vnd.android.package-archive")
        } else {
            intent.setDataAndType(Uri.fromFile(downFile), "application/vnd.android.package-archive")
        }
        context.startActivity(intent)
    }

}