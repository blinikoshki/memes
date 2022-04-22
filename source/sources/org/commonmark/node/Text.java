package org.commonmark.node;

public class Text extends Node {
    private String literal;

    public Text() {
    }

    public Text(String str) {
        this.literal = str;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }

    /* access modifiers changed from: protected */
    public String toStringAttributes() {
        return "literal=" + this.literal;
    }
}
