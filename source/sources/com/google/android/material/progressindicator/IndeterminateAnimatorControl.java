package com.google.android.material.progressindicator;

import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

interface IndeterminateAnimatorControl {
    void cancelMainAnimatorImmediately();

    void registerMainAnimatorCompleteEndCallback(Animatable2Compat.AnimationCallback animationCallback);

    void requestCancelMainAnimatorAfterCurrentCycle();

    void resetMainAnimatorPropertiesForEnd();

    void resetMainAnimatorPropertiesForNextCycle();

    void startMainAnimator();
}
