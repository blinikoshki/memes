package com.getstream.sdk.chat.utils.frescoimageviewer.drawee;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import p019me.relex.photodraweeview.IAttacher;
import p019me.relex.photodraweeview.OnPhotoTapListener;
import p019me.relex.photodraweeview.OnScaleChangeListener;
import p019me.relex.photodraweeview.OnViewTapListener;

public class ZoomableDraweeView extends SimpleDraweeView implements IAttacher {
    private NonInterceptableAttacher attacher;

    public ZoomableDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init();
    }

    public ZoomableDraweeView(Context context) {
        super(context);
        init();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        NonInterceptableAttacher nonInterceptableAttacher = this.attacher;
        if (nonInterceptableAttacher == null || nonInterceptableAttacher.getDraweeView() == null) {
            this.attacher = new NonInterceptableAttacher(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.attacher.getDrawMatrix());
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.attacher.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScale(float f, boolean z) {
        setScale(f, (float) (getRight() / 2), (float) (getBottom() / 2), z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.attacher.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(long j) {
        this.attacher.setZoomTransitionDuration(j);
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.setAllowParentInterceptOnEdge(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangeListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.attacher.getOnPhotoTapListener();
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public OnViewTapListener getOnViewTapListener() {
        return this.attacher.getOnViewTapListener();
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.attacher.setOnViewTapListener(onViewTapListener);
    }

    public void update(int i, int i2) {
        this.attacher.update(i, i2);
    }
}
