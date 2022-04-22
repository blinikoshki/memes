package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

public class FadeDrawable extends ArrayDrawable {
    public static final int TRANSITION_NONE = 2;
    public static final int TRANSITION_RUNNING = 1;
    public static final int TRANSITION_STARTING = 0;
    private final int ACTUAL_IMAGE_INDEX;
    int mAlpha;
    int[] mAlphas;
    private boolean mCallOnFadeFinishedListener;
    private final int mDefaultLayerAlpha;
    private final boolean mDefaultLayerIsOn;
    int mDurationMs;
    boolean[] mIsLayerOn;
    private final Drawable[] mLayers;
    @Nullable
    private OnFadeFinishedListener mOnFadeFinishedListener;
    int mPreventInvalidateCount;
    int[] mStartAlphas;
    long mStartTimeMs;
    int mTransitionState;

    public interface OnFadeFinishedListener {
        void onFadeFinished();
    }

    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    public FadeDrawable(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        this.ACTUAL_IMAGE_INDEX = 2;
        int i = 0;
        Preconditions.checkState(drawableArr.length < 1 ? false : true, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = z;
        this.mDefaultLayerAlpha = z ? 255 : i;
        resetInternal();
    }

    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
        this.mStartAlphas[0] = 255;
        Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
        this.mAlphas[0] = 255;
        Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
        this.mIsLayerOn[0] = true;
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    public void fadeInLayer(int i) {
        this.mCallOnFadeFinishedListener = i == 2;
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeOutLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = false;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeToLayer(int i) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i) {
        this.mTransitionState = 0;
        int i2 = i + 1;
        Arrays.fill(this.mIsLayerOn, 0, i2, true);
        Arrays.fill(this.mIsLayerOn, i2, this.mLayers.length, false);
        invalidateSelf();
    }

    public void showLayerImmediately(int i) {
        this.mIsLayerOn[i] = true;
        this.mAlphas[i] = 255;
        invalidateSelf();
    }

    public void hideLayerImmediately(int i) {
        this.mIsLayerOn[i] = false;
        this.mAlphas[i] = 0;
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        for (int i = 0; i < this.mLayers.length; i++) {
            this.mAlphas[i] = this.mIsLayerOn[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean updateAlphas(float f) {
        boolean z = true;
        for (int i = 0; i < this.mLayers.length; i++) {
            boolean[] zArr = this.mIsLayerOn;
            int i2 = zArr[i] ? 1 : -1;
            int[] iArr = this.mAlphas;
            iArr[i] = (int) (((float) this.mStartAlphas[i]) + (((float) (i2 * 255)) * f));
            if (iArr[i] < 0) {
                iArr[i] = 0;
            }
            if (iArr[i] > 255) {
                iArr[i] = 255;
            }
            if (zArr[i] && iArr[i] < 255) {
                z = false;
            }
            if (!zArr[i] && iArr[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[LOOP:0: B:26:0x005e->B:28:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[EDGE_INSN: B:31:0x0075->B:29:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.mTransitionState
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 == r3) goto L_0x0010
            if (r0 == r1) goto L_0x000c
            goto L_0x005e
        L_0x000c:
            r8.maybeNotifyOnFadeFinished()
            goto L_0x005e
        L_0x0010:
            int r0 = r8.mDurationMs
            if (r0 <= 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            com.facebook.common.internal.Preconditions.checkState(r0)
            long r4 = r8.getCurrentTimeMs()
            long r6 = r8.mStartTimeMs
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.mDurationMs
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.updateAlphas(r0)
            if (r0 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            r8.mTransitionState = r1
            if (r0 == 0) goto L_0x005d
            r8.maybeNotifyOnFadeFinished()
            goto L_0x005d
        L_0x0036:
            int[] r0 = r8.mAlphas
            int[] r4 = r8.mStartAlphas
            android.graphics.drawable.Drawable[] r5 = r8.mLayers
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.getCurrentTimeMs()
            r8.mStartTimeMs = r4
            int r0 = r8.mDurationMs
            if (r0 != 0) goto L_0x004d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            boolean r0 = r8.updateAlphas(r0)
            if (r0 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r1 = 1
        L_0x0056:
            r8.mTransitionState = r1
            if (r0 == 0) goto L_0x005d
            r8.maybeNotifyOnFadeFinished()
        L_0x005d:
            r3 = r0
        L_0x005e:
            android.graphics.drawable.Drawable[] r0 = r8.mLayers
            int r1 = r0.length
            if (r2 >= r1) goto L_0x0075
            r0 = r0[r2]
            int[] r1 = r8.mAlphas
            r1 = r1[r2]
            int r4 = r8.mAlpha
            int r1 = r1 * r4
            int r1 = r1 / 255
            r8.drawDrawableWithAlpha(r9, r0, r1)
            int r2 = r2 + 1
            goto L_0x005e
        L_0x0075:
            if (r3 != 0) goto L_0x007a
            r8.invalidateSelf()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.FadeDrawable.draw(android.graphics.Canvas):void");
    }

    private void maybeNotifyOnFadeFinished() {
        OnFadeFinishedListener onFadeFinishedListener = this.mOnFadeFinishedListener;
        if (onFadeFinishedListener != null && this.mCallOnFadeFinishedListener) {
            onFadeFinishedListener.onFadeFinished();
            this.mCallOnFadeFinishedListener = false;
        }
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mPreventInvalidateCount++;
            drawable.mutate().setAlpha(i);
            this.mPreventInvalidateCount--;
            drawable.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public int getTransitionState() {
        return this.mTransitionState;
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }

    public boolean isDefaultLayerIsOn() {
        return this.mDefaultLayerIsOn;
    }

    public void setOnFadeFinishedListener(OnFadeFinishedListener onFadeFinishedListener) {
        this.mOnFadeFinishedListener = onFadeFinishedListener;
    }
}
