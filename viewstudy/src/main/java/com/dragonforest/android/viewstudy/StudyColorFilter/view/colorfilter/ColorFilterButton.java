package com.dragonforest.android.viewstudy.StudyColorFilter.view.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 颜色过滤器实现的一个按钮
 *
 * @author 韩龙林
 * @date 2019/7/10 19:43
 */
public class ColorFilterButton extends View {
    /**
     * 进度
     */
    private int degree = 0;

    private Paint mPaint;
    private Bitmap mBitmap;


    public ColorFilterButton(Context context) {
        super(context);
        init(context);
    }

    public ColorFilterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        Drawable background = getBackground();
        if (background instanceof BitmapDrawable) {
            mBitmap = ((BitmapDrawable) background).getBitmap();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap != null) {
            mPaint.setColorFilter(new LightingColorFilter(0xffffff, (int) degree));
            canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                degree = 0xff0000;
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                degree = 0x000000;
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
