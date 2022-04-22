package org.commonmark.internal.renderer.text;

import org.commonmark.node.OrderedList;

public class OrderedListHolder extends ListHolder {
    private int counter;
    private final char delimiter;

    public OrderedListHolder(ListHolder listHolder, OrderedList orderedList) {
        super(listHolder);
        this.delimiter = orderedList.getDelimiter();
        this.counter = orderedList.getStartNumber();
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public int getCounter() {
        return this.counter;
    }

    public void increaseCounter() {
        this.counter++;
    }
}
