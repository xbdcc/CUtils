package com.carlos.cutils.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.carlos.cutils.aop.CSingleClick
import com.carlos.cutils.base.activity.CBaseActivity
import com.carlos.cutils.extend.lastClickTime
import com.carlos.cutils.extend.singleClick
import com.carlos.cutils.util.LogUtils

/**
 * Created by Carlos on 2019-05-27.
 */
class AnimActivity : CBaseActivity() {

    private lateinit var albumUtils: AlbumUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test11)

        LogUtils.isShowLog = true
        albumUtils = AlbumUtils()

        val textView = findViewById<TextView>(R.id.textview)
        textView.singleClick(3000) {

        }
        textView.lastClickTime

//        textview.setOnClickListener(object : View.OnClickListener {
//            @CSingleClick
//            override fun onClick(v: View?) {
////                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

    }




    @CSingleClick
    fun back(view: View) {
//        finish()
        overridePendingTransition(R.anim.c_left_in, R.anim.c_left_in)
    }


}
