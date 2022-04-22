package p015io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonPlugin;
import p015io.noties.markwon.MarkwonSpansFactory;
import p015io.noties.markwon.MarkwonVisitor;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.AbstractMarkwonPlugin */
public abstract class AbstractMarkwonPlugin implements MarkwonPlugin {
    public void afterRender(Node node, MarkwonVisitor markwonVisitor) {
    }

    public void afterSetText(TextView textView) {
    }

    public void beforeRender(Node node) {
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
    }

    public void configure(MarkwonPlugin.Registry registry) {
    }

    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
    }

    public void configureParser(Parser.Builder builder) {
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
    }

    public void configureTheme(MarkwonTheme.Builder builder) {
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
    }

    public String processMarkdown(String str) {
        return str;
    }
}
