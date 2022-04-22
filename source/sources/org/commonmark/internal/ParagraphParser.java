package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

public class ParagraphParser extends AbstractBlockParser {
    private final Paragraph block = new Paragraph();
    private LinkReferenceDefinitionParser linkReferenceDefinitionParser = new LinkReferenceDefinitionParser();

    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        if (!parserState.isBlank()) {
            return BlockContinue.atIndex(parserState.getIndex());
        }
        return BlockContinue.none();
    }

    public void addLine(CharSequence charSequence) {
        this.linkReferenceDefinitionParser.parse(charSequence);
    }

    public void closeBlock() {
        if (this.linkReferenceDefinitionParser.getParagraphContent().length() == 0) {
            this.block.unlink();
        }
    }

    public void parseInlines(InlineParser inlineParser) {
        CharSequence paragraphContent = this.linkReferenceDefinitionParser.getParagraphContent();
        if (paragraphContent.length() > 0) {
            inlineParser.parse(paragraphContent.toString(), this.block);
        }
    }

    public CharSequence getContentString() {
        return this.linkReferenceDefinitionParser.getParagraphContent();
    }

    public List<LinkReferenceDefinition> getDefinitions() {
        return this.linkReferenceDefinitionParser.getDefinitions();
    }
}
