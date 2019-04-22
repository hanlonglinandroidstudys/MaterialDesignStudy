package hanlonglin.com.materialdesignstudy.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };
    private int cols = 1;

    public GridDividerItemDecoration(Context context, int cols) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
        this.cols = cols;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        drawHorientation(c, parent);
        drawVertical(c, parent);
    }

    private void drawHorientation(Canvas c, RecyclerView parent) {
        //绘制水平间隔线
        int childCount = parent.getChildCount();
        int rows = (int)Math.ceil((double)childCount/(double)cols);
        for (int i = 0; i < childCount; i++) {

            //如果是最后一行 不绘制
            int currentRow=(int)Math.ceil((double)(i+1)/(double)cols);
            if(currentRow==rows) continue;

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getLeft()-params.leftMargin;
            int right = child.getRight()+params.rightMargin;
            int top = child.getBottom() + params.bottomMargin ;//+ Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        //绘制垂直间隔线
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            //如果是最右边 不绘制
            if((i+1)%cols==0)
                continue;

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;// + Math.round(ViewCompat.getTranslationX(child));
            int right = left + mDivider.getIntrinsicWidth();
            int top = child.getTop()-params.topMargin;
            int bottom = child.getBottom()+params.bottomMargin;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        //四个方向的偏移值
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();

        outRect.set(0, 0, right, bottom);
    }
}
