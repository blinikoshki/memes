package p015io.noties.markwon;

import org.commonmark.node.Node;
import p015io.noties.markwon.MarkwonVisitor;

/* renamed from: io.noties.markwon.BlockHandlerDef */
public class BlockHandlerDef implements MarkwonVisitor.BlockHandler {
    public void blockStart(MarkwonVisitor markwonVisitor, Node node) {
        markwonVisitor.ensureNewLine();
    }

    public void blockEnd(MarkwonVisitor markwonVisitor, Node node) {
        if (markwonVisitor.hasNext(node)) {
            markwonVisitor.ensureNewLine();
            markwonVisitor.forceNewLine();
        }
    }
}
