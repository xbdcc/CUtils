# 统一管理结束Activity工具类ActivityCollectorUtils.kt

## 适用场景
- 在打开某个页面时按返回键需要同时退出前几个页面
- 全局退出应用

## 提供方法
可以写个父类Activity，需要统一管理的继承它，然后再父类Activity的onCreate方法加上addActivity，
onDestroy方法加上removeActivity

|方法名|使用方法|
|---|---:|
|addActivity|在Activity的onCreate方法里面添加|
|removeActivity|在Activity的onDestroy方法里面添加|
|finishAll|结束所有Activity|
