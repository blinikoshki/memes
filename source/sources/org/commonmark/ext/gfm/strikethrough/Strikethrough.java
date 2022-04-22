package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;

public class Strikethrough extends CustomNode implements Delimited {
    private static final String DELIMITER = "~~";

    public String getClosingDelimiter() {
        return DELIMITER;
    }

    public String getOpeningDelimiter() {
        return DELIMITER;
    }
}
