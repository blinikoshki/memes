package p015io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: io.noties.markwon.core.spans.EmphasisSpan */
public class EmphasisSpan extends MetricAffectingSpan {
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(-0.25f);
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(-0.25f);
    }
}
