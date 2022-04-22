package p015io.noties.markwon.linkify;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import androidx.core.text.util.LinkifyCompat;
import org.commonmark.node.Link;
import p015io.noties.markwon.AbstractMarkwonPlugin;
import p015io.noties.markwon.MarkwonPlugin;
import p015io.noties.markwon.MarkwonVisitor;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.SpannableBuilder;
import p015io.noties.markwon.core.CorePlugin;
import p015io.noties.markwon.core.CoreProps;

/* renamed from: io.noties.markwon.linkify.LinkifyPlugin */
public class LinkifyPlugin extends AbstractMarkwonPlugin {
    /* access modifiers changed from: private */
    public final int mask;
    /* access modifiers changed from: private */
    public final boolean useCompat;

    public static LinkifyPlugin create() {
        return create(false);
    }

    public static LinkifyPlugin create(boolean z) {
        return create(7, z);
    }

    public static LinkifyPlugin create(int i) {
        return new LinkifyPlugin(i, false);
    }

    public static LinkifyPlugin create(int i, boolean z) {
        return new LinkifyPlugin(i, z);
    }

    LinkifyPlugin(int i, boolean z) {
        this.mask = i;
        this.useCompat = z;
    }

    public void configure(MarkwonPlugin.Registry registry) {
        registry.require(CorePlugin.class, new MarkwonPlugin.Action<CorePlugin>() {
            public void apply(CorePlugin corePlugin) {
                CorePlugin.OnTextAddedListener onTextAddedListener;
                if (LinkifyPlugin.this.useCompat) {
                    onTextAddedListener = new LinkifyCompatTextAddedListener(LinkifyPlugin.this.mask);
                } else {
                    onTextAddedListener = new LinkifyTextAddedListener(LinkifyPlugin.this.mask);
                }
                corePlugin.addOnTextAddedListener(onTextAddedListener);
            }
        });
    }

    /* renamed from: io.noties.markwon.linkify.LinkifyPlugin$LinkifyTextAddedListener */
    private static class LinkifyTextAddedListener implements CorePlugin.OnTextAddedListener {
        private final int mask;

        LinkifyTextAddedListener(int i) {
            this.mask = i;
        }

        public void onTextAdded(MarkwonVisitor markwonVisitor, String str, int i) {
            SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Link.class);
            if (spanFactory != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                if (addLinks(spannableStringBuilder, this.mask)) {
                    URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                    if (uRLSpanArr != null && uRLSpanArr.length > 0) {
                        RenderProps renderProps = markwonVisitor.renderProps();
                        SpannableBuilder builder = markwonVisitor.builder();
                        for (URLSpan uRLSpan : uRLSpanArr) {
                            CoreProps.LINK_DESTINATION.set(renderProps, uRLSpan.getURL());
                            SpannableBuilder.setSpans(builder, spanFactory.getSpans(markwonVisitor.configuration(), renderProps), spannableStringBuilder.getSpanStart(uRLSpan) + i, spannableStringBuilder.getSpanEnd(uRLSpan) + i);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public boolean addLinks(Spannable spannable, int i) {
            return Linkify.addLinks(spannable, i);
        }
    }

    /* renamed from: io.noties.markwon.linkify.LinkifyPlugin$LinkifyCompatTextAddedListener */
    private static class LinkifyCompatTextAddedListener extends LinkifyTextAddedListener {
        LinkifyCompatTextAddedListener(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        public boolean addLinks(Spannable spannable, int i) {
            return LinkifyCompat.addLinks(spannable, i);
        }
    }
}
