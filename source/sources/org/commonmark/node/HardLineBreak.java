package org.commonmark.node;

public class HardLineBreak extends Node {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
