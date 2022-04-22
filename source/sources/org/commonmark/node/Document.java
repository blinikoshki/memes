package org.commonmark.node;

public class Document extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
