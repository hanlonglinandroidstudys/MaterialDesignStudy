package hanlonglin.com.recyclerviewstudy.callback;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import hanlonglin.com.recyclerviewstudy.interfaces.ItemTouchMoveListener;

public class MyItemTouchCallback extends ItemTouchHelper.Callback {

    private static final String TAG = "MyItemTouchCallback";
    ItemTouchMoveListener onDragListener;

    public MyItemTouchCallback(ItemTouchMoveListener onDragListener) {
        this.onDragListener = onDragListener;
    }

    //用来回调监听时先调用的方法，用来判断是什么动作，比如判断方向，（意思就是我要监听哪个方向的拖动）
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //方向 up down left right

        //我要监听的拖拽的方向
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        //我要监听的滑动的方向  没有给0
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        //合并得到最终的flags结果
        int flags = makeMovementFlags(dragFlags, swipeFlags);

        return flags;
    }

//    @Override
//    public boolean isLongPressDragEnabled() {
//        return super.isLongPressDragEnabled();
//    }

    //当移动的时候调用的方法------拖拽
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType())
            return false;
        //在拖拽的过程中不断调用notify方法
        if (onDragListener != null)
            onDragListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    //侧滑的时候回调的
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (onDragListener != null)
            onDragListener.onItemRemove(viewHolder.getAdapterPosition());
        Log.e(TAG, "onSwiped: direction:" + direction);
    }

    //在拖拽或滑动时修改Holder背景颜色
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);

        switch (actionState) {
            case ItemTouchHelper.ACTION_STATE_DRAG:
                viewHolder.itemView.setBackgroundColor(Color.CYAN);
                break;
            case ItemTouchHelper.ACTION_STATE_SWIPE:
                viewHolder.itemView.setBackgroundColor(Color.GRAY);
                break;
        }
    }

    //状态恢复时
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(Color.WHITE);

        //删除条目出现空白bug解决方案一：
//        viewHolder.itemView.setAlpha(1);
//        viewHolder.itemView.setScaleX(1);
//        viewHolder.itemView.setScaleY(1);

    }

    @Override
    public void onChildDraw(Canvas c,
                            RecyclerView recyclerView,
                            RecyclerView.ViewHolder viewHolder,
                            float dX,
                            float dY,
                            int actionState,
                            boolean isCurrentlyActive) {

        //dX水平方向的移动的偏移量（负：往左 正：往右）
        float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            //透明度动画,随着左右滑动透明度 降低）

            /**
             * bug:设置了scaleX 和 scaleY后 ,出现下面的条目为空白的现象
             * 原因： listView和recyclerView都有复用现象，所以会出现上面的bug;
             * 解决：很多。比如在clearView回调方法里面去恢复这些条目的状态
             */
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setScaleX(alpha);
            viewHolder.itemView.setScaleY(alpha);

        }
        //删除条目出现空白bug解决方案二：
        if (alpha == 0) {
            viewHolder.itemView.setAlpha(1);
            viewHolder.itemView.setScaleX(1);
            viewHolder.itemView.setScaleY(1);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
