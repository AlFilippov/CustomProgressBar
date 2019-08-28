package com.alfilippov.customprogressbar.style;

import android.animation.ValueAnimator;
import android.os.Build;

import com.alfilippov.customprogressbar.animation.SpriteAnimationBuilder;
import com.alfilippov.customprogressbar.sprite.CircleLayoutContainer;
import com.alfilippov.customprogressbar.sprite.CircleSprite;
import com.alfilippov.customprogressbar.sprite.Sprite;

public class Circle extends CircleLayoutContainer {

    @Override
    public Sprite[] onCreateChild() {
        Dot[] dots = new Dot[12];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new Dot();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].setAnimationDelay(1200 / 12 * i);
            } else {
                dots[i].setAnimationDelay(1200/ 12 * i + -1200);
            }
        }
        return dots;
    }

    private class Dot extends CircleSprite {

        Dot() {
            setScale(0f);
        }

        @Override
        public ValueAnimator onCreateAnimation() {
            float fractions[] = new float[]{0f, 0.7f, 1f};
            return new SpriteAnimationBuilder(this).
                    scale(fractions, 0f, 1f, 0f).
                    duration(1200).
                    easeInOut(fractions)
                    .build();
        }
    }
}

