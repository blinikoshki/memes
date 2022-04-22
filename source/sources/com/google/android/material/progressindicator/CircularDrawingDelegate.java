package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

final class CircularDrawingDelegate implements DrawingDelegate {
    private RectF arcBound = new RectF();
    private int arcInverseFactor = 1;

    CircularDrawingDelegate() {
    }

    public void adjustCanvas(Canvas canvas, ProgressIndicator progressIndicator, float f) {
        int circularRadius = progressIndicator.getCircularRadius() + (progressIndicator.getIndicatorWidth() / 2) + progressIndicator.getCircularInset();
        float f2 = (float) circularRadius;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        int i = -circularRadius;
        canvas.clipRect(i, i, circularRadius, circularRadius);
        float circularRadius2 = (float) progressIndicator.getCircularRadius();
        int i2 = 1;
        if (progressIndicator.getGrowMode() == 1) {
            circularRadius2 += ((1.0f - f) * ((float) progressIndicator.getIndicatorWidth())) / 2.0f;
        } else if (progressIndicator.getGrowMode() == 2) {
            circularRadius2 -= ((1.0f - f) * ((float) progressIndicator.getIndicatorWidth())) / 2.0f;
        }
        float f3 = -circularRadius2;
        this.arcBound = new RectF(f3, f3, circularRadius2, circularRadius2);
        if (progressIndicator.isInverse()) {
            i2 = -1;
        }
        this.arcInverseFactor = i2;
    }

    public void fillTrackWithColor(Canvas canvas, Paint paint, int i, float f, float f2, float f3) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(f3);
        int i2 = this.arcInverseFactor;
        float f4 = f * 360.0f * ((float) i2);
        if (f2 < f) {
            f2 += 1.0f;
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.arcBound, f4, (f2 - f) * 360.0f * ((float) i2), false, paint);
    }
}
