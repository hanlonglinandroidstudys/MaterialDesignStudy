# 屏幕适配解决方案
* 核心思想：
* * 使用UIUtil计算缩放比，在需要适配的控件测量时进行缩放

* * UIUtil:
    * 1.获取当前屏幕像素，获取标准像素
    * 2.高度上减去系统状态栏的高度
    * 3.计算横向和纵向的缩放比例

* * CompatRelativeLayout
    * 测量时通过缩放比重新测量子控件
    * 注意重复测量时不要重复乘以缩放比