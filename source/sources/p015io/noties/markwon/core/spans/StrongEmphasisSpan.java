package p015io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: io.noties.markwon.core.spans.StrongEmphasisSpan */
public class StrongEmphasisSpan extends MetricAffectingSpan {
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }
}
