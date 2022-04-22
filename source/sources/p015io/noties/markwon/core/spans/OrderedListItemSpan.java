package p015io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import p015io.noties.markwon.core.MarkwonTheme;
import p015io.noties.markwon.utils.LeadingMarginUtils;

/* renamed from: io.noties.markwon.core.spans.OrderedListItemSpan */
public class OrderedListItemSpan implements LeadingMarginSpan {
    private int margin;
    private final String number;
    private final Paint paint = ObjectsPool.paint();
    private final MarkwonTheme theme;

    public static void measure(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            OrderedListItemSpan[] orderedListItemSpanArr = (OrderedListItemSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), OrderedListItemSpan.class);
            if (orderedListItemSpanArr != null) {
                TextPaint paint2 = textView.getPaint();
                for (OrderedListItemSpan orderedListItemSpan : orderedListItemSpanArr) {
                    orderedListItemSpan.margin = (int) (paint2.measureText(orderedListItemSpan.number) + 0.5f);
                }
            }
        }
    }

    public OrderedListItemSpan(MarkwonTheme markwonTheme, String str) {
        this.theme = markwonTheme;
        this.number = str;
    }

    public int getLeadingMargin(boolean z) {
        return Math.max(this.margin, this.theme.getBlockMargin());
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint2);
            this.theme.applyListItemStyle(this.paint);
            int measureText = (int) (this.paint.measureText(this.number) + 0.5f);
            int blockMargin = this.theme.getBlockMargin();
            if (measureText > blockMargin) {
                this.margin = measureText;
                blockMargin = measureText;
            } else {
                this.margin = 0;
            }
            canvas.drawText(this.number, (float) (i2 > 0 ? (i + (blockMargin * i2)) - measureText : i + (i2 * blockMargin) + (blockMargin - measureText)), (float) i4, this.paint);
        }
    }
}
