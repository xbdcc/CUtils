package com.carlos.cutils.demo

import android.os.Bundle
import android.webkit.WebView
import com.carlos.cutils.base.CBaseWebViewActivity

/**
 * Created by Carlos on 2019/3/20.
 */
class WebviewActivity : CBaseWebViewActivity() {

    private val url = "http://www.baidu.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

        initSettings(webView)

        initWebView(webView)

        webView.loadUrl(url)

    }

}