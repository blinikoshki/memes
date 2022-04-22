package org.commonmark.internal;

class BlockContent {
    private int lineCount;

    /* renamed from: sb */
    private final StringBuilder f478sb;

    public BlockContent() {
        this.lineCount = 0;
        this.f478sb = new StringBuilder();
    }

    public BlockContent(String str) {
        this.lineCount = 0;
        this.f478sb = new StringBuilder(str);
    }

    public void add(CharSequence charSequence) {
        if (this.lineCount != 0) {
            this.f478sb.append(10);
        }
        this.f478sb.append(charSequence);
        this.lineCount++;
    }

    public String getString() {
        return this.f478sb.toString();
    }
}
