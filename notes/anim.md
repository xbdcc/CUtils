## 动画使用方法

### xml编写
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
### 代码使用
startActivity后调用
```
overridePendingTransition(R.anim.c_bottom_in, R.anim.c_bottom_out);
```
