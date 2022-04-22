package p015io.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

/* renamed from: io.noties.markwon.utils.NoCopySpannableFactory */
public class NoCopySpannableFactory extends Spannable.Factory {
    public static NoCopySpannableFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Spannable newSpannable(CharSequence charSequence) {
        if (charSequence instanceof Spannable) {
            return (Spannable) charSequence;
        }
        return new SpannableString(charSequence);
    }

    /* renamed from: io.noties.markwon.utils.NoCopySpannableFactory$Holder */
    static class Holder {
        /* access modifiers changed from: private */
        public static final NoCopySpannableFactory INSTANCE = new NoCopySpannableFactory();

        Holder() {
        }
    }
}
