package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

class SwipeToDismissListener implements View.OnTouchListener {
    private static final String PROPERTY_TRANSLATION_X = "translationY";
    private OnDismissListener dismissListener;
    private OnViewMoveListener moveListener;
    private float startY;
    private final View swipeView;
    private boolean tracking = false;
    /* access modifiers changed from: private */
    public int translationLimit;

    interface OnViewMoveListener {
        void onViewMove(float f, int i);
    }

    public SwipeToDismissListener(View view, OnDismissListener onDismissListener, OnViewMoveListener onViewMoveListener) {
        this.swipeView = view;
        this.dismissListener = onDismissListener;
        this.moveListener = onViewMoveListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.translationLimit = view.getHeight() / 4;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.tracking) {
                        float y = motionEvent.getY() - this.startY;
                        this.swipeView.setTranslationY(y);
                        callMoveListener(y, this.translationLimit);
                    }
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.tracking) {
                this.tracking = false;
                animateSwipeView(view.getHeight());
            }
            return true;
        }
        Rect rect = new Rect();
        this.swipeView.getHitRect(rect);
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            this.tracking = true;
        }
        this.startY = motionEvent.getY();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void animateSwipeView(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.swipeView
            float r0 = r0.getTranslationY()
            int r1 = r6.translationLimit
            int r2 = -r1
            float r2 = (float) r2
            r3 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0012
            int r7 = -r7
        L_0x0010:
            float r7 = (float) r7
            goto L_0x0019
        L_0x0012:
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0018
            goto L_0x0010
        L_0x0018:
            r7 = 0
        L_0x0019:
            r1 = 1
            r2 = 0
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0021
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            android.view.View r4 = r6.swipeView
            r5 = 2
            float[] r5 = new float[r5]
            r5[r2] = r0
            r5[r1] = r7
            java.lang.String r7 = "translationY"
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r4, r7, r5)
            r0 = 200(0xc8, double:9.9E-322)
            r7.setDuration(r0)
            android.view.animation.AccelerateInterpolator r0 = new android.view.animation.AccelerateInterpolator
            r0.<init>()
            r7.setInterpolator(r0)
            com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener$1 r0 = new com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener$1
            r0.<init>(r3)
            r7.addListener(r0)
            com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener$2 r0 = new com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener$2
            r0.<init>()
            r7.addUpdateListener(r0)
            r7.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener.animateSwipeView(int):void");
    }

    /* access modifiers changed from: private */
    public void callDismissListener() {
        OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* access modifiers changed from: private */
    public void callMoveListener(float f, int i) {
        OnViewMoveListener onViewMoveListener = this.moveListener;
        if (onViewMoveListener != null) {
            onViewMoveListener.onViewMove(f, i);
        }
    }
}
