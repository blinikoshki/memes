package org.commonmark.node;

public abstract class CustomBlock extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
