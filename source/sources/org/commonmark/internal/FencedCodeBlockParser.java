package org.commonmark.internal;

import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class FencedCodeBlockParser extends AbstractBlockParser {
    /* access modifiers changed from: private */
    public final FencedCodeBlock block;
    private String firstLine;
    private StringBuilder otherLines = new StringBuilder();

    public FencedCodeBlockParser(char c, int i, int i2) {
        FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
        this.block = fencedCodeBlock;
        fencedCodeBlock.setFenceChar(c);
        fencedCodeBlock.setFenceLength(i);
        fencedCodeBlock.setFenceIndent(i2);
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        int index = parserState.getIndex();
        CharSequence line = parserState.getLine();
        if (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT && isClosing(line, nextNonSpaceIndex)) {
            return BlockContinue.finished();
        }
        int length = line.length();
        for (int fenceIndent = this.block.getFenceIndent(); fenceIndent > 0 && index < length && line.charAt(index) == ' '; fenceIndent--) {
            index++;
        }
        return BlockContinue.atIndex(index);
    }

    public void addLine(CharSequence charSequence) {
        if (this.firstLine == null) {
            this.firstLine = charSequence.toString();
            return;
        }
        this.otherLines.append(charSequence);
        this.otherLines.append(10);
    }

    public void closeBlock() {
        this.block.setInfo(Escaping.unescapeString(this.firstLine.trim()));
        this.block.setLiteral(this.otherLines.toString());
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int indent = parserState.getIndent();
            if (indent >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            FencedCodeBlockParser access$000 = FencedCodeBlockParser.checkOpener(parserState.getLine(), nextNonSpaceIndex, indent);
            if (access$000 == null) {
                return BlockStart.none();
            }
            return BlockStart.m221of(access$000).atIndex(nextNonSpaceIndex + access$000.block.getFenceLength());
        }
    }

    /* access modifiers changed from: private */
    public static FencedCodeBlockParser checkOpener(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = i; i5 < length; i5++) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '`') {
                i3++;
            } else if (charAt != '~') {
                break;
            } else {
                i4++;
            }
        }
        if (i3 < 3 || i4 != 0) {
            if (i4 < 3 || i3 != 0) {
                return null;
            }
            return new FencedCodeBlockParser('~', i4, i2);
        } else if (Parsing.find('`', charSequence, i + i3) != -1) {
            return null;
        } else {
            return new FencedCodeBlockParser('`', i3, i2);
        }
    }

    private boolean isClosing(CharSequence charSequence, int i) {
        char fenceChar = this.block.getFenceChar();
        int fenceLength = this.block.getFenceLength();
        int skip = Parsing.skip(fenceChar, charSequence, i, charSequence.length()) - i;
        if (skip >= fenceLength && Parsing.skipSpaceTab(charSequence, i + skip, charSequence.length()) == charSequence.length()) {
            return true;
        }
        return false;
    }
}
