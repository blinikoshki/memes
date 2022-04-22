package org.commonmark.parser.block;

import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;

public abstract class AbstractBlockParser implements BlockParser {
    public void addLine(CharSequence charSequence) {
    }

    public boolean canContain(Block block) {
        return false;
    }

    public boolean canHaveLazyContinuationLines() {
        return false;
    }

    public void closeBlock() {
    }

    public boolean isContainer() {
        return false;
    }

    public void parseInlines(InlineParser inlineParser) {
    }
}
