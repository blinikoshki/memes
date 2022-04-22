package p015io.noties.markwon;

import org.commonmark.node.SoftLineBreak;
import p015io.noties.markwon.MarkwonVisitor;

/* renamed from: io.noties.markwon.SoftBreakAddsNewLinePlugin */
public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {
    public static SoftBreakAddsNewLinePlugin create() {
        return new SoftBreakAddsNewLinePlugin();
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.mo23135on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() {
            public void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                markwonVisitor.ensureNewLine();
            }
        });
    }
}
