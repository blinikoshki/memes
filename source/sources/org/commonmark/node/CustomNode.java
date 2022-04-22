package org.commonmark.node;

public abstract class CustomNode extends Node {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
