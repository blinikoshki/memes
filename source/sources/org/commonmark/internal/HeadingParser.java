package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class HeadingParser extends AbstractBlockParser {
    private final Heading block;
    private final String content;

    public HeadingParser(int i, String str) {
        Heading heading = new Heading();
        this.block = heading;
        heading.setLevel(i);
        this.content = str;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }

    public void parseInlines(InlineParser inlineParser) {
        inlineParser.parse(this.content, this.block);
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            CharSequence paragraphContent;
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            CharSequence line = parserState.getLine();
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            HeadingParser access$000 = HeadingParser.getAtxHeading(line, nextNonSpaceIndex);
            if (access$000 != null) {
                return BlockStart.m221of(access$000).atIndex(line.length());
            }
            int access$100 = HeadingParser.getSetextHeadingLevel(line, nextNonSpaceIndex);
            if (access$100 <= 0 || (paragraphContent = matchedBlockParser.getParagraphContent()) == null) {
                return BlockStart.none();
            }
            return BlockStart.m221of(new HeadingParser(access$100, paragraphContent.toString())).atIndex(line.length()).replaceActiveBlockParser();
        }
    }

    /* access modifiers changed from: private */
    public static HeadingParser getAtxHeading(CharSequence charSequence, int i) {
        int skip = Parsing.skip('#', charSequence, i, charSequence.length()) - i;
        if (skip == 0 || skip > 6) {
            return null;
        }
        int i2 = i + skip;
        if (i2 >= charSequence.length()) {
            return new HeadingParser(skip, "");
        }
        char charAt = charSequence.charAt(i2);
        if (charAt != ' ' && charAt != 9) {
            return null;
        }
        int skipSpaceTabBackwards = Parsing.skipSpaceTabBackwards(charSequence, charSequence.length() - 1, i2);
        int skipBackwards = Parsing.skipBackwards('#', charSequence, skipSpaceTabBackwards, i2);
        int skipSpaceTabBackwards2 = Parsing.skipSpaceTabBackwards(charSequence, skipBackwards, i2);
        if (skipSpaceTabBackwards2 != skipBackwards) {
            return new HeadingParser(skip, charSequence.subSequence(i2, skipSpaceTabBackwards2 + 1).toString());
        }
        return new HeadingParser(skip, charSequence.subSequence(i2, skipSpaceTabBackwards + 1).toString());
    }

    /* access modifiers changed from: private */
    public static int getSetextHeadingLevel(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if (charAt != '-') {
            if (charAt != '=') {
                return 0;
            }
            if (isSetextHeadingRest(charSequence, i + 1, '=')) {
                return 1;
            }
        }
        return isSetextHeadingRest(charSequence, i + 1, '-') ? 2 : 0;
    }

    private static boolean isSetextHeadingRest(CharSequence charSequence, int i, char c) {
        return Parsing.skipSpaceTab(charSequence, Parsing.skip(c, charSequence, i, charSequence.length()), charSequence.length()) >= charSequence.length();
    }
}
