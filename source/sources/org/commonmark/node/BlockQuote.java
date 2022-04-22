package org.commonmark.node;

public class BlockQuote extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
