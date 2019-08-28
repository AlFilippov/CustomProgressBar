package com.alfilippov.customprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class DotsProgressBar extends View {

    private int mDotRadius = 6;
    private int mDotStep = 15;
    private int mBounceDotRadius = 7;
    private int mDotPosition;
    private int mDotAmount = 6;

    public DotsProgressBar(Context context) {
        super(context);
        initDotSize();
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isShown()) {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            createDots(canvas, paint);
        }

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        startAnimation();
    }

    private void createDots(Canvas canvas, Paint paint) {
        for (int i = 0; i < mDotAmount; i++) {
            int radius = (i == mDotPosition) ? mBounceDotRadius : mDotRadius;
            canvas.drawCircle(mDotStep / 2 + (i * mDotStep), mBounceDotRadius, radius, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        setMeasuredDimension(mDotStep * mDotAmount, mBounceDotRadius * 5);
    }

    private void initDotSize() {
        final float scale = getResources().getDisplayMetrics().density;
        mDotStep = (int) (mDotStep * scale);
        mDotRadius = (int) (mDotRadius * scale);
        mBounceDotRadius = (int) (mBounceDotRadius * scale);
    }


    private void startAnimation() {
        DotsBounceAnimation dotsBounceAnimation = new DotsBounceAnimation();
        dotsBounceAnimation.setDuration(100);
        dotsBounceAnimation.setRepeatCount(Animation.INFINITE);
        dotsBounceAnimation.setInterpolator(new LinearInterpolator());
        dotsBounceAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                mDotPosition++;
                if (mDotPosition == mDotAmount) {
                    mDotPosition = 0;
                }


            }
        });
        startAnimation(dotsBounceAnimation);
    }


    private class DotsBounceAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            invalidate();
        }
    }
}
