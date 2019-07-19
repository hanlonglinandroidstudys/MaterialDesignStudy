package com.dragonforest.android.viewstudy.StudyColorFilter.view.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.dragonforest.android.viewstudy.R;

/**
 * 颜色过滤器的使用之 颜色矩阵过滤器
 *
 * @author 韩龙林
 * @date 2019/7/8 10:42
 */
public class ColorMatrixColorFilterView extends View {

    /**
     * 画笔
     */
    Paint mPaint;

    /**
     * 图像
     */
    Bitmap mBitmap;

    public ColorMatrixColorFilterView(Context context) {
        super(context);
        init(context);
    }

    public ColorMatrixColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.YELLOW);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bingbing);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        // 画原图
        mPaint.setColorFilter(null);
        canvas.drawBitmap(mBitmap, null, new Rect(0, 0, 400, 400), mPaint);
        // 保持原图色彩的矩阵
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                1,0,0,0,0,
//                0,1,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });

        // 过滤掉红色
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                0,0,0,0,0,
//                0,1,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
        // 颜色缩放
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                1.2f,0,0,0,0,
//                0,1.2f,0,0,0,
//                0,0,1.2f,0,0,
//                0,0,0,1.2f,0
//        });
        // 色彩平移 假发 20
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                1,0,0,0,20,
//                0,1,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
        // 红色和绿色交换
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                0,1,0,0,0,
//                1,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0
//        });
        // 反相
        /*
         * 反相就是255-原来的颜色值之后的结果
         */
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                -1,0,0,0,255,
//                0,-1,0,0,255,
//                0,0,-1,0,255,
//                0,0,0,1,0
//        });
        // 灰色图片  图片变为黑白
        /*
         * 去色原理:
         * 只要把RGB三通道的色彩信息设置成一样，即 R=G=B, 那么图像就变成了灰色;
         * 并且，为了保证图片亮度不变，同一个通道中的 R+G+B=1;
         * 如0.213+0.751+0.072=1; R,G,B=0.213,0.751,0.072
         * 三个数字是通过色彩光波频率及色彩心理学计算出来的。
         * 只要遵循这个规则就可以，下面两个都可以
         */
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                0.33f,0.33f,0.34f,0,0,
//                0.33f,0.33f,0.34f,0,0,
//                0.33f,0.34f,0.33f,0,0,
//                0,0,0,1,0
//        });
      /*  ColorMatrix colorMatrix=new ColorMatrix(new float[]{
                0.213f,0.751f,0.072f,0,0,
                0.213f,0.751f,0.072f,0,0,
                0.213f,0.751f,0.072f,0,0,
                0,0,0,1,0
        });*/

        // ================其他函数=====================

        ColorMatrix colorMatrix = new ColorMatrix();

        // 设置colorMatrix的值颜色缩放
//        colorMatrix.setScale(1.2f,1,1,1);

        // 设置饱和度
        /*
         * 范围：0-1  0表示灰色  1是原来颜色 >1 增加饱和度
         */
        colorMatrix.setSaturation(3);

        // 色彩旋转
        /*
         * @param axis   代表绕哪一个轴旋转 0,1,2    0红色 1绿色 2蓝色
         * @param degree 旋转角度
         *
         */
        colorMatrix.setRotate(1, 10);

        // ================其他函数-end=====================

        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap, null, new Rect(400, 0, 800, 400), mPaint);
    }
}
