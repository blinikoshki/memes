package org.commonmark.node;

public class SoftLineBreak extends Node {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
