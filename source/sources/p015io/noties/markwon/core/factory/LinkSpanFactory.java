package p015io.noties.markwon.core.factory;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.CoreProps;
import p015io.noties.markwon.core.spans.LinkSpan;

/* renamed from: io.noties.markwon.core.factory.LinkSpanFactory */
public class LinkSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new LinkSpan(markwonConfiguration.theme(), CoreProps.LINK_DESTINATION.require(renderProps), markwonConfiguration.linkResolver());
    }
}
