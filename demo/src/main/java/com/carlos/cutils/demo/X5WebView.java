//package com.carlos.cutils.demo;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.AttributeSet;
//import android.view.View;
//
//import com.tencent.smtt.sdk.QbSdk;
//import com.tencent.smtt.sdk.WebSettings;
//import com.tencent.smtt.sdk.WebView;
//import com.tencent.smtt.sdk.WebViewClient;
//
///**
// * Created by Carlos on 2018/4/25.
// */
//public class X5WebView extends WebView{
//
//    private Context mContext;
//
//    public X5WebView(Context context, AttributeSet arg1) {
//        super(context, arg1);
//        mContext=context;
//        this.setWebViewClient(client);
//        initWebViewSettings();
//        this.getView().setClickable(true);
//    }
//
//    // 向webview发出信息
//    public void enableX5FullscreenFunc() {
//        if (getX5WebViewExtension() != null) {
////            Toast.makeText(mContext, "开启X5全屏播放模式", Toast.LENGTH_LONG).show();
////            Toast.makeText(this, "开启X5全屏播放模式", Toast.LENGTH_LONG).show();
//            Bundle data = new Bundle();
//            data.putBoolean("standardFullScreen", false);// true表示标准全屏，false表示X5全屏；不设置默认false，
//            data.putBoolean("supportLiteWnd", true);// false：关闭小窗；true：开启小窗；不设置默认true，
//            data.putInt("DefaultVideoScreen", 2);// 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
//            getX5WebViewExtension().invokeMiscMethod("setVideoParams",
//                    data);
//        }
//    }
//
//    private WebViewClient client = new WebViewClient() {
//        /**
//         * 防止加载网页时调起系统浏览器
//         */
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
////			view.loadUrl(url);
////			return true;
//            if (url.startsWith("http")) {
//                loadUrl(url);
//                return true;
//            } else {
//                return true;
//            }
//        }
//    };
//
//    private void initWebViewSettings() {
//        WebSettings webSetting = this.getSettings();
//        webSetting.setJavaScriptEnabled(true);
//        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSetting.setAllowFileAccess(true);
//        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webSetting.setSupportZoom(true);
//        webSetting.setBuiltInZoomControls(true);
//        webSetting.setUseWideViewPort(true);
//        webSetting.setSupportMultipleWindows(true);
//        // webSetting.setLoadWithOverviewMode(true);
//        webSetting.setAppCacheEnabled(true);
//        // webSetting.setDatabaseEnabled(true);
//        webSetting.setDomStorageEnabled(true);
//        webSetting.setGeolocationEnabled(true);
//        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
//        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
//        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
//        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
//
//        // this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
//        // settings 的设计
//    }
//
//    @Override
//    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
//        boolean ret = super.drawChild(canvas, child, drawingTime);
//        canvas.save();
//        Paint paint = new Paint();
//        paint.setColor(0x7fff0000);
//        paint.setTextSize(24.f);
//        paint.setAntiAlias(true);
//        if (getX5WebViewExtension() != null) {
//            canvas.drawText(this.getContext().getPackageName() + "-pid:"
//                    + android.os.Process.myPid(), 10, 50, paint);
//            canvas.drawText(
//                    "X5  Core:" + QbSdk.getTbsVersion(this.getContext()), 10,
//                    100, paint);
//        } else {
//            canvas.drawText(this.getContext().getPackageName() + "-pid:"
//                    + android.os.Process.myPid(), 10, 50, paint);
//            canvas.drawText("Sys Core", 10, 100, paint);
//        }
//        canvas.drawText(Build.MANUFACTURER, 10, 150, paint);
//        canvas.drawText(Build.MODEL, 10, 200, paint);
//        canvas.restore();
//        return ret;
//    }
//
//    public X5WebView(Context arg0) {
//        super(arg0);
//        setBackgroundColor(85621);
//    }
//}
