package p015io.noties.markwon.core.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import java.lang.ref.WeakReference;

/* renamed from: io.noties.markwon.core.spans.TextLayoutSpan */
public class TextLayoutSpan {
    private final WeakReference<Layout> reference;

    public static Layout layoutOf(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return layoutOf((Spanned) charSequence);
        }
        return null;
    }

    public static Layout layoutOf(Spanned spanned) {
        TextLayoutSpan[] textLayoutSpanArr = (TextLayoutSpan[]) spanned.getSpans(0, spanned.length(), TextLayoutSpan.class);
        if (textLayoutSpanArr == null || textLayoutSpanArr.length <= 0) {
            return null;
        }
        return textLayoutSpanArr[0].layout();
    }

    public static void applyTo(Spannable spannable, Layout layout) {
        TextLayoutSpan[] textLayoutSpanArr = (TextLayoutSpan[]) spannable.getSpans(0, spannable.length(), TextLayoutSpan.class);
        if (textLayoutSpanArr != null) {
            for (TextLayoutSpan removeSpan : textLayoutSpanArr) {
                spannable.removeSpan(removeSpan);
            }
        }
        spannable.setSpan(new TextLayoutSpan(layout), 0, spannable.length(), 18);
    }

    TextLayoutSpan(Layout layout) {
        this.reference = new WeakReference<>(layout);
    }

    public Layout layout() {
        return (Layout) this.reference.get();
    }
}
