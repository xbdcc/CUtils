package com.carlos.cutils.extend

import android.widget.TextView
import com.carlos.cutils.util.ClipboardManagerUtils


/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-02-20.
 */
fun <T : TextView> T.clipText() {
    ClipboardManagerUtils.clipText(this.context, this.text)
}

fun <T : TextView> T.setClipText() {
    val text = ClipboardManagerUtils.getClipText(this.context)
    this.text = text
}


//fun TextView.clipBoard(){
//    ClipboardManagerUtils.clipBoard(this.context, this.text)
//}