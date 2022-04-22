package org.commonmark.node;

public class ThematicBreak extends Block {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
