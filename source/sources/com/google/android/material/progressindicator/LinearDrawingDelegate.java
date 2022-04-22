package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

final class LinearDrawingDelegate implements DrawingDelegate {
    private static final float TRACK_LEFT_LOCAL = -180.0f;
    private static final float TRACK_WIDTH_LOCAL = 360.0f;

    LinearDrawingDelegate() {
    }

    public void adjustCanvas(Canvas canvas, ProgressIndicator progressIndicator, float f) {
        Rect clipBounds = canvas.getClipBounds();
        canvas.translate(((float) clipBounds.width()) / 2.0f, (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - progressIndicator.getIndicatorWidth())) / 2.0f));
        canvas.scale(((float) clipBounds.width()) / TRACK_WIDTH_LOCAL, 1.0f);
        if (progressIndicator.isInverse()) {
            canvas.scale(-1.0f, 1.0f);
        }
        if (progressIndicator.getGrowMode() == 2) {
            canvas.scale(1.0f, -1.0f);
        }
        if (progressIndicator.getGrowMode() == 1 || progressIndicator.getGrowMode() == 2) {
            canvas.translate(0.0f, (((float) progressIndicator.getIndicatorWidth()) * (f - 1.0f)) / 2.0f);
        }
        canvas.clipRect(TRACK_LEFT_LOCAL, ((float) (-progressIndicator.getIndicatorWidth())) / 2.0f, 180.0f, ((float) progressIndicator.getIndicatorWidth()) / 2.0f);
    }

    public void fillTrackWithColor(Canvas canvas, Paint paint, int i, float f, float f2, float f3) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        canvas.drawRect((f * TRACK_WIDTH_LOCAL) + TRACK_LEFT_LOCAL, (-f3) / 2.0f, (f2 * TRACK_WIDTH_LOCAL) + TRACK_LEFT_LOCAL, f3 / 2.0f, paint);
    }
}
