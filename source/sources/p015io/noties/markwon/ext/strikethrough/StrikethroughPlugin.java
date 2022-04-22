package p015io.noties.markwon.ext.strikethrough;

import android.text.style.StrikethroughSpan;
import java.util.Collections;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.parser.Parser;
import p015io.noties.markwon.AbstractMarkwonPlugin;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonSpansFactory;
import p015io.noties.markwon.MarkwonVisitor;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;

/* renamed from: io.noties.markwon.ext.strikethrough.StrikethroughPlugin */
public class StrikethroughPlugin extends AbstractMarkwonPlugin {
    public static StrikethroughPlugin create() {
        return new StrikethroughPlugin();
    }

    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(StrikethroughExtension.create()));
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.setFactory(Strikethrough.class, new SpanFactory() {
            public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                return new StrikethroughSpan();
            }
        });
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Strikethrough.class, new MarkwonVisitor.NodeVisitor<Strikethrough>() {
            public void visit(MarkwonVisitor markwonVisitor, Strikethrough strikethrough) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(strikethrough);
                markwonVisitor.setSpansForNodeOptional(strikethrough, length);
            }
        });
    }
}
