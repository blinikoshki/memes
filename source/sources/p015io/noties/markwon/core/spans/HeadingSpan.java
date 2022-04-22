package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import p015io.noties.markwon.core.MarkwonTheme;
import p015io.noties.markwon.utils.LeadingMarginUtils;

/* renamed from: io.noties.markwon.core.spans.HeadingSpan */
public class HeadingSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final int level;
    private final Paint paint = ObjectsPool.paint();
    private final Rect rect = ObjectsPool.rect();
    private final MarkwonTheme theme;

    public int getLeadingMargin(boolean z) {
        return 0;
    }

    public HeadingSpan(MarkwonTheme markwonTheme, int i) {
        this.theme = markwonTheme;
        this.level = i;
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyHeadingTextStyle(textPaint, this.level);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9 = this.level;
        if ((i9 == 1 || i9 == 2) && LeadingMarginUtils.selfEnd(i7, charSequence, this)) {
            this.paint.set(paint2);
            this.theme.applyHeadingBreakStyle(this.paint);
            float strokeWidth = this.paint.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i10 = (int) ((((float) i5) - strokeWidth) + 0.5f);
                if (i2 > 0) {
                    i8 = canvas.getWidth();
                } else {
                    i8 = i;
                    i -= canvas.getWidth();
                }
                this.rect.set(i, i10, i8, i5);
                canvas.drawRect(this.rect, this.paint);
            }
        }
    }

    public int getLevel() {
        return this.level;
    }
}
