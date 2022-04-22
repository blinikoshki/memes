package p015io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import p015io.noties.markwon.core.MarkwonTheme;
import p015io.noties.markwon.utils.SpanUtils;

/* renamed from: io.noties.markwon.image.AsyncDrawableSpan */
public class AsyncDrawableSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int alignment;
    private final AsyncDrawable drawable;
    private final boolean replacementTextIsLink;
    private final MarkwonTheme theme;

    public AsyncDrawableSpan(MarkwonTheme markwonTheme, AsyncDrawable asyncDrawable, int i, boolean z) {
        this.theme = markwonTheme;
        this.drawable = asyncDrawable;
        this.alignment = i;
        this.replacementTextIsLink = z;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.drawable.hasResult()) {
            Rect bounds = this.drawable.getBounds();
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = -bounds.bottom;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right;
        }
        if (this.replacementTextIsLink) {
            this.theme.applyLinkStyle(paint);
        }
        return (int) (paint.measureText(charSequence, i, i2) + 0.5f);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        Canvas canvas2 = canvas;
        int i7 = i3;
        int i8 = i5;
        Paint paint2 = paint;
        this.drawable.initWithKnownDimensions(SpanUtils.width(canvas, charSequence), paint.getTextSize());
        AsyncDrawable asyncDrawable = this.drawable;
        if (asyncDrawable.hasResult()) {
            int i9 = i8 - asyncDrawable.getBounds().bottom;
            int save = canvas.save();
            try {
                int i10 = this.alignment;
                if (2 == i10) {
                    i6 = ((i8 - i7) - asyncDrawable.getBounds().height()) / 2;
                } else {
                    if (1 == i10) {
                        i6 = paint.getFontMetricsInt().descent;
                    }
                    float f2 = f;
                    canvas.translate(f, (float) i9);
                    asyncDrawable.draw(canvas);
                }
                i9 -= i6;
                float f22 = f;
                canvas.translate(f, (float) i9);
                asyncDrawable.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            float f3 = f;
            float textCenterY = textCenterY(i7, i8, paint2);
            if (this.replacementTextIsLink) {
                this.theme.applyLinkStyle(paint2);
            }
            canvas.drawText(charSequence, i, i2, f, textCenterY, paint);
        }
    }

    public AsyncDrawable getDrawable() {
        return this.drawable;
    }

    private static float textCenterY(int i, int i2, Paint paint) {
        return (float) ((int) (((float) (i + ((i2 - i) / 2))) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f)));
    }
}
