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

    public void setRotation(float startRotation, float endRotation) {
        if (null != rotationValueAnimator && rotationValueAnimator.isRunning()){

        }else {
            startAnimator(startRotation, endRotation);
        }
    }

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

    private void stopAnimator(){
        if (null != rotationValueAnimator){
            rotationValueAnimator.cancel();
        }
    }
}
