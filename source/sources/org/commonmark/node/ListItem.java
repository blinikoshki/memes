package org.commonmark.node;

public class ListItem extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
