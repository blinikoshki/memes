package p015io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.core.spans.CodeSpan */
public class CodeSpan extends MetricAffectingSpan {
    private final MarkwonTheme theme;

    public CodeSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
        textPaint.bgColor = this.theme.getCodeBackgroundColor(textPaint);
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyCodeTextStyle(textPaint);
    }
}
