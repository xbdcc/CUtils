package com.carlos.cutils.base

import android.annotation.TargetApi
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by Carlos on 2019/3/20.
 */
open class CBaseWebViewActivity : CBaseActivity() {

    fun initSettings(webView: WebView) {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)//是否可以缩放，默认false
        webSettings.builtInZoomControls = false//是否显示缩放按钮，默认false
        webSettings.useWideViewPort = true//大视图模式
        webSettings.setAppCacheEnabled(true)//是否使用缓存
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true //是否自适应屏幕
    }

    fun initWebView(webView: WebView) {
        webView.webViewClient = object : WebViewClient() {

            @SuppressWarnings("deprecation")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    if (url.startsWith("http")) {
                        webView.loadUrl(url)
                    }
                }
                return true
            }

            @TargetApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (request != null) {
                    val url = request.url.toString()
                    if (url.startsWith("http")) {
                        webView.loadUrl(url)
                    }
                }
                return true
            }
        }
    }

}