package com.carlos.cutils.base.activity

import android.annotation.TargetApi
import android.os.Build
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2019/3/20.
 */
open class CBaseWebViewActivity : CBaseActivity() {

    lateinit var webView: WebView
    var backToLast: Boolean = false

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

    open fun initWebView(
        webView: WebView,
        isInitSetting: Boolean = true,
        backToLast: Boolean = false
    ): WebView {
        this.webView = webView
        this.backToLast = backToLast
        if (isInitSetting) initSettings(webView)
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
        return webView
    }

    fun WebView.setProgressBar(progressBar: ProgressBar, isFinishedGone: Boolean = false) {
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    if (isFinishedGone)
                        progressBar.visibility = View.GONE
                    else
                        progressBar.visibility = View.INVISIBLE
                } else {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
            }
        }
    }

    /**
     * 返回键动作
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this::webView.isInitialized) {
            if (webView.canGoBack() and backToLast) {
                webView.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.removeAllViews()
        webView.destroy()
    }
}