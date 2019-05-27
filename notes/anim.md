## 动画使用方法

## 适用场景
- Activity的进出动画
- View或Dialog的显示隐藏动画

## 提供资源
|方法名|使用方法|
|---|---:|
|c_bottom_in|底部弹入|
|c_bottom_out|底部弹出|
|c_left_in|左边弹入|
|c_left_out|左边弹出|

## 实现方法
1. xml编写

如要实现页面进入时从左到右滑动，在res下新建anim文件夹，新建c_bottom_in.xml如下:
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="300"
        android:fromXDelta="-100.0%p"
        android:toXDelta="0.0"/>
</set>
```
同理可以写退出时从右往左滑动。

2. 使用
- 代码使用

startActivity后调用,Activity调用finish方法后调用
```
overridePendingTransition(R.anim.c_bottom_in, R.anim.c_bottom_out);
```
- 主题引用

style.xml中新写一个style如下
```
    <style name="AnimFade" parent="@android:style/Animation.Activity"> 
        <item name="android:windowEnterAnimation">@anim/open_activity</item>
        <item name="android:windowExitAnimation">@anim/quit_activity</item>

        <item name="android:activityOpenEnterAnimation">@null</item>
        <item name="android:activityOpenExitAnimation">@null</item>
        <item name="android:activityCloseEnterAnimation">@null</item>
        <item name="android:activityCloseExitAnimation">@null</item>
    </style>
```
在你Activity引用到的theme里面加入window风格
```
        <item name="android:windowAnimationStyle">@style/AnimFade</item>
```
