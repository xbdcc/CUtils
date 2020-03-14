# CUtils

[![api](https://img.shields.io/badge/API-19+-brightgreen.svg)](https://android-arsenal.com/api?level=19)
[![Build Status](https://travis-ci.org/xbdcc/CUtils.svg?branch=master)](https://travis-ci.org/xbdcc/CUtils)
[![bintray](https://api.bintray.com/packages/xbdcc/maven/cutils/images/download.svg)](https://bintray.com/xbdcc/maven/cutils/_latestVersion)
<!--哈哈我是注释，不会在浏览器中显示。-->
<!--
[![jitpack](https://jitpack.io/v/xbdcc/cutils.svg)](https://jitpack.io/#xbdcc/cutils)
![bintray](https://api.bintray.com/packages/xbdcc/maven/cutils/images/download.svg)
-->


## How to use
- config this to your `build.gralde`
- Add the following dependency to your `build.gradle` file.
```
    implementation 'com.carlos.cutils:cutils:0.0.28'
```
- Add this code to your `application` file
```
    CUtils.init(this)
```


## Table of Contents

- [设备信息获取工具类](notes/util/DeviceUtils.md) -> [DeviceUtils.kt][DeviceUtils.kt]
- [App信息获取工具类](notes/util/AppUtils.md) -> [AppUtils.kt][AppUtils.kt]
- [统一管理Activity工具类](notes/util/ActivityCollectorUtils.md) -> [ActivityCollectorUtils.kt][ActivityCollectorUtils.kt]
- [打印日志工具类](notes/util/ActivityCollectorUtils.md) -> [LogUtils.kt][LogUtils.kt]
- [无障碍服务工具类](notes/util/AccessibilityServiceUtils.md) -> [AccessibilityServiceUtils.kt][AccessibilityServiceUtils.kt]
- [Kotlin中View扩展工具类](notes/util/ViewExtend.md) -> [ViewExtend.kt][ViewExtend.kt]
- [AOP注解防重复点击工具类](notes/util/CSingleClick.md) -> [CSingleClick.kt][CSingleClick.kt]
- [全局捕获未捕获异常类](notes/execption/CUncaughtExceptionHandler.md) ->  [CUncaughtExceptionHandler.kt][CUncaughtExceptionHandler.kt]

[DeviceUtils.kt]: cutils/src/main/java/com/carlos/cutils/util/DeviceUtils.kt
[AppUtils.kt]: cutils/src/main/java/com/carlos/cutils/util/AppUtils.kt
[ActivityCollectorUtils.kt]: cutils/src/main/java/com/carlos/cutils/util/ActivityCollectorUtils.kt
[LogUtils.kt]: cutils/src/main/java/com/carlos/cutils/util/LogUtils.kt
[AccessibilityServiceUtils.kt]: cutils/src/main/java/com/carlos/cutils/util/AccessibilityServiceUtils.kt
[ViewExtend.kt]: cutils/src/main/java/com/carlos/cutils/extend/ViewExtend.kt
[CSingleClick.kt]: cutils/src/main/java/com/carlos/cutils/aop
[CUncaughtExceptionHandler.kt]: cutils/src/main/java/com/carlos/cutils/execption

## [Change Log](CHANGELOG.md)