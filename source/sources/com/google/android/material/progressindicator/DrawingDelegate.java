package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

interface DrawingDelegate {
    void adjustCanvas(Canvas canvas, ProgressIndicator progressIndicator, float f);

    void fillTrackWithColor(Canvas canvas, Paint paint, int i, float f, float f2, float f3);
}
