package org.commonmark.node;

public abstract class AbstractVisitor implements Visitor {
    public void visit(BlockQuote blockQuote) {
        visitChildren(blockQuote);
    }

    public void visit(BulletList bulletList) {
        visitChildren(bulletList);
    }

    public void visit(Code code) {
        visitChildren(code);
    }

    public void visit(Document document) {
        visitChildren(document);
    }

    public void visit(Emphasis emphasis) {
        visitChildren(emphasis);
    }

    public void visit(FencedCodeBlock fencedCodeBlock) {
        visitChildren(fencedCodeBlock);
    }

    public void visit(HardLineBreak hardLineBreak) {
        visitChildren(hardLineBreak);
    }

    public void visit(Heading heading) {
        visitChildren(heading);
    }

    public void visit(ThematicBreak thematicBreak) {
        visitChildren(thematicBreak);
    }

    public void visit(HtmlInline htmlInline) {
        visitChildren(htmlInline);
    }

    public void visit(HtmlBlock htmlBlock) {
        visitChildren(htmlBlock);
    }

    public void visit(Image image) {
        visitChildren(image);
    }

    public void visit(IndentedCodeBlock indentedCodeBlock) {
        visitChildren(indentedCodeBlock);
    }

    public void visit(Link link) {
        visitChildren(link);
    }

    public void visit(ListItem listItem) {
        visitChildren(listItem);
    }

    public void visit(OrderedList orderedList) {
        visitChildren(orderedList);
    }

    public void visit(Paragraph paragraph) {
        visitChildren(paragraph);
    }

    public void visit(SoftLineBreak softLineBreak) {
        visitChildren(softLineBreak);
    }

    public void visit(StrongEmphasis strongEmphasis) {
        visitChildren(strongEmphasis);
    }

    public void visit(Text text) {
        visitChildren(text);
    }

    public void visit(LinkReferenceDefinition linkReferenceDefinition) {
        visitChildren(linkReferenceDefinition);
    }

    public void visit(CustomBlock customBlock) {
        visitChildren(customBlock);
    }

    public void visit(CustomNode customNode) {
        visitChildren(customNode);
    }

    /* access modifiers changed from: protected */
    public void visitChildren(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(this);
            firstChild = next;
        }
    }
}
