package org.commonmark.node;

public class StrongEmphasis extends Node implements Delimited {
    private String delimiter;

    public StrongEmphasis() {
    }

    public StrongEmphasis(String str) {
        this.delimiter = str;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public String getOpeningDelimiter() {
        return this.delimiter;
    }

    public String getClosingDelimiter() {
        return this.delimiter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
