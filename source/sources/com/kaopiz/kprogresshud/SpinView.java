package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

class SpinView extends ImageView implements Indeterminate {
    /* access modifiers changed from: private */
    public int mFrameTime;
    /* access modifiers changed from: private */
    public boolean mNeedToUpdateView;
    /* access modifiers changed from: private */
    public float mRotateDegrees;
    private Runnable mUpdateViewRunnable;

    static /* synthetic */ float access$016(SpinView spinView, float f) {
        float f2 = spinView.mRotateDegrees + f;
        spinView.mRotateDegrees = f2;
        return f2;
    }

    public SpinView(Context context) {
        super(context);
        init();
    }

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setImageResource(C4019R.C4021drawable.kprogresshud_spinner);
        this.mFrameTime = 83;
        this.mUpdateViewRunnable = new Runnable() {
            public void run() {
                SpinView.access$016(SpinView.this, 30.0f);
                SpinView spinView = SpinView.this;
                float unused = spinView.mRotateDegrees = spinView.mRotateDegrees < 360.0f ? SpinView.this.mRotateDegrees : SpinView.this.mRotateDegrees - 360.0f;
                SpinView.this.invalidate();
                if (SpinView.this.mNeedToUpdateView) {
                    SpinView spinView2 = SpinView.this;
                    spinView2.postDelayed(this, (long) spinView2.mFrameTime);
                }
            }
        };
    }

    public void setAnimationSpeed(float f) {
        this.mFrameTime = (int) (83.0f / f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.rotate(this.mRotateDegrees, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mNeedToUpdateView = true;
        post(this.mUpdateViewRunnable);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mNeedToUpdateView = false;
        super.onDetachedFromWindow();
    }
}
