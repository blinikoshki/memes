package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.core.spans.CodeBlockSpan */
public class CodeBlockSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final Paint paint = ObjectsPool.paint();
    private final Rect rect = ObjectsPool.rect();
    private final MarkwonTheme theme;

    public CodeBlockSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyCodeBlockTextStyle(textPaint);
    }

    public int getLeadingMargin(boolean z) {
        return this.theme.getCodeBlockMargin();
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.theme.getCodeBlockBackgroundColor(paint2));
        if (i2 > 0) {
            i8 = canvas.getWidth();
        } else {
            int i9 = i;
            i -= canvas.getWidth();
            i8 = i9;
        }
        this.rect.set(i, i3, i8, i5);
        canvas.drawRect(this.rect, this.paint);
    }
}
