package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import java.util.ArrayList;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final long GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") {
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.getGrowFraction());
        }

        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f) {
            drawableWithAnimatedVisibilityChange.setGrowFraction(f.floatValue());
        }
    };
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    boolean animatorsDisabledForTesting;
    int[] combinedIndicatorColorArray;
    int combinedTrackColor;
    private float growFraction;
    private ValueAnimator hideAnimator;
    final Paint paint = new Paint();
    final ProgressIndicator progressIndicator;
    private ValueAnimator showAnimator;
    private int totalAlpha;

    public int getOpacity() {
        return -3;
    }

    DrawableWithAnimatedVisibilityChange(ProgressIndicator progressIndicator2) {
        this.progressIndicator = progressIndicator2;
        setAlpha(255);
        initializeShowAnimator();
        initializeHideAnimator();
    }

    private void initializeShowAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
        this.showAnimator = ofFloat;
        ofFloat.setDuration(GROW_DURATION);
        this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setShowAnimator(this.showAnimator);
    }

    private void initializeHideAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
        this.hideAnimator = ofFloat;
        ofFloat.setDuration(GROW_DURATION);
        this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setHideAnimator(this.hideAnimator);
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        if (!this.animationCallbacks.contains(animationCallback)) {
            this.animationCallbacks.add(animationCallback);
        }
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.animationCallbacks.remove(animationCallback);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationStart() {
        for (Animatable2Compat.AnimationCallback onAnimationStart : this.animationCallbacks) {
            onAnimationStart.onAnimationStart(this);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        for (Animatable2Compat.AnimationCallback onAnimationEnd : this.animationCallbacks) {
            onAnimationEnd.onAnimationEnd(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void disableAnimatorsForTesting() {
        this.animatorsDisabledForTesting = true;
    }

    public void start() {
        setVisible(true, true);
    }

    public void stop() {
        setVisible(false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.hideAnimator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRunning() {
        /*
            r1 = this;
            android.animation.ValueAnimator r0 = r1.showAnimator
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.animation.ValueAnimator r0 = r1.hideAnimator
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.isRunning():boolean");
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (z && z2 && isVisible() && !this.hideAnimator.isRunning()) {
            return false;
        }
        if (!z && z2 && !isVisible()) {
            return false;
        }
        boolean z3 = (!z && z2) || super.setVisible(z, false);
        boolean z4 = z2 && this.progressIndicator.getGrowMode() != 0;
        if (this.showAnimator.isRunning() || this.hideAnimator.isRunning()) {
            return false;
        }
        this.showAnimator.cancel();
        this.hideAnimator.cancel();
        if (z) {
            if (z4) {
                resetToShow();
                this.showAnimator.start();
                return true;
            }
            resetToHide();
        } else if (z4) {
            resetToHide();
            this.hideAnimator.start();
            return true;
        } else {
            resetToShow();
        }
        return z3;
    }

    private void resetToShow() {
        this.growFraction = 0.0f;
    }

    private void resetToHide() {
        this.growFraction = 1.0f;
    }

    /* access modifiers changed from: package-private */
    public void recalculateColors() {
        this.combinedTrackColor = MaterialColors.compositeARGBWithAlpha(this.progressIndicator.getTrackColor(), getAlpha());
        this.combinedIndicatorColorArray = (int[]) this.progressIndicator.getIndicatorColors().clone();
        int i = 0;
        while (true) {
            int[] iArr = this.combinedIndicatorColorArray;
            if (i < iArr.length) {
                iArr[i] = MaterialColors.compositeARGBWithAlpha(iArr[i], getAlpha());
                i++;
            } else {
                return;
            }
        }
    }

    public void setAlpha(int i) {
        this.totalAlpha = i;
        recalculateColors();
        invalidateSelf();
    }

    public int getAlpha() {
        return this.totalAlpha;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    private void setShowAnimator(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.showAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.showAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationStart();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    /* access modifiers changed from: package-private */
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    private void setHideAnimator(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.hideAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.hideAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationEnd();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    /* access modifiers changed from: package-private */
    public float getGrowFraction() {
        return this.growFraction;
    }

    /* access modifiers changed from: package-private */
    public void setGrowFraction(float f) {
        if (this.progressIndicator.getGrowMode() == 0) {
            f = 1.0f;
        }
        if (this.growFraction != f) {
            this.growFraction = f;
            invalidateSelf();
        }
    }
}
