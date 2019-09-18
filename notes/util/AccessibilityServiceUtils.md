# 无障碍服务工具类AccessibilityServiceUtils.kt

## 适用场景
- 无障碍服务查找元素的常用方法封装

## 提供方法

|方法名|方法说明|
|:---|:---|
|findAndClickFirstOneByText|点击查找到的第一个元素，传入text和NodeInfo|
|findAndClickFirstOneById|点击查找到的第一个元素，传入id和NodeInfo|
|isExistElementByText|返回是否存在找到该元素，传入text和NodeInfo|
|isExistElementById|返回是否存在找到该元素，传入id和NodeInfo|
|getElementsByText|获取子节点元素，如果不存在返回null，传入text和NodeInfo|
|getElementsById|获取子节点元素，如果不存在返回null，传入id和NodeInfo|
