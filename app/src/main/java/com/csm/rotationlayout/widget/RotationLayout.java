package com.csm.rotationlayout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by csm on 2017/11/14.
 */

public class RotationLayout extends FrameLayout {

    private Context mContext;

    private int mHeight;
    private int mWidth;

    //旋转动画
    private ValueAnimator rotationValueAnimator;

    public RotationLayout(@NonNull Context context) {
        this(context, null);
    }

    public RotationLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotationLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    /**
     * 外部使用接口；传入起始角度和结束角度
     * @param startRotation 起始角度
     * @param endRotation 结束角度
     */
    public void setRotation(float startRotation, float endRotation) {
        if (null == rotationValueAnimator || !rotationValueAnimator.isRunning()){
            startAnimator(startRotation, endRotation);
        }
    }

    @Override
    public void setPivotX(float pivotX) {
        super.setPivotX(pivotX);
    }

    @Override
    public void setPivotY(float pivotY) {
        super.setPivotY(pivotY);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    /**
     * 开始动画；并对动画作初始化操作；
     * @param startRotation
     * @param endRotation
     */
    private void startAnimator(float startRotation, float endRotation){
        rotationValueAnimator = ValueAnimator.ofFloat(startRotation, endRotation);
        rotationValueAnimator.setDuration(500);
        rotationValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                RotationLayout.super.setRotation(value);

            }
        });
        rotationValueAnimator.start();
    }

    /**
     * 取消动画
     */
    private void stopAnimator(){
        if (null != rotationValueAnimator){
            rotationValueAnimator.cancel();
        }
    }
}
