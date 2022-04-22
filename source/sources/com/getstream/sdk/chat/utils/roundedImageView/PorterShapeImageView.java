package com.getstream.sdk.chat.utils.roundedImageView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class PorterShapeImageView extends PorterImageView {
    private Matrix drawMatrix;
    private Matrix matrix;
    private Drawable shape;

    public PorterShapeImageView(Context context) {
        super(context);
        setup(context, (AttributeSet) null, 0);
    }

    public PorterShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet, 0);
    }

    public PorterShapeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context, attributeSet, i);
    }

    private void setup(Context context, AttributeSet attributeSet, int i) {
        this.matrix = new Matrix();
    }

    /* access modifiers changed from: protected */
    public void paintMaskCanvas(Canvas canvas, Paint paint, int i, int i2) {
        Drawable drawable = this.shape;
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                configureBitmapBounds(i, i2);
                if (this.drawMatrix != null) {
                    int saveCount = canvas.getSaveCount();
                    canvas.save();
                    canvas.concat(this.matrix);
                    this.shape.draw(canvas);
                    canvas.restoreToCount(saveCount);
                    return;
                }
            }
            this.shape.setBounds(0, 0, i, i2);
            this.shape.draw(canvas);
        }
    }

    private void configureBitmapBounds(int i, int i2) {
        this.drawMatrix = null;
        int intrinsicWidth = this.shape.getIntrinsicWidth();
        int intrinsicHeight = this.shape.getIntrinsicHeight();
        boolean z = i == intrinsicWidth && i2 == intrinsicHeight;
        if (intrinsicWidth > 0 && intrinsicHeight > 0 && !z) {
            this.shape.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            float f = (float) i;
            float f2 = (float) intrinsicWidth;
            float f3 = (float) i2;
            float f4 = (float) intrinsicHeight;
            float min = Math.min(f / f2, f3 / f4);
            this.matrix.setScale(min, min);
            this.matrix.postTranslate((float) ((int) (((f - (f2 * min)) * 0.5f) + 0.5f)), (float) ((int) (((f3 - (f4 * min)) * 0.5f) + 0.5f)));
        }
    }

    public void setShape(Context context, Drawable drawable) {
        if (this.shape == null) {
            this.shape = drawable;
        }
        setup(context, (AttributeSet) null, 0);
    }
}
