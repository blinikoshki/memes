package com.getstream.sdk.chat.utils.roundedImageView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

public abstract class PorterImageView extends AppCompatImageView {
    private static final PorterDuffXfermode PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private static final String TAG = "PorterImageView";
    private Bitmap drawableBitmap;
    private Canvas drawableCanvas;
    private Paint drawablePaint;
    private boolean invalidated = true;
    private TaggedLogger logger = ChatLogger.Companion.get(TAG);
    private Bitmap maskBitmap;
    private Canvas maskCanvas;
    private Paint maskPaint;
    private boolean square = false;

    /* access modifiers changed from: protected */
    public abstract void paintMaskCanvas(Canvas canvas, Paint paint, int i, int i2);

    public PorterImageView(Context context) {
        super(context);
        setup(context, (AttributeSet) null, 0);
    }

    public PorterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet, 0);
    }

    public PorterImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context, attributeSet, i);
    }

    public void setSquare(boolean z) {
        this.square = z;
    }

    private void setup(Context context, AttributeSet attributeSet, int i) {
        this.square = true;
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        Paint paint = new Paint(1);
        this.maskPaint = paint;
        paint.setColor(-16777216);
    }

    public void invalidate() {
        this.invalidated = true;
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createMaskCanvas(i, i2, i3, i4);
    }

    private void createMaskCanvas(int i, int i2, int i3, int i4) {
        boolean z = false;
        boolean z2 = (i == i3 && i2 == i4) ? false : true;
        if (i > 0 && i2 > 0) {
            z = true;
        }
        if (!z) {
            return;
        }
        if (this.maskCanvas == null || z2) {
            this.maskCanvas = new Canvas();
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.maskBitmap = createBitmap;
            this.maskCanvas.setBitmap(createBitmap);
            this.maskPaint.reset();
            paintMaskCanvas(this.maskCanvas, this.maskPaint, i, i2);
            this.drawableCanvas = new Canvas();
            Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.drawableBitmap = createBitmap2;
            this.drawableCanvas.setBitmap(createBitmap2);
            this.drawablePaint = new Paint(1);
            this.invalidated = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        if (!isInEditMode()) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null, 31);
            try {
                boolean z = this.invalidated;
                if (z && (drawable = getDrawable()) != null) {
                    Matrix imageMatrix = getImageMatrix();
                    if (imageMatrix == null) {
                        drawable.draw(this.drawableCanvas);
                    } else {
                        Canvas canvas2 = this.drawableCanvas;
                        if (canvas2 == null) {
                            canvas.restoreToCount(saveLayer);
                            return;
                        }
                        int saveCount = canvas2.getSaveCount();
                        this.drawableCanvas.save();
                        this.drawableCanvas.concat(imageMatrix);
                        drawable.draw(this.drawableCanvas);
                        this.drawableCanvas.restoreToCount(saveCount);
                    }
                    this.drawablePaint.reset();
                    this.drawablePaint.setFilterBitmap(false);
                    this.drawablePaint.setXfermode(PORTER_DUFF_XFERMODE);
                    this.drawableCanvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, this.drawablePaint);
                    z = false;
                }
                if (!z) {
                    this.drawablePaint.setXfermode((Xfermode) null);
                    canvas.drawBitmap(this.drawableBitmap, 0.0f, 0.0f, this.drawablePaint);
                }
            } catch (Exception e) {
                TaggedLogger taggedLogger = this.logger;
                taggedLogger.logE("Exception occured while drawing " + getId(), (Throwable) e);
            } catch (Throwable th) {
                canvas.restoreToCount(saveLayer);
                throw th;
            }
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.square) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(min, min);
        }
    }
}
