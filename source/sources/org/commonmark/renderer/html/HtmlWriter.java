package org.commonmark.renderer.html;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.internal.util.Escaping;

public class HtmlWriter {
    private static final Map<String, String> NO_ATTRIBUTES = Collections.emptyMap();
    private final Appendable buffer;
    private char lastChar = 0;

    public HtmlWriter(Appendable appendable) {
        Objects.requireNonNull(appendable, "out must not be null");
        this.buffer = appendable;
    }

    public void raw(String str) {
        append(str);
    }

    public void text(String str) {
        append(Escaping.escapeHtml(str));
    }

    public void tag(String str) {
        tag(str, NO_ATTRIBUTES);
    }

    public void tag(String str, Map<String, String> map) {
        tag(str, map, false);
    }

    public void tag(String str, Map<String, String> map, boolean z) {
        append("<");
        append(str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                append(StringUtils.SPACE);
                append(Escaping.escapeHtml((String) next.getKey()));
                append("=\"");
                append(Escaping.escapeHtml((String) next.getValue()));
                append("\"");
            }
        }
        if (z) {
            append(" /");
        }
        append(">");
    }

    public void line() {
        char c = this.lastChar;
        if (c != 0 && c != 10) {
            append(StringUtils.f466LF);
        }
    }

    /* access modifiers changed from: protected */
    public void append(String str) {
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
}
