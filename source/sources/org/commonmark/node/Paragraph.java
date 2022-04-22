package org.commonmark.node;

public class Paragraph extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
