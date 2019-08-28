package com.alfilippov.customprogressbar.animation.interpolator;

import android.view.animation.Interpolator;

import androidx.core.view.animation.PathInterpolatorCompat;

public class Ease {
    public static Interpolator inOut() {
        return PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f);
    }
}