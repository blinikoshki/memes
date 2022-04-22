package com.getstream.sdk.chat.utils.frescoimageviewer.drawee;

import android.view.ViewParent;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import p019me.relex.photodraweeview.Attacher;
import p019me.relex.photodraweeview.OnScaleChangeListener;

class NonInterceptableAttacher extends Attacher {
    private OnScaleChangeListener scaleChangeListener;

    public NonInterceptableAttacher(DraweeView<GenericDraweeHierarchy> draweeView) {
        super(draweeView);
    }

    public void onDrag(float f, float f2) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            getDrawMatrix().postTranslate(f, f2);
            checkMatrixAndInvalidate();
            ViewParent parent = draweeView.getParent();
            if (parent != null) {
                if (getScale() == 1.0f) {
                    parent.requestDisallowInterceptTouchEvent(false);
                } else {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.scaleChangeListener = onScaleChangeListener;
    }

    public void onScale(float f, float f2, float f3) {
        super.onScale(f, f2, f3);
        OnScaleChangeListener onScaleChangeListener = this.scaleChangeListener;
        if (onScaleChangeListener != null) {
            onScaleChangeListener.onScaleChange(f, f2, f3);
        }
    }
}
