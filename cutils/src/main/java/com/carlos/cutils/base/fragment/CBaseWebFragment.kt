package com.carlos.cutils.base.fragment

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.carlos.cutils.R

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020-01-21.
 */
abstract class CBaseWebFragment(val url: String, var isCache: Boolean = true) : CBaseFragment() {

    lateinit var webView: WebView

    override fun initView(view: View) {
        initWebView(view.findViewById(R.id.webview))
        webView.setProgressBar(view.findViewById(R.id.progressBar))
        webView.loadUrl(url)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_webview
    }

    fun initSettings(webView: WebView) {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)//是否可以缩放，默认false
        webSettings.builtInZoomControls = false//是否显示缩放按钮，默认false
        webSettings.useWideViewPort = true//大视图模式
        webSettings.setAppCacheEnabled(isCache)//是否使用缓存
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true //是否自适应屏幕
    }

    open fun initWebView(webView: WebView, isInitSetting: Boolean = true) : WebView {
        this.webView = webView
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
                if(newProgress == 100) {
                    if (isFinishedGone)
                        progressBar.visibility = View.GONE
                    else
                        progressBar.visibility = View.INVISIBLE
                }else {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
            }
        }
    }

}