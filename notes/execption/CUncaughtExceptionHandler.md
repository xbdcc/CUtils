# 全局捕获未捕获的异常类CUncaughtExceptionHandler.kt

## 适用场景
- 捕获未捕获的异常，做上报异常或APP异常处理操作。

## 提供方法
在Application里面全局注册 
```
  Thread.setDefaultUncaughtExceptionHandler(CUncaughtExceptionHandler())
```

|方法名|方法说明|
|:---|:---|
|uncaughtException|默认内部做了退出APP操作，可重载该方法实现自己的逻辑|
