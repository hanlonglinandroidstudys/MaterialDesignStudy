# RecyclerView 学习

## 知识点：
* 1.添加装饰器（添加线性和网格分割线）
* * 实现方式：具体见下面类：
>> DividerItemDecoration 线性分割线

>> GridDividerItemDecoration 网格分割线

>>  ItemDecorationAc 测试Activity

* 2.添加头部和尾部：
* * 实现方式：参考ListView的 addHeaderView 和 addFooterView ，使用中间代理模式；

>>WrapRecyclerView 封装的支持添加头部和尾部的RecyclerView

>>AddHeaderAc 测试Activity

* 3.实现交互动画效果（拖拽和侧滑）
* * 实现方式： 借助ItemTouchHelper,重写callback; 实现效果： RecyclerView的拖拽和侧滑；

>>QQSlideAc 测试Actiivty ,实现侧滑删除和拖拽

>>QQSlideAc 测试Activity ,实现侧滑停留和拖拽
