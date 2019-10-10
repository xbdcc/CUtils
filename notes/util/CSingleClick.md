# 防重复点击工具类CSingleClick.kt

App的build.gradle中加入
```
apply plugin: 'android-aspectjx'
```

## 适用场景
- 控制重复点击间隔时间。

## 提供方法

|方法名|方法说明|
|:---|:---|
|CSingleClick|需要控制重复点击的方法上面加上注解，传参value间隔时间，不传则默认间隔100毫秒|
