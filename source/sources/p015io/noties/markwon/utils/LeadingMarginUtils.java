package p015io.noties.markwon.utils;

import android.text.Spanned;

/* renamed from: io.noties.markwon.utils.LeadingMarginUtils */
public abstract class LeadingMarginUtils {
    public static boolean selfStart(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i;
    }

    public static boolean selfEnd(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i;
    }

    private LeadingMarginUtils() {
    }
}
