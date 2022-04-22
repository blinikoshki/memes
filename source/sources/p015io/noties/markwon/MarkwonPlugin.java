package p015io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonSpansFactory;
import p015io.noties.markwon.MarkwonVisitor;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.MarkwonPlugin */
public interface MarkwonPlugin {

    /* renamed from: io.noties.markwon.MarkwonPlugin$Action */
    public interface Action<P extends MarkwonPlugin> {
        void apply(P p);
    }

    /* renamed from: io.noties.markwon.MarkwonPlugin$Registry */
    public interface Registry {
        <P extends MarkwonPlugin> P require(Class<P> cls);

        <P extends MarkwonPlugin> void require(Class<P> cls, Action<? super P> action);
    }

    void afterRender(Node node, MarkwonVisitor markwonVisitor);

    void afterSetText(TextView textView);

    void beforeRender(Node node);

    void beforeSetText(TextView textView, Spanned spanned);

    void configure(Registry registry);

    void configureConfiguration(MarkwonConfiguration.Builder builder);

    void configureParser(Parser.Builder builder);

    void configureSpansFactory(MarkwonSpansFactory.Builder builder);

    void configureTheme(MarkwonTheme.Builder builder);

    void configureVisitor(MarkwonVisitor.Builder builder);

    String processMarkdown(String str);
}
