package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewConfiguration;

final class AnimationUtils {
    private AnimationUtils() {
        throw new AssertionError();
    }

    static void animateVisibility(final View view) {
        boolean z = view.getVisibility() == 0;
        float f = 1.0f;
        float f2 = z ? 1.0f : 0.0f;
        if (z) {
            f = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{f2, f});
        ofFloat.setDuration((long) ViewConfiguration.getDoubleTapTimeout());
        if (z) {
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                }
            });
        } else {
            view.setVisibility(0);
        }
        ofFloat.start();
    }
}
