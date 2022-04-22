package org.commonmark.node;

public abstract class Block extends Node {
    public Block getParent() {
        return (Block) super.getParent();
    }

    /* access modifiers changed from: protected */
    public void setParent(Node node) {
        if (node instanceof Block) {
            super.setParent(node);
            return;
        }
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
