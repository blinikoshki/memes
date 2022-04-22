package p015io.noties.markwon.core.factory;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.spans.CodeBlockSpan;

/* renamed from: io.noties.markwon.core.factory.CodeBlockSpanFactory */
public class CodeBlockSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new CodeBlockSpan(markwonConfiguration.theme());
    }
}
