package p015io.noties.markwon.core.factory;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.CoreProps;
import p015io.noties.markwon.core.spans.HeadingSpan;

/* renamed from: io.noties.markwon.core.factory.HeadingSpanFactory */
public class HeadingSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new HeadingSpan(markwonConfiguration.theme(), CoreProps.HEADING_LEVEL.require(renderProps).intValue());
    }
}
