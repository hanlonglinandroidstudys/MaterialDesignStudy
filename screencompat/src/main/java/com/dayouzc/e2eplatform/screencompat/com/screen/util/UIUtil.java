package com.dayouzc.e2eplatform.screencompat.com.screen.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * 屏幕适配的工具类
 *
 * @author 韩龙林
 * @date 2019/7/19 18:44
 */
public class UIUtil {

    /**
     * 用于得到状态栏的宽度
     */
    private static final String DIMEN_CLASS = "com.android.internal.R$dimen";
    /**
     * 状态栏高度属性id
     */
    private static final String SYSTEM_BAR_HEIGHT_FIELD = "system_bar_height";

    Context mContext;
    // 实际设备信息 例如 1080 * 1920
    private float displayMetricsWidth;
    private float displayMetricsHeight;

    //单例
    private static UIUtil instance;

    public static UIUtil getInstance(Context context) {
        if (instance == null) {
            instance = new UIUtil(context);
        }
        return instance;
    }

    private UIUtil(Context context) {
        this.mContext = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.displayMetricsHeight == 0.0f || this.displayMetricsWidth == 0.0f) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int systemBarHeight = getSystemBarHeight(context);
            // 考虑横竖屏的问题
            if(displayMetrics.widthPixels>displayMetrics.heightPixels){
                // 横屏
            }else{
                // 竖屏
            }
        }
    }

    /**
     * 获取系统状态栏的高度
     *
     * @return
     */
    private int getSystemBarHeight(Context context){
        try {
            Class<?> dimenClass = Class.forName(DIMEN_CLASS);
            Object object = dimenClass.newInstance();
            Field field = dimenClass.getField(SYSTEM_BAR_HEIGHT_FIELD);
            int id = Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
