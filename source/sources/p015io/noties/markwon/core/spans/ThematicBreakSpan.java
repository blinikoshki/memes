package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.core.spans.ThematicBreakSpan */
public class ThematicBreakSpan implements LeadingMarginSpan {
    private final Paint paint = ObjectsPool.paint();
    private final Rect rect = ObjectsPool.rect();
    private final MarkwonTheme theme;

    public int getLeadingMargin(boolean z) {
        return 0;
    }

    public ThematicBreakSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9 = i3 + ((i5 - i3) / 2);
        this.paint.set(paint2);
        this.theme.applyThematicBreakStyle(this.paint);
        int strokeWidth = (int) ((((float) ((int) (this.paint.getStrokeWidth() + 0.5f))) / 2.0f) + 0.5f);
        if (i2 > 0) {
            i8 = canvas.getWidth();
        } else {
            i8 = i;
            i -= canvas.getWidth();
        }
        this.rect.set(i, i9 - strokeWidth, i8, i9 + strokeWidth);
        canvas.drawRect(this.rect, this.paint);
    }
}
