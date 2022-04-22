package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class ThematicBreakParser extends AbstractBlockParser {
    private final ThematicBreak block = new ThematicBreak();

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.getIndent() >= 4) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            CharSequence line = parserState.getLine();
            if (!ThematicBreakParser.isThematicBreak(line, nextNonSpaceIndex)) {
                return BlockStart.none();
            }
            return BlockStart.m221of(new ThematicBreakParser()).atIndex(line.length());
        }
    }

    /* access modifiers changed from: private */
    public static boolean isThematicBreak(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (!(charAt == 9 || charAt == ' ')) {
                if (charAt == '*') {
                    i4++;
                } else if (charAt == '-') {
                    i2++;
                } else if (charAt != '_') {
                    return false;
                } else {
                    i3++;
                }
            }
            i++;
        }
        if ((i2 >= 3 && i3 == 0 && i4 == 0) || ((i3 >= 3 && i2 == 0 && i4 == 0) || (i4 >= 3 && i2 == 0 && i3 == 0))) {
            return true;
        }
        return false;
    }
}
