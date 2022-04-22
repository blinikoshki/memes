package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.C2727R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.math.MathUtils;

class LinearIndeterminateDrawable extends DrawableWithAnimatedVisibilityChange implements IndeterminateAnimatorControl {
    private static final Property<LinearIndeterminateDrawable, Float> LINE_1_HEAD_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "line1HeadFraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLine1HeadFraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLine1HeadFraction(f.floatValue());
        }
    };
    private static final Property<LinearIndeterminateDrawable, Float> LINE_1_TAIL_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "line1TailFraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLine1TailFraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLine1TailFraction(f.floatValue());
        }
    };
    private static final Property<LinearIndeterminateDrawable, Float> LINE_2_HEAD_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "line2HeadFraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLine2HeadFraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLine2HeadFraction(f.floatValue());
        }
    };
    private static final Property<LinearIndeterminateDrawable, Float> LINE_2_TAIL_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "line2TailFraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLine2TailFraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLine2TailFraction(f.floatValue());
        }
    };
    private static final Property<LinearIndeterminateDrawable, Float> LINE_CONNECT_POINT_1_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "lineConnectPoint1Fraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLineConnectPoint1Fraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLineConnectPoint1Fraction(f.floatValue());
        }
    };
    private static final Property<LinearIndeterminateDrawable, Float> LINE_CONNECT_POINT_2_FRACTION = new Property<LinearIndeterminateDrawable, Float>(Float.class, "lineConnectPoint2Fraction") {
        public Float get(LinearIndeterminateDrawable linearIndeterminateDrawable) {
            return Float.valueOf(linearIndeterminateDrawable.getLineConnectPoint2Fraction());
        }

        public void set(LinearIndeterminateDrawable linearIndeterminateDrawable, Float f) {
            linearIndeterminateDrawable.setLineConnectPoint2Fraction(f.floatValue());
        }
    };
    private static final long MAIN_LINE_1_HEAD_DURATION = 750;
    private static final long MAIN_LINE_1_TAIL_DELAY = 333;
    private static final long MAIN_LINE_1_TAIL_DURATION = 850;
    private static final long MAIN_LINE_2_HEAD_DELAY = 1000;
    private static final long MAIN_LINE_2_HEAD_DURATION = 567;
    private static final long MAIN_LINE_2_TAIL_DELAY = 1267;
    private static final long MAIN_LINE_2_TAIL_DURATION = 533;
    private static final long SEAMLESS_DURATION_PER_COLOR = 667;
    private static final long SEAMLESS_NEXT_COLOR_DELAY = 333;
    private final Context context;
    private final LinearDrawingDelegate drawingDelegate = new LinearDrawingDelegate();
    private int indicatorColorIndex;
    private float line1HeadFraction;
    private float line1TailFraction;
    private float line2HeadFraction;
    private float line2TailFraction;
    private float lineConnectPoint1Fraction;
    private float lineConnectPoint2Fraction;
    private Animator mainAnimator;
    Animatable2Compat.AnimationCallback mainAnimatorCompleteCallback = null;
    boolean mainAnimatorCompleteEndRequested = false;
    private Animator mainAnimatorSeamless;

    LinearIndeterminateDrawable(Context context2, ProgressIndicator progressIndicator) {
        super(progressIndicator);
        this.context = context2;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        initializeAnimators();
    }

    private void initializeAnimators() {
        initializeMainAnimatorSeamless();
        initializeMainAnimator();
        getHideAnimator().addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LinearIndeterminateDrawable.this.cancelMainAnimatorImmediately();
                LinearIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
            }
        });
        resetMainAnimatorPropertiesForEnd();
        setGrowFraction(1.0f);
        startMainAnimator();
    }

    private void initializeMainAnimatorSeamless() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LINE_CONNECT_POINT_1_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(SEAMLESS_DURATION_PER_COLOR);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                LinearIndeterminateDrawable.this.rotateIndicatorColor();
            }
        });
        Property<LinearIndeterminateDrawable, Float> property = LINE_CONNECT_POINT_2_FRACTION;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, property, new float[]{0.0f, 0.0f});
        ofFloat2.setDuration(333);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, property, new float[]{0.0f, 1.0f});
        ofFloat3.setDuration(SEAMLESS_DURATION_PER_COLOR);
        ofFloat3.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                LinearIndeterminateDrawable.this.rotateIndicatorColor();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat3});
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ofFloat, animatorSet});
        this.mainAnimatorSeamless = animatorSet2;
    }

    private void initializeMainAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LINE_1_HEAD_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(MAIN_LINE_1_HEAD_DURATION);
        ofFloat.setInterpolator(AnimationUtilsCompat.loadInterpolator(this.context, C2727R.C2728animator.linear_indeterminate_line1_head_interpolator));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, LINE_1_TAIL_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat2.setStartDelay(333);
        ofFloat2.setDuration(MAIN_LINE_1_TAIL_DURATION);
        ofFloat2.setInterpolator(AnimationUtilsCompat.loadInterpolator(this.context, C2727R.C2728animator.linear_indeterminate_line1_tail_interpolator));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, LINE_2_HEAD_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat3.setStartDelay(1000);
        ofFloat3.setDuration(MAIN_LINE_2_HEAD_DURATION);
        ofFloat3.setInterpolator(AnimationUtilsCompat.loadInterpolator(this.context, C2727R.C2728animator.linear_indeterminate_line2_head_interpolator));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, LINE_2_TAIL_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat4.setStartDelay(MAIN_LINE_2_TAIL_DELAY);
        ofFloat4.setDuration(MAIN_LINE_2_TAIL_DURATION);
        ofFloat4.setInterpolator(AnimationUtilsCompat.loadInterpolator(this.context, C2727R.C2728animator.linear_indeterminate_line2_tail_interpolator));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (LinearIndeterminateDrawable.this.mainAnimatorCompleteEndRequested) {
                    LinearIndeterminateDrawable.this.mainAnimatorCompleteCallback.onAnimationEnd(LinearIndeterminateDrawable.this);
                    LinearIndeterminateDrawable.this.mainAnimatorCompleteEndRequested = false;
                    LinearIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
                } else if (LinearIndeterminateDrawable.this.isVisible()) {
                    LinearIndeterminateDrawable.this.resetMainAnimatorPropertiesForNextCycle();
                    LinearIndeterminateDrawable.this.startMainAnimator();
                } else {
                    LinearIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
                }
            }
        });
        this.mainAnimator = animatorSet;
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.animatorsDisabledForTesting) {
            z2 = false;
        }
        boolean visible = super.setVisible(z, z2);
        if (!isRunning()) {
            cancelMainAnimatorImmediately();
            resetMainAnimatorPropertiesForEnd();
        }
        if (z && z2) {
            startMainAnimator();
        }
        return visible;
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.adjustCanvas(canvas, this.progressIndicator, getGrowFraction());
            float indicatorWidth = ((float) this.progressIndicator.getIndicatorWidth()) * getGrowFraction();
            if (this.progressIndicator.isLinearSeamless()) {
                float min = Math.min(getLineConnectPoint1Fraction(), getLineConnectPoint2Fraction());
                float max = Math.max(getLineConnectPoint1Fraction(), getLineConnectPoint2Fraction());
                int floorMod = MathUtils.floorMod(this.indicatorColorIndex + 2, this.combinedIndicatorColorArray.length);
                int floorMod2 = MathUtils.floorMod(this.indicatorColorIndex + 1, this.combinedIndicatorColorArray.length);
                float f = indicatorWidth;
                this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[floorMod], 0.0f, min, f);
                this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[floorMod2], min, max, f);
                this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[this.indicatorColorIndex], max, 1.0f, f);
                return;
            }
            float f2 = indicatorWidth;
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedTrackColor, 0.0f, 1.0f, f2);
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[this.indicatorColorIndex], getLine1TailFraction(), getLine1HeadFraction(), f2);
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[this.indicatorColorIndex], getLine2TailFraction(), getLine2HeadFraction(), f2);
        }
    }

    public void startMainAnimator() {
        if (this.progressIndicator.isLinearSeamless()) {
            this.mainAnimatorSeamless.start();
        } else {
            this.mainAnimator.start();
        }
    }

    public void resetMainAnimatorPropertiesForEnd() {
        resetMainAnimatorPropertiesForNextCycle();
        this.lineConnectPoint1Fraction = 0.0f;
        this.lineConnectPoint2Fraction = 0.0f;
        this.indicatorColorIndex = 0;
    }

    public void resetMainAnimatorPropertiesForNextCycle() {
        this.line1HeadFraction = 0.0f;
        this.line1TailFraction = 0.0f;
        this.line2HeadFraction = 0.0f;
        this.line2TailFraction = 0.0f;
    }

    public void cancelMainAnimatorImmediately() {
        this.mainAnimator.cancel();
        this.mainAnimatorSeamless.cancel();
    }

    public void requestCancelMainAnimatorAfterCurrentCycle() {
        if (!this.mainAnimatorCompleteEndRequested) {
            if (!isVisible()) {
                cancelMainAnimatorImmediately();
            } else if (!this.progressIndicator.isLinearSeamless()) {
                this.mainAnimatorCompleteEndRequested = true;
            }
        }
    }

    public void registerMainAnimatorCompleteEndCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.mainAnimatorCompleteCallback = animationCallback;
    }

    /* access modifiers changed from: private */
    public void rotateIndicatorColor() {
        this.indicatorColorIndex = (this.indicatorColorIndex + 1) % this.combinedIndicatorColorArray.length;
    }

    /* access modifiers changed from: private */
    public float getLine1HeadFraction() {
        return this.line1HeadFraction;
    }

    /* access modifiers changed from: package-private */
    public void setLine1HeadFraction(float f) {
        this.line1HeadFraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getLine1TailFraction() {
        return this.line1TailFraction;
    }

    /* access modifiers changed from: package-private */
    public void setLine1TailFraction(float f) {
        this.line1TailFraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getLine2HeadFraction() {
        return this.line2HeadFraction;
    }

    /* access modifiers changed from: package-private */
    public void setLine2HeadFraction(float f) {
        this.line2HeadFraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getLine2TailFraction() {
        return this.line2TailFraction;
    }

    /* access modifiers changed from: package-private */
    public void setLine2TailFraction(float f) {
        this.line2TailFraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getLineConnectPoint1Fraction() {
        return this.lineConnectPoint1Fraction;
    }

    /* access modifiers changed from: package-private */
    public void setLineConnectPoint1Fraction(float f) {
        this.lineConnectPoint1Fraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getLineConnectPoint2Fraction() {
        return this.lineConnectPoint2Fraction;
    }

    /* access modifiers changed from: package-private */
    public void setLineConnectPoint2Fraction(float f) {
        this.lineConnectPoint2Fraction = f;
        invalidateSelf();
    }
}
