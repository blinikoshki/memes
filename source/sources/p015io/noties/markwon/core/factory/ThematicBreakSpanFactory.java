package p015io.noties.markwon.core.factory;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.spans.ThematicBreakSpan;

/* renamed from: io.noties.markwon.core.factory.ThematicBreakSpanFactory */
public class ThematicBreakSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new ThematicBreakSpan(markwonConfiguration.theme());
    }
}
