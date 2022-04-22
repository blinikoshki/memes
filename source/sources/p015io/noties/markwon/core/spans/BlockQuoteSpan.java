package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.core.spans.BlockQuoteSpan */
public class BlockQuoteSpan implements LeadingMarginSpan {
    private final Paint paint = ObjectsPool.paint();
    private final Rect rect = ObjectsPool.rect();
    private final MarkwonTheme theme;

    public BlockQuoteSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    public int getLeadingMargin(boolean z) {
        return this.theme.getBlockMargin();
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int blockQuoteWidth = this.theme.getBlockQuoteWidth();
        this.paint.set(paint2);
        this.theme.applyBlockQuoteStyle(this.paint);
        int i8 = i2 * blockQuoteWidth;
        int i9 = i + i8;
        int i10 = i8 + i9;
        this.rect.set(Math.min(i9, i10), i3, Math.max(i9, i10), i5);
        canvas.drawRect(this.rect, this.paint);
    }
}
