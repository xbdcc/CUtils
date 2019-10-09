package com.carlos.cutils.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.carlos.cutils.extend.singleClick

/**
 * Created by Carlos on 2019-05-27.
 */
class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test11)

        LogUtil.isShowLog = true
        val textView = findViewById<TextView>(R.id.textview)
        textView.singleClick(3000) { }
    }

//    @SingleClick
//    fun back(view: View) {
//        finish()
//        overridePendingTransition(R.anim.c_left_in, R.anim.c_left_in)
//    }

}
