package org.commonmark.internal;

import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;

public class Delimiter implements DelimiterRun {
    public final boolean canClose;
    public final boolean canOpen;
    public final char delimiterChar;
    public int length = 1;
    public Delimiter next;
    public final Text node;
    public int originalLength = 1;
    public Delimiter previous;

    public Delimiter(Text text, char c, boolean z, boolean z2, Delimiter delimiter) {
        this.node = text;
        this.delimiterChar = c;
        this.canOpen = z;
        this.canClose = z2;
        this.previous = delimiter;
    }

    public boolean canOpen() {
        return this.canOpen;
    }

    public boolean canClose() {
        return this.canClose;
    }

    public int length() {
        return this.length;
    }

    public int originalLength() {
        return this.originalLength;
    }
}
