package org.commonmark.node;

public class LinkReferenceDefinition extends Node {
    private String destination;
    private String label;
    private String title;

    public LinkReferenceDefinition() {
    }

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.label = str;
        this.destination = str2;
        this.title = str3;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
