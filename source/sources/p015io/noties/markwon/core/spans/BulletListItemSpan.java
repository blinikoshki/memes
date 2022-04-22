package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import p015io.noties.markwon.core.MarkwonTheme;
import p015io.noties.markwon.utils.LeadingMarginUtils;

/* renamed from: io.noties.markwon.core.spans.BulletListItemSpan */
public class BulletListItemSpan implements LeadingMarginSpan {
    private static final boolean IS_NOUGAT;
    private final RectF circle = ObjectsPool.rectF();
    private final int level;
    private final Paint paint = ObjectsPool.paint();
    private final Rect rectangle = ObjectsPool.rect();
    private MarkwonTheme theme;

    static {
        int i = Build.VERSION.SDK_INT;
        IS_NOUGAT = 24 == i || 25 == i;
    }

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i) {
        this.theme = markwonTheme;
        this.level = i;
    }

    public int getLeadingMargin(boolean z) {
        return this.theme.getBlockMargin();
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9;
        Paint.Style style;
        int i10;
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint2);
            this.theme.applyListItemStyle(this.paint);
            int save = canvas.save();
            try {
                int blockMargin = this.theme.getBlockMargin();
                int bulletWidth = this.theme.getBulletWidth((int) ((this.paint.descent() - this.paint.ascent()) + 0.5f));
                int i11 = (blockMargin - bulletWidth) / 2;
                if (IS_NOUGAT) {
                    if (i2 < 0) {
                        i10 = i - (layout.getWidth() - (blockMargin * this.level));
                    } else {
                        i10 = (blockMargin * this.level) - i;
                    }
                    int i12 = i + (i11 * i2);
                    int i13 = (i2 * bulletWidth) + i12;
                    int i14 = i2 * i10;
                    i8 = Math.min(i12, i13) + i14;
                    i9 = Math.max(i12, i13) + i14;
                } else {
                    if (i2 <= 0) {
                        i -= blockMargin;
                    }
                    i8 = i + i11;
                    i9 = i8 + bulletWidth;
                }
                int descent = (i4 + ((int) (((this.paint.descent() + this.paint.ascent()) / 2.0f) + 0.5f))) - (bulletWidth / 2);
                int i15 = bulletWidth + descent;
                int i16 = this.level;
                if (i16 != 0) {
                    if (i16 != 1) {
                        this.rectangle.set(i8, descent, i9, i15);
                        this.paint.setStyle(Paint.Style.FILL);
                        canvas.drawRect(this.rectangle, this.paint);
                    }
                }
                this.circle.set((float) i8, (float) descent, (float) i9, (float) i15);
                if (this.level == 0) {
                    style = Paint.Style.FILL;
                } else {
                    style = Paint.Style.STROKE;
                }
                this.paint.setStyle(style);
                canvas.drawOval(this.circle, this.paint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }
}
