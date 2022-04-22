package p015io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import p015io.noties.markwon.Markwon;

/* renamed from: io.noties.markwon.MarkwonImpl */
class MarkwonImpl extends Markwon {
    private final TextView.BufferType bufferType;
    private final MarkwonConfiguration configuration;
    private final boolean fallbackToRawInputWhenEmpty;
    private final Parser parser;
    /* access modifiers changed from: private */
    public final List<MarkwonPlugin> plugins;
    private final Markwon.TextSetter textSetter;
    private final MarkwonVisitorFactory visitorFactory;

    MarkwonImpl(TextView.BufferType bufferType2, Markwon.TextSetter textSetter2, Parser parser2, MarkwonVisitorFactory markwonVisitorFactory, MarkwonConfiguration markwonConfiguration, List<MarkwonPlugin> list, boolean z) {
        this.bufferType = bufferType2;
        this.textSetter = textSetter2;
        this.parser = parser2;
        this.visitorFactory = markwonVisitorFactory;
        this.configuration = markwonConfiguration;
        this.plugins = list;
        this.fallbackToRawInputWhenEmpty = z;
    }

    public Node parse(String str) {
        for (MarkwonPlugin processMarkdown : this.plugins) {
            str = processMarkdown.processMarkdown(str);
        }
        return this.parser.parse(str);
    }

    public Spanned render(Node node) {
        for (MarkwonPlugin beforeRender : this.plugins) {
            beforeRender.beforeRender(node);
        }
        MarkwonVisitor create = this.visitorFactory.create();
        node.accept(create);
        for (MarkwonPlugin afterRender : this.plugins) {
            afterRender.afterRender(node, create);
        }
        return create.builder().spannableStringBuilder();
    }

    public Spanned toMarkdown(String str) {
        Spanned render = render(parse(str));
        return (!TextUtils.isEmpty(render) || !this.fallbackToRawInputWhenEmpty || TextUtils.isEmpty(str)) ? render : new SpannableStringBuilder(str);
    }

    public void setMarkdown(TextView textView, String str) {
        setParsedMarkdown(textView, toMarkdown(str));
    }

    public void setParsedMarkdown(final TextView textView, Spanned spanned) {
        for (MarkwonPlugin beforeSetText : this.plugins) {
            beforeSetText.beforeSetText(textView, spanned);
        }
        Markwon.TextSetter textSetter2 = this.textSetter;
        if (textSetter2 != null) {
            textSetter2.setText(textView, spanned, this.bufferType, new Runnable() {
                public void run() {
                    for (MarkwonPlugin afterSetText : MarkwonImpl.this.plugins) {
                        afterSetText.afterSetText(textView);
                    }
                }
            });
            return;
        }
        textView.setText(spanned, this.bufferType);
        for (MarkwonPlugin afterSetText : this.plugins) {
            afterSetText.afterSetText(textView);
        }
    }

    public boolean hasPlugin(Class<? extends MarkwonPlugin> cls) {
        return getPlugin(cls) != null;
    }

    public <P extends MarkwonPlugin> P getPlugin(Class<P> cls) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        P p = null;
        while (it.hasNext()) {
            P p2 = (MarkwonPlugin) it.next();
            if (cls.isAssignableFrom(p2.getClass())) {
                p = p2;
            }
        }
        return p;
    }

    public <P extends MarkwonPlugin> P requirePlugin(Class<P> cls) {
        P plugin = getPlugin(cls);
        if (plugin != null) {
            return plugin;
        }
        throw new IllegalStateException(String.format(Locale.US, "Requested plugin `%s` is not registered with this Markwon instance", new Object[]{cls.getName()}));
    }

    public List<? extends MarkwonPlugin> getPlugins() {
        return Collections.unmodifiableList(this.plugins);
    }

    public MarkwonConfiguration configuration() {
        return this.configuration;
    }
}
