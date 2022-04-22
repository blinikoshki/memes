package org.commonmark.node;

public class Link extends Node {
    private String destination;
    private String title;

    public Link() {
    }

    public Link(String str, String str2) {
        this.destination = str;
        this.title = str2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    /* access modifiers changed from: protected */
    public String toStringAttributes() {
        return "destination=" + this.destination + ", title=" + this.title;
    }
}
