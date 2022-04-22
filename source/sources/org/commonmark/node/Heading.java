package org.commonmark.node;

public class Heading extends Block {
    private int level;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }
}
