//package com.carlos.cutils.demo;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.content.res.Resources;
//import android.os.Build;
//import android.text.TextUtils;
//import android.util.DisplayMetrics;
//
//import java.util.Locale;
//
///**
// * Created by Carlos on 2019/1/24.
// */
//public class LanguageUtil {
//
//    public static final Locale LOCALE_SIMPLIFIED_CHINESE=Locale.SIMPLIFIED_CHINESE;
//    public static final Locale LOCALE_TRADITIONAL_CHINESE=Locale.TRADITIONAL_CHINESE;
//    public static final Locale LOCALE_ENGLISH=Locale.ENGLISH;
//    public static final Locale LOCALE_DEFAULT=Locale.getDefault();
//
//    public static void setLanguage2(Context context,Locale locale){
//        Resources resources=context.getResources();
//        DisplayMetrics displayMetrics=resources.getDisplayMetrics();
//        Configuration configuration=resources.getConfiguration();
//        configuration.locale=locale;
//        resources.updateConfiguration(configuration,displayMetrics);
//        context.createConfigurationContext(configuration);
//
//    }
//
//    public static void setLanguageRestart(Context context,Locale locale,Class activityClass){
//        setLanguage(context,locale);
////        restartActivity(context,activityClass);
//    }
//
//    public static void setLanguage(Context context,Locale locale){
//
//        Configuration configuration=context.getResources().getConfiguration();
//        Locale systemLocale;
//        //获取系统语言
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
//            systemLocale=getSystemLocale(configuration);
//        }else {
//            systemLocale=getSystemLocaleLegacy(configuration);
//        }
//
//        if (TextUtils.isEmpty(locale.getLanguage())||systemLocale.getLanguage().equals(locale.getLanguage()))
//            return;
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
//            setSystemLocale(configuration,locale);
//        }else {
//            setSystemLocaleLegacy(configuration,locale);
//        }
//
////        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
////            context.createConfigurationContext(configuration);
////        }else{
////            context.getResources().updateConfiguration(configuration,context.getResources().getDisplayMetrics());
////        }
//        context.getResources().updateConfiguration(configuration,context.getResources().getDisplayMetrics());
//
//    }
//
//    private static void restartActivity(Context context, Class activityClass){
//        Intent intent = new Intent(context, activityClass);
//        //开始新的activity同时移除之前所有的activity
////        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//    }
//
//    @SuppressWarnings("deprecation")
//    public static Locale getSystemLocaleLegacy(Configuration configuration){
//        return configuration.locale;
//    }
//
//    @TargetApi(Build.VERSION_CODES.N)
//    public static Locale getSystemLocale(Configuration configuration){
//        return configuration.getLocales().get(0);
//    }
//
//    @SuppressWarnings("deprecation")
//    public static void setSystemLocaleLegacy(Configuration configuration, Locale locale){
//        configuration.locale = locale;
//    }
//
//    @TargetApi(Build.VERSION_CODES.N)
//    public static void setSystemLocale(Configuration configuration, Locale locale){
//        configuration.setLocale(locale);
//    }
//}
