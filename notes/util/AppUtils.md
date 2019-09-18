# 获取App信息工具类AppUtils.kt

## 适用场景
- 统一上报用户信息，或者数据埋点。

## 提供方法

|方法名|方法说明|
|:---|:---|
|getAppVersionName|context必传，packageName如果不传则获取本应用的信息，如果传则获取包名对应的应用信息|
|getVersionCode|context必传，packageName如果不传则获取本应用的信息，如果传则获取包名对应的应用信息|
|getMetaData|context必传，获取Metadata信息|
