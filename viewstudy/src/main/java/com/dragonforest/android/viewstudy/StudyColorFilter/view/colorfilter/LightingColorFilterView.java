package com.dragonforest.android.viewstudy.StudyColorFilter.view.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.dragonforest.android.viewstudy.R;

/**
 * 颜色过滤器的使用之 光照颜色过滤器
 *
 * @author 韩龙林
 * @date 2019/7/8 10:42
 */
public class LightingColorFilterView extends View {

    /**
     * 画笔
     */
    Paint mPaint;

    /**
     * 图像
     */
    Bitmap mBitmap;

    public LightingColorFilterView(Context context) {
        super(context);
        init(context);
    }

    public LightingColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.YELLOW);

        mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.bingbing);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画原图
        mPaint.setColorFilter(null);
        canvas.drawBitmap(mBitmap,null,new Rect(0,0,400,400),mPaint);
        // 光照过滤器
        /*
         * @param mul 相乘......缩放
         * @param add 相加......平移
         */
        LightingColorFilter lightingColorFilter=new LightingColorFilter(0x00ff00,0x001000);

        mPaint.setColorFilter(lightingColorFilter);
        canvas.drawBitmap(mBitmap,null,new Rect(400,0,800,400),mPaint);
    }
}
