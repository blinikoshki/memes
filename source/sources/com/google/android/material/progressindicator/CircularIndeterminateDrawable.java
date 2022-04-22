package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.math.MathUtils;

class CircularIndeterminateDrawable extends DrawableWithAnimatedVisibilityChange implements IndeterminateAnimatorControl {
    private static final long COLOR_FADING_DELAY = 1000;
    private static final long COLOR_FADING_DURATION = 333;
    private static final Property<CircularIndeterminateDrawable, Integer> DISPLAYED_INDICATOR_COLOR = new Property<CircularIndeterminateDrawable, Integer>(Integer.class, "displayedIndicatorColor") {
        public Integer get(CircularIndeterminateDrawable circularIndeterminateDrawable) {
            return Integer.valueOf(circularIndeterminateDrawable.getDisplayedIndicatorColor());
        }

        public void set(CircularIndeterminateDrawable circularIndeterminateDrawable, Integer num) {
            circularIndeterminateDrawable.setDisplayedIndicatorColor(num.intValue());
        }
    };
    private static final long DURATION_PER_COLOR_IN_MS = 1333;
    private static final float INDICATOR_DELTA_DEGREES = 250.0f;
    private static final Property<CircularIndeterminateDrawable, Float> INDICATOR_HEAD_CHANGE_FRACTION = new Property<CircularIndeterminateDrawable, Float>(Float.class, "indicatorHeadChangeFraction") {
        public Float get(CircularIndeterminateDrawable circularIndeterminateDrawable) {
            return Float.valueOf(circularIndeterminateDrawable.getIndicatorHeadChangeFraction());
        }

        public void set(CircularIndeterminateDrawable circularIndeterminateDrawable, Float f) {
            circularIndeterminateDrawable.setIndicatorHeadChangeFraction(f.floatValue());
        }
    };
    private static final Property<CircularIndeterminateDrawable, Float> INDICATOR_IN_CYCLE_OFFSET = new Property<CircularIndeterminateDrawable, Float>(Float.class, "indicatorInCycleOffset") {
        public Float get(CircularIndeterminateDrawable circularIndeterminateDrawable) {
            return Float.valueOf(circularIndeterminateDrawable.getIndicatorInCycleOffset());
        }

        public void set(CircularIndeterminateDrawable circularIndeterminateDrawable, Float f) {
            circularIndeterminateDrawable.setIndicatorInCycleOffset(f.floatValue());
        }
    };
    private static final float INDICATOR_MAX_DEGREES = 270.0f;
    private static final float INDICATOR_MIN_DEGREES = 20.0f;
    private static final float INDICATOR_OFFSET_PER_COLOR_DEGREES = 360.0f;
    private static final Property<CircularIndeterminateDrawable, Float> INDICATOR_TAIL_CHANGE_FRACTION = new Property<CircularIndeterminateDrawable, Float>(Float.class, "indicatorTailChangeFraction") {
        public Float get(CircularIndeterminateDrawable circularIndeterminateDrawable) {
            return Float.valueOf(circularIndeterminateDrawable.getIndicatorTailChangeFraction());
        }

        public void set(CircularIndeterminateDrawable circularIndeterminateDrawable, Float f) {
            circularIndeterminateDrawable.setIndicatorTailChangeFraction(f.floatValue());
        }
    };
    /* access modifiers changed from: private */
    public ObjectAnimator collapseAnimator;
    private ObjectAnimator colorFadingAnimator;
    private int displayedIndicatorColor;
    private final CircularDrawingDelegate drawingDelegate = new CircularDrawingDelegate();
    private int indicatorColorIndex;
    private float indicatorHeadChangeFraction;
    private float indicatorInCycleOffset;
    private float indicatorStartOffset;
    private float indicatorTailChangeFraction;
    boolean indicatorWillFullyCollapsed = false;
    private Animator mainAnimator;
    Animatable2Compat.AnimationCallback mainAnimatorCompleteCallback = null;
    boolean mainAnimatorCompleteEndRequested = false;

    CircularIndeterminateDrawable(ProgressIndicator progressIndicator) {
        super(progressIndicator);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.BUTT);
        this.paint.setAntiAlias(true);
        initializeAnimators();
    }

    private void initializeAnimators() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, INDICATOR_IN_CYCLE_OFFSET, new float[]{0.0f, INDICATOR_OFFSET_PER_COLOR_DEGREES});
        ofFloat.setDuration(DURATION_PER_COLOR_IN_MS);
        ofFloat.setInterpolator((TimeInterpolator) null);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, INDICATOR_HEAD_CHANGE_FRACTION, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(666);
        ofFloat2.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CircularIndeterminateDrawable.this.mainAnimatorCompleteEndRequested) {
                    CircularIndeterminateDrawable.this.collapseAnimator.setFloatValues(new float[]{0.0f, 1.08f});
                    CircularIndeterminateDrawable.this.indicatorWillFullyCollapsed = true;
                }
            }
        });
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, INDICATOR_TAIL_CHANGE_FRACTION, new float[]{0.0f, 1.0f});
        this.collapseAnimator = ofFloat3;
        ofFloat3.setDuration(666);
        this.collapseAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, DISPLAYED_INDICATOR_COLOR, new ArgbEvaluatorCompat(), new Integer[]{Integer.valueOf(this.combinedIndicatorColorArray[this.indicatorColorIndex]), Integer.valueOf(this.combinedIndicatorColorArray[getNextIndicatorColorIndex()])});
        this.colorFadingAnimator = ofObject;
        ofObject.setDuration(COLOR_FADING_DURATION);
        this.colorFadingAnimator.setStartDelay(1000);
        this.colorFadingAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat2, this.collapseAnimator});
        animatorSet.playTogether(new Animator[]{ofFloat, this.colorFadingAnimator});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CircularIndeterminateDrawable.this.mainAnimatorCompleteEndRequested && CircularIndeterminateDrawable.this.indicatorWillFullyCollapsed) {
                    CircularIndeterminateDrawable.this.mainAnimatorCompleteCallback.onAnimationEnd(CircularIndeterminateDrawable.this);
                    CircularIndeterminateDrawable.this.mainAnimatorCompleteEndRequested = false;
                    CircularIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
                } else if (CircularIndeterminateDrawable.this.isVisible()) {
                    CircularIndeterminateDrawable.this.resetMainAnimatorPropertiesForNextCycle();
                    CircularIndeterminateDrawable.this.startMainAnimator();
                } else {
                    CircularIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
                }
            }
        });
        this.mainAnimator = animatorSet;
        getHideAnimator().addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CircularIndeterminateDrawable.this.cancelMainAnimatorImmediately();
                CircularIndeterminateDrawable.this.resetMainAnimatorPropertiesForEnd();
            }
        });
        resetMainAnimatorPropertiesForEnd();
        setGrowFraction(1.0f);
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
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedTrackColor, 0.0f, 1.0f, indicatorWidth);
            Canvas canvas2 = canvas;
            this.drawingDelegate.fillTrackWithColor(canvas2, this.paint, this.displayedIndicatorColor, (((getIndicatorStartOffset() + getIndicatorInCycleOffset()) - INDICATOR_MIN_DEGREES) + (getIndicatorTailChangeFraction() * INDICATOR_DELTA_DEGREES)) / INDICATOR_OFFSET_PER_COLOR_DEGREES, ((getIndicatorStartOffset() + getIndicatorInCycleOffset()) + (getIndicatorHeadChangeFraction() * INDICATOR_DELTA_DEGREES)) / INDICATOR_OFFSET_PER_COLOR_DEGREES, indicatorWidth);
            canvas.restore();
        }
    }

    public void startMainAnimator() {
        this.mainAnimator.start();
    }

    public void resetMainAnimatorPropertiesForEnd() {
        setIndicatorHeadChangeFraction(0.0f);
        setIndicatorTailChangeFraction(0.0f);
        setIndicatorStartOffset(0.0f);
        this.indicatorColorIndex = 0;
        this.colorFadingAnimator.setIntValues(new int[]{this.combinedIndicatorColorArray[this.indicatorColorIndex], this.combinedIndicatorColorArray[getNextIndicatorColorIndex()]});
        this.displayedIndicatorColor = this.combinedIndicatorColorArray[this.indicatorColorIndex];
    }

    public void resetMainAnimatorPropertiesForNextCycle() {
        setIndicatorHeadChangeFraction(0.0f);
        setIndicatorTailChangeFraction(0.0f);
        setIndicatorStartOffset(MathUtils.floorMod(getIndicatorStartOffset() + INDICATOR_OFFSET_PER_COLOR_DEGREES + INDICATOR_DELTA_DEGREES, 360));
        this.indicatorColorIndex = getNextIndicatorColorIndex();
        this.colorFadingAnimator.setIntValues(new int[]{this.combinedIndicatorColorArray[this.indicatorColorIndex], this.combinedIndicatorColorArray[getNextIndicatorColorIndex()]});
        this.displayedIndicatorColor = this.combinedIndicatorColorArray[this.indicatorColorIndex];
    }

    public void cancelMainAnimatorImmediately() {
        this.mainAnimator.cancel();
    }

    public void requestCancelMainAnimatorAfterCurrentCycle() {
        if (!this.mainAnimatorCompleteEndRequested) {
            if (isVisible()) {
                this.mainAnimatorCompleteEndRequested = true;
            } else {
                cancelMainAnimatorImmediately();
            }
        }
    }

    public void registerMainAnimatorCompleteEndCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.mainAnimatorCompleteCallback = animationCallback;
    }

    private int getNextIndicatorColorIndex() {
        return (this.indicatorColorIndex + 1) % this.combinedIndicatorColorArray.length;
    }

    /* access modifiers changed from: private */
    public int getDisplayedIndicatorColor() {
        return this.displayedIndicatorColor;
    }

    /* access modifiers changed from: private */
    public void setDisplayedIndicatorColor(int i) {
        this.displayedIndicatorColor = i;
        invalidateSelf();
    }

    private float getIndicatorStartOffset() {
        return this.indicatorStartOffset;
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorStartOffset(float f) {
        this.indicatorStartOffset = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getIndicatorInCycleOffset() {
        return this.indicatorInCycleOffset;
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorInCycleOffset(float f) {
        this.indicatorInCycleOffset = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getIndicatorHeadChangeFraction() {
        return this.indicatorHeadChangeFraction;
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorHeadChangeFraction(float f) {
        this.indicatorHeadChangeFraction = f;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public float getIndicatorTailChangeFraction() {
        return this.indicatorTailChangeFraction;
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorTailChangeFraction(float f) {
        this.indicatorTailChangeFraction = f;
        invalidateSelf();
    }
}
