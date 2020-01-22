package com.carlos.cutils.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.carlos.cutils.base.activity.CBaseWebViewActivity
import kotlinx.android.synthetic.main.activity_web.*
import java.util.*

/**
 * Created by Carlos on 2019/3/20.
 */
class WebviewActivity : CBaseWebViewActivity() {

    private val url = "https://www.jianshu.com/p/e1099a94b979"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        Log.d("xbd2", Date().toString())
        initWebView(webview).setProgressBar(progressBar)

        webview.loadUrl(url)


        button.setOnClickListener {
            webview.loadUrl(url)
        }

    }

}