package com.carlos.cutils.demo

import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(12000)
        setContentView(R.layout.activity_main)

        val list = listOf<String>(
            "WebView",
            "捐赠"
        )

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listview.adapter = adapter
        listview.setOnItemClickListener { parent, view, position, id ->
            when(position) {
                0 -> startActivity(WebviewActivity::class.java)
                1 -> {
//                    throw NullPointerException("exception hh")
//                    startActivity(RewardActivity::class.java)
                }
            }
        }
    }


}
