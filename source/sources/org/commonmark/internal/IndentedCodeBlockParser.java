package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class IndentedCodeBlockParser extends AbstractBlockParser {
    private final IndentedCodeBlock block = new IndentedCodeBlock();
    private final List<CharSequence> lines = new ArrayList();

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
            return BlockContinue.atColumn(parserState.getColumn() + Parsing.CODE_BLOCK_INDENT);
        }
        if (parserState.isBlank()) {
            return BlockContinue.atIndex(parserState.getNextNonSpaceIndex());
        }
        return BlockContinue.none();
    }

    public void addLine(CharSequence charSequence) {
        this.lines.add(charSequence);
    }

    public void closeBlock() {
        int size = this.lines.size() - 1;
        while (size >= 0 && Parsing.isBlank(this.lines.get(size))) {
            size--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size + 1; i++) {
            sb.append(this.lines.get(i));
            sb.append(10);
        }
        this.block.setLiteral(sb.toString());
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT || parserState.isBlank() || (parserState.getActiveBlockParser().getBlock() instanceof Paragraph)) {
                return BlockStart.none();
            }
            return BlockStart.m221of(new IndentedCodeBlockParser()).atColumn(parserState.getColumn() + Parsing.CODE_BLOCK_INDENT);
        }
    }
}
