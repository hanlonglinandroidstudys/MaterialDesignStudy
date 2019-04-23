package hanlonglin.com.recyclerviewstudy.interfaces;

import android.support.v7.widget.RecyclerView;

public interface StartDragListener {
    /**
     * 该接口用于监听需要主动调用拖拽方法的
     * @param holder
     */
    public void onStartDrager(RecyclerView.ViewHolder holder);
}
