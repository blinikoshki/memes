package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

public class ListItemParser extends AbstractBlockParser {
    private final ListItem block = new ListItem();
    private int contentIndent;
    private boolean hadBlankLine;

    public boolean isContainer() {
        return true;
    }

    public ListItemParser(int i) {
        this.contentIndent = i;
    }

    public boolean canContain(Block block2) {
        if (!this.hadBlankLine) {
            return true;
        }
        Block parent = this.block.getParent();
        if (!(parent instanceof ListBlock)) {
            return true;
        }
        ((ListBlock) parent).setTight(false);
        return true;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        if (parserState.isBlank()) {
            if (this.block.getFirstChild() == null) {
                return BlockContinue.none();
            }
            Block block2 = parserState.getActiveBlockParser().getBlock();
            this.hadBlankLine = (block2 instanceof Paragraph) || (block2 instanceof ListItem);
            return BlockContinue.atIndex(parserState.getNextNonSpaceIndex());
        } else if (parserState.getIndent() >= this.contentIndent) {
            return BlockContinue.atColumn(parserState.getColumn() + this.contentIndent);
        } else {
            return BlockContinue.none();
        }
    }
}
