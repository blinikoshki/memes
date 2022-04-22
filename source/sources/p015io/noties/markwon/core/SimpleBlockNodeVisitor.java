package p015io.noties.markwon.core;

import org.commonmark.node.Node;
import p015io.noties.markwon.MarkwonVisitor;

/* renamed from: io.noties.markwon.core.SimpleBlockNodeVisitor */
public class SimpleBlockNodeVisitor implements MarkwonVisitor.NodeVisitor<Node> {
    public void visit(MarkwonVisitor markwonVisitor, Node node) {
        markwonVisitor.blockStart(node);
        int length = markwonVisitor.length();
        markwonVisitor.visitChildren(node);
        markwonVisitor.setSpansForNodeOptional(node, length);
        markwonVisitor.blockEnd(node);
    }
}
