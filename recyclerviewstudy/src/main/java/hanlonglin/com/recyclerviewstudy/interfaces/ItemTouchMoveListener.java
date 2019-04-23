package hanlonglin.com.recyclerviewstudy.interfaces;

import android.support.v7.widget.RecyclerView;

public interface ItemTouchMoveListener {

    /**
     * 当拖拽的时候调用
     * 可以在此方法里实现 拖拽条目并实现更新效果
     * @param from 从什么角度
     * @param to   到什么角度
     * @return     是否回调成功
     */
    boolean onItemMove(int from, int to);

    boolean onItemRemove(int pos);
}
