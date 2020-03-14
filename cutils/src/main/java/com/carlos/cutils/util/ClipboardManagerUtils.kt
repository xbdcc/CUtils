package com.carlos.cutils.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.carlos.cutils.CUtils

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-02-20.
 */
object ClipboardManagerUtils {

    @JvmStatic
    fun clipText(
        context: Context = CUtils.cContext,
        content: CharSequence,
        label: CharSequence = "label"
    ) {
        val clipboardManager =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(label, content)
        clipboardManager.primaryClip = clipData
    }

    @JvmStatic
    fun getClipText(context: Context = CUtils.cContext): CharSequence {
        val clipboardManager =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        // If the clipboardManager has no content.
        if (!clipboardManager.hasPrimaryClip())
            return ""
        val item = clipboardManager.primaryClip?.getItemAt(0)
        return if (item == null) "" else item.text
    }
}