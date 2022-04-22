package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class BlockQuoteParser extends AbstractBlockParser {
    private final BlockQuote block = new BlockQuote();

    public boolean canContain(Block block2) {
        return true;
    }

    public boolean isContainer() {
        return true;
    }

    public BlockQuote getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        if (!isMarker(parserState, nextNonSpaceIndex)) {
            return BlockContinue.none();
        }
        int column = parserState.getColumn() + parserState.getIndent() + 1;
        if (Parsing.isSpaceOrTab(parserState.getLine(), nextNonSpaceIndex + 1)) {
            column++;
        }
        return BlockContinue.atColumn(column);
    }

    /* access modifiers changed from: private */
    public static boolean isMarker(ParserState parserState, int i) {
        CharSequence line = parserState.getLine();
        return parserState.getIndent() < Parsing.CODE_BLOCK_INDENT && i < line.length() && line.charAt(i) == '>';
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            if (!BlockQuoteParser.isMarker(parserState, nextNonSpaceIndex)) {
                return BlockStart.none();
            }
            int column = parserState.getColumn() + parserState.getIndent() + 1;
            if (Parsing.isSpaceOrTab(parserState.getLine(), nextNonSpaceIndex + 1)) {
                column++;
            }
            return BlockStart.m221of(new BlockQuoteParser()).atColumn(column);
        }
    }
}
