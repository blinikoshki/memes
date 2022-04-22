package org.commonmark.internal.renderer.text;

import org.commonmark.node.BulletList;

public class BulletListHolder extends ListHolder {
    private final char marker;

    public BulletListHolder(ListHolder listHolder, BulletList bulletList) {
        super(listHolder);
        this.marker = bulletList.getBulletMarker();
    }

    public char getMarker() {
        return this.marker;
    }
}
