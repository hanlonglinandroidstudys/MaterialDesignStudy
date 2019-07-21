package com.dayouzc.e2eplatform.screencompat.com.screen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.dayouzc.e2eplatform.screencompat.com.screen.util.UIUtil;

/**
 * @author 韩龙林
 * @date 2019/7/21 10:36
 */
public class CompatRelativeLayout extends RelativeLayout {

    /**
     * 是否被缩放过 防止重复缩放
     */
    boolean isScaled = false;

    public CompatRelativeLayout(Context context) {
        super(context);
    }

    public CompatRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isScaled) {
            float scaleX = UIUtil.getInstance(getContext()).getHorizatontalScaleValue();
            float scaleY = UIUtil.getInstance(getContext()).getVerticalScaleValue();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                layoutParams.width = (int) (layoutParams.width * scaleX);
                layoutParams.height = (int) (layoutParams.height * scaleY);
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * scaleX);
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * scaleX);
                layoutParams.topMargin = (int) (layoutParams.topMargin * scaleY);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * scaleY);
            }
            isScaled = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
