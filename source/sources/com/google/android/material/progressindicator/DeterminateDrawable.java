package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

class DeterminateDrawable extends DrawableWithAnimatedVisibilityChange {
    private static final FloatPropertyCompat<DeterminateDrawable> INDICATOR_LENGTH_FRACTION = new FloatPropertyCompat<DeterminateDrawable>("indicatorFraction") {
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.getIndicatorFraction();
        }

        public void setValue(DeterminateDrawable determinateDrawable, float f) {
            determinateDrawable.setIndicatorFraction(f);
        }
    };
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private final DrawingDelegate drawingDelegate;
    private float indicatorFraction;
    private SpringAnimation springAnimator;

    DeterminateDrawable(ProgressIndicator progressIndicator, DrawingDelegate drawingDelegate2) {
        super(progressIndicator);
        this.drawingDelegate = drawingDelegate2;
        initializeAnimator();
    }

    private void initializeAnimator() {
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, INDICATOR_LENGTH_FRACTION);
        this.springAnimator = springAnimation;
        springAnimation.setSpring(springForce);
        this.springAnimator.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                DeterminateDrawable.this.setIndicatorFraction(f / 10000.0f);
            }
        });
        setGrowFraction(1.0f);
    }

    /* access modifiers changed from: package-private */
    public void setLevelByFraction(float f) {
        setLevel((int) (f * 10000.0f));
    }

    public void jumpToCurrentState() {
        this.springAnimator.cancel();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (!this.animatorsDisabledForTesting) {
            this.springAnimator.setStartValue(getIndicatorFraction() * 10000.0f);
            this.springAnimator.animateToFinalPosition((float) i);
            return true;
        }
        jumpToCurrentState();
        return true;
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.adjustCanvas(canvas, this.progressIndicator, getGrowFraction());
            float indicatorWidth = ((float) this.progressIndicator.getIndicatorWidth()) * getGrowFraction();
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.progressIndicator.getTrackColor(), 0.0f, 1.0f, indicatorWidth);
            this.drawingDelegate.fillTrackWithColor(canvas, this.paint, this.combinedIndicatorColorArray[0], 0.0f, getIndicatorFraction(), indicatorWidth);
            canvas.restore();
        }
    }

    /* access modifiers changed from: private */
    public float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    /* access modifiers changed from: private */
    public void setIndicatorFraction(float f) {
        this.indicatorFraction = f;
        invalidateSelf();
    }
}
