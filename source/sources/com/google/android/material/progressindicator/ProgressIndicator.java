package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.C2727R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ProgressIndicator extends ProgressBar {
    protected static final float ANIMATION_SPEED_FACTOR = 1.0f;
    public static final int CIRCULAR = 1;
    private static final float DEFAULT_OPACITY = 0.2f;
    private static final int DEF_STYLE_RES = C2727R.C2734style.Widget_MaterialComponents_ProgressIndicator_Linear_Determinate;
    public static final int GROW_MODE_BIDIRECTIONAL = 3;
    public static final int GROW_MODE_INCOMING = 1;
    public static final int GROW_MODE_NONE = 0;
    public static final int GROW_MODE_OUTGOING = 2;
    public static final int LINEAR = 0;
    private static final int MAX_ALPHA = 255;
    private int circularInset;
    private int circularRadius;
    private int defaultCircularInset;
    private int defaultCircularRadius;
    private int defaultIndicatorWidth;
    private int growMode;
    private int[] indicatorColors;
    private int indicatorType;
    private int indicatorWidth;
    private boolean inverse;
    private boolean isParentDoneInitializing;
    private boolean linearSeamless;
    /* access modifiers changed from: private */
    public int storedProgress;
    /* access modifiers changed from: private */
    public boolean storedProgressAnimated;
    private int trackColor;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GrowMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorType {
    }

    public ProgressIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2727R.attr.progressIndicatorStyle);
    }

    public ProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, DEF_STYLE_RES);
    }

    public ProgressIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.isParentDoneInitializing = true;
        Context context2 = getContext();
        loadResources(context2.getResources());
        loadAttributes(context2, attributeSet, i, i2);
        initializeDrawables();
        applyNewVisibility();
    }

    private void loadResources(Resources resources) {
        this.defaultIndicatorWidth = resources.getDimensionPixelSize(C2727R.dimen.mtrl_progress_indicator_width);
        this.defaultCircularInset = resources.getDimensionPixelSize(C2727R.dimen.mtrl_progress_circular_inset);
        this.defaultCircularRadius = resources.getDimensionPixelSize(C2727R.dimen.mtrl_progress_circular_radius);
    }

    private void loadAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2727R.styleable.ProgressIndicator, i, i2);
        this.indicatorType = obtainStyledAttributes.getInt(C2727R.styleable.ProgressIndicator_indicatorType, 0);
        this.indicatorWidth = obtainStyledAttributes.getDimensionPixelSize(C2727R.styleable.ProgressIndicator_indicatorWidth, this.defaultIndicatorWidth);
        this.circularInset = obtainStyledAttributes.getDimensionPixelSize(C2727R.styleable.ProgressIndicator_circularInset, this.defaultCircularInset);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C2727R.styleable.ProgressIndicator_circularRadius, this.defaultCircularRadius);
        this.circularRadius = dimensionPixelSize;
        if (this.indicatorType != 1 || dimensionPixelSize >= this.indicatorWidth / 2) {
            this.inverse = obtainStyledAttributes.getBoolean(C2727R.styleable.ProgressIndicator_inverse, false);
            this.growMode = obtainStyledAttributes.getInt(C2727R.styleable.ProgressIndicator_growMode, 0);
            if (obtainStyledAttributes.hasValue(C2727R.styleable.ProgressIndicator_indicatorColors)) {
                this.indicatorColors = getResources().getIntArray(obtainStyledAttributes.getResourceId(C2727R.styleable.ProgressIndicator_indicatorColors, -1));
                if (obtainStyledAttributes.hasValue(C2727R.styleable.ProgressIndicator_indicatorColor)) {
                    throw new IllegalArgumentException("Attributes indicatorColors and indicatorColor cannot be used at the same time.");
                } else if (this.indicatorColors.length == 0) {
                    throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
                }
            } else if (obtainStyledAttributes.hasValue(C2727R.styleable.ProgressIndicator_indicatorColor)) {
                this.indicatorColors = new int[]{obtainStyledAttributes.getColor(C2727R.styleable.ProgressIndicator_indicatorColor, -1)};
            } else {
                this.indicatorColors = new int[]{MaterialColors.getColor(getContext(), C2727R.attr.colorPrimary, -1)};
            }
            if (obtainStyledAttributes.hasValue(C2727R.styleable.ProgressIndicator_trackColor)) {
                this.trackColor = obtainStyledAttributes.getColor(C2727R.styleable.ProgressIndicator_trackColor, -1);
            } else {
                this.trackColor = this.indicatorColors[0];
                TypedArray obtainStyledAttributes2 = getContext().getTheme().obtainStyledAttributes(new int[]{16842803});
                float f = obtainStyledAttributes2.getFloat(0, 0.2f);
                obtainStyledAttributes2.recycle();
                this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (f * 255.0f));
            }
            if (isEligibleToSeamless()) {
                this.linearSeamless = obtainStyledAttributes.getBoolean(C2727R.styleable.ProgressIndicator_linearSeamless, true);
            } else {
                this.linearSeamless = false;
            }
            setIndeterminate(obtainStyledAttributes.getBoolean(C2727R.styleable.ProgressIndicator_android_indeterminate, false));
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("The circularRadius cannot be less than half of the indicatorWidth.");
    }

    private void initializeDrawables() {
        if (this.indicatorType == 0) {
            setIndeterminateDrawable(new LinearIndeterminateDrawable(getContext(), this));
            setProgressDrawable(new DeterminateDrawable(this, new LinearDrawingDelegate()));
        } else {
            setIndeterminateDrawable(new CircularIndeterminateDrawable(this));
            setProgressDrawable(new DeterminateDrawable(this, new CircularDrawingDelegate()));
        }
        ((IndeterminateAnimatorControl) getIndeterminateDrawable()).registerMainAnimatorCompleteEndCallback(new Animatable2Compat.AnimationCallback() {
            public void onAnimationEnd(Drawable drawable) {
                ProgressIndicator.this.post(new Runnable() {
                    public void run() {
                        ProgressIndicator.this.setIndeterminate(false);
                        ProgressIndicator.this.setProgressCompat(0, false);
                        ProgressIndicator.this.setProgressCompat(ProgressIndicator.this.storedProgress, ProgressIndicator.this.storedProgressAnimated);
                    }
                });
            }
        });
        C28692 r0 = new Animatable2Compat.AnimationCallback() {
            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                ProgressIndicator.this.post(new Runnable() {
                    public void run() {
                        if (ProgressIndicator.this.getVisibility() == 0) {
                            ProgressIndicator.this.setVisibility(4);
                        }
                    }
                });
            }
        };
        getProgressDrawable().registerAnimationCallback(r0);
        getIndeterminateDrawable().registerAnimationCallback(r0);
    }

    public void disableAnimatorsForTesting() {
        getProgressDrawable().disableAnimatorsForTesting();
        getIndeterminateDrawable().disableAnimatorsForTesting();
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        DrawableWithAnimatedVisibilityChange currentDrawable = getCurrentDrawable();
        boolean z = visibleToUser() && this.growMode != 0;
        currentDrawable.setVisible(false, z);
        if (!z) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        applyNewVisibility();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        applyNewVisibility();
    }

    private void applyNewVisibility() {
        if (this.isParentDoneInitializing) {
            DrawableWithAnimatedVisibilityChange currentDrawable = getCurrentDrawable();
            boolean visibleToUser = visibleToUser();
            currentDrawable.setVisible(visibleToUser, visibleToUser);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (visibleToUser()) {
            show();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        getCurrentDrawable().setVisible(false, false);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.indicatorType == 1) {
            setMeasuredDimension((this.circularRadius * 2) + this.indicatorWidth + (this.circularInset * 2) + getPaddingLeft() + getPaddingRight(), (this.circularRadius * 2) + this.indicatorWidth + (this.circularInset * 2) + getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(getMeasuredWidth(), this.indicatorWidth + getPaddingTop() + getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.indicatorType == 0) {
            int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
            int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
            DrawableWithAnimatedVisibilityChange indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable != null) {
                indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
            }
            DeterminateDrawable progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
                return;
            }
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    private boolean isEligibleToSeamless() {
        return isIndeterminate() && this.indicatorType == 0 && this.indicatorColors.length >= 3;
    }

    public DrawableWithAnimatedVisibilityChange getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable instanceof DeterminateDrawable) {
            super.setProgressDrawable(drawable);
            ((DeterminateDrawable) drawable).setLevelByFraction(((float) getProgress()) / ((float) getMax()));
            return;
        }
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithAnimatedVisibilityChange) {
            super.setIndeterminateDrawable(drawable);
            return;
        }
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public DeterminateDrawable getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    public DrawableWithAnimatedVisibilityChange getIndeterminateDrawable() {
        return (DrawableWithAnimatedVisibilityChange) super.getIndeterminateDrawable();
    }

    private boolean visibleToUser() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && isEffectivelyVisible();
    }

    /* access modifiers changed from: protected */
    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    private void updateColorsInDrawables() {
        getProgressDrawable().recalculateColors();
        getIndeterminateDrawable().recalculateColors();
    }

    public int getIndicatorType() {
        return this.indicatorType;
    }

    public void setIndicatorType(int i) {
        if (!visibleToUser() || this.indicatorType == i) {
            this.indicatorType = i;
            initializeDrawables();
            requestLayout();
            return;
        }
        throw new IllegalStateException("Cannot change indicatorType while the progress indicator is visible.");
    }

    public synchronized void setIndeterminate(boolean z) {
        if (visibleToUser() && isIndeterminate() != z) {
            if (z) {
                throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
            }
        }
        super.setIndeterminate(z);
    }

    public int getIndicatorWidth() {
        return this.indicatorWidth;
    }

    public void setIndicatorWidth(int i) {
        if (this.indicatorWidth != i) {
            this.indicatorWidth = i;
            requestLayout();
        }
    }

    public int[] getIndicatorColors() {
        return this.indicatorColors;
    }

    public void setIndicatorColors(int[] iArr) {
        this.indicatorColors = iArr;
        updateColorsInDrawables();
        if (!isEligibleToSeamless()) {
            this.linearSeamless = false;
        }
        invalidate();
    }

    public int getTrackColor() {
        return this.trackColor;
    }

    public void setTrackColor(int i) {
        if (this.trackColor != i) {
            this.trackColor = i;
            updateColorsInDrawables();
            invalidate();
        }
    }

    public boolean isInverse() {
        return this.inverse;
    }

    public void setInverse(boolean z) {
        if (this.inverse != z) {
            this.inverse = z;
            invalidate();
        }
    }

    public int getGrowMode() {
        return this.growMode;
    }

    public void setGrowMode(int i) {
        if (this.growMode != i) {
            this.growMode = i;
            invalidate();
        }
    }

    public boolean isLinearSeamless() {
        return this.linearSeamless;
    }

    public void setLinearSeamless(boolean z) {
        if (!visibleToUser() || !isIndeterminate() || this.linearSeamless == z) {
            if (isEligibleToSeamless()) {
                this.linearSeamless = z;
            } else {
                this.linearSeamless = false;
            }
            invalidate();
            return;
        }
        throw new IllegalStateException("Cannot change linearSeamless while the progress indicator is shown in indeterminate mode.");
    }

    public int getCircularInset() {
        return this.circularInset;
    }

    public void setCircularInset(int i) {
        if (this.indicatorType == 1 && this.circularInset != i) {
            this.circularInset = i;
            invalidate();
        }
    }

    public int getCircularRadius() {
        return this.circularRadius;
    }

    public void setCircularRadius(int i) {
        if (this.indicatorType == 1 && this.circularRadius != i) {
            this.circularRadius = i;
            invalidate();
        }
    }

    public synchronized void setProgress(int i) {
        setProgressCompat(i, false);
    }

    public void setProgressCompat(int i, boolean z) {
        if (isIndeterminate()) {
            ((IndeterminateAnimatorControl) getIndeterminateDrawable()).requestCancelMainAnimatorAfterCurrentCycle();
            this.storedProgress = i;
            this.storedProgressAnimated = z;
            return;
        }
        super.setProgress(i);
        if (!z && getProgressDrawable() != null) {
            getProgressDrawable().jumpToCurrentState();
        }
    }
}
