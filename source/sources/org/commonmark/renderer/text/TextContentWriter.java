package org.commonmark.renderer.text;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class TextContentWriter {
    private final Appendable buffer;
    private char lastChar;

    public TextContentWriter(Appendable appendable) {
        this.buffer = appendable;
    }

    public void whitespace() {
        char c = this.lastChar;
        if (c != 0 && c != ' ') {
            append(' ');
        }
    }

    public void colon() {
        char c = this.lastChar;
        if (c != 0 && c != ':') {
            append(':');
        }
    }

    public void line() {
        char c = this.lastChar;
        if (c != 0 && c != 10) {
            append(10);
        }
    }

    public void writeStripped(String str) {
        append(str.replaceAll("[\\r\\n\\s]+", StringUtils.SPACE));
    }

    public void write(String str) {
        append(str);
    }

    public void write(char c) {
        append(c);
    }

    private void append(String str) {
        try {
            this.buffer.append(str);
            int length = str.length();
            if (length != 0) {
                this.lastChar = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void append(char c) {
        try {
            this.buffer.append(c);
            this.lastChar = c;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
