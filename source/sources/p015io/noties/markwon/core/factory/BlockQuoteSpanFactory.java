package p015io.noties.markwon.core.factory;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.spans.BlockQuoteSpan;

/* renamed from: io.noties.markwon.core.factory.BlockQuoteSpanFactory */
public class BlockQuoteSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new BlockQuoteSpan(markwonConfiguration.theme());
    }
}
