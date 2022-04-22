package p015io.noties.markwon.utils;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import p015io.noties.markwon.core.spans.TextLayoutSpan;
import p015io.noties.markwon.core.spans.TextViewSpan;

/* renamed from: io.noties.markwon.utils.SpanUtils */
public abstract class SpanUtils {
    public static int width(Canvas canvas, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Layout layoutOf = TextLayoutSpan.layoutOf(spanned);
            if (layoutOf != null) {
                return layoutOf.getWidth();
            }
            TextView textViewOf = TextViewSpan.textViewOf(spanned);
            if (textViewOf != null) {
                return (textViewOf.getWidth() - textViewOf.getPaddingLeft()) - textViewOf.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }
}
