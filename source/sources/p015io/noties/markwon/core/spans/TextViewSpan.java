package p015io.noties.markwon.core.spans;

import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* renamed from: io.noties.markwon.core.spans.TextViewSpan */
public class TextViewSpan {
    private final WeakReference<TextView> reference;

    public static TextView textViewOf(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return textViewOf((Spanned) charSequence);
        }
        return null;
    }

    public static TextView textViewOf(Spanned spanned) {
        TextViewSpan[] textViewSpanArr = (TextViewSpan[]) spanned.getSpans(0, spanned.length(), TextViewSpan.class);
        if (textViewSpanArr == null || textViewSpanArr.length <= 0) {
            return null;
        }
        return textViewSpanArr[0].textView();
    }

    public static void applyTo(Spannable spannable, TextView textView) {
        TextViewSpan[] textViewSpanArr = (TextViewSpan[]) spannable.getSpans(0, spannable.length(), TextViewSpan.class);
        if (textViewSpanArr != null) {
            for (TextViewSpan removeSpan : textViewSpanArr) {
                spannable.removeSpan(removeSpan);
            }
        }
        spannable.setSpan(new TextViewSpan(textView), 0, spannable.length(), 18);
    }

    public TextViewSpan(TextView textView) {
        this.reference = new WeakReference<>(textView);
    }

    public TextView textView() {
        return (TextView) this.reference.get();
    }
}
