package p015io.noties.markwon.core.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: io.noties.markwon.core.spans.CustomTypefaceSpan */
public class CustomTypefaceSpan extends MetricAffectingSpan {
    private final boolean mergeStyles;
    private final Typeface typeface;

    public static CustomTypefaceSpan create(Typeface typeface2) {
        return create(typeface2, false);
    }

    public static CustomTypefaceSpan create(Typeface typeface2, boolean z) {
        return new CustomTypefaceSpan(typeface2, z);
    }

    @Deprecated
    public CustomTypefaceSpan(Typeface typeface2) {
        this(typeface2, false);
    }

    CustomTypefaceSpan(Typeface typeface2, boolean z) {
        this.typeface = typeface2;
        this.mergeStyles = z;
    }

    public void updateMeasureState(TextPaint textPaint) {
        updatePaint(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        updatePaint(textPaint);
    }

    private void updatePaint(TextPaint textPaint) {
        Typeface typeface2 = textPaint.getTypeface();
        if (!this.mergeStyles || typeface2 == null || typeface2.getStyle() == 0) {
            textPaint.setTypeface(this.typeface);
            return;
        }
        textPaint.setTypeface(Typeface.create(this.typeface, typeface2.getStyle() | this.typeface.getStyle()));
    }
}
