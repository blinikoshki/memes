package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class ListBlockParser extends AbstractBlockParser {
    private final ListBlock block;
    private boolean hadBlankLine;
    private int linesAfterBlank;

    public boolean isContainer() {
        return true;
    }

    public ListBlockParser(ListBlock listBlock) {
        this.block = listBlock;
    }

    public boolean canContain(Block block2) {
        if (!(block2 instanceof ListItem)) {
            return false;
        }
        if (this.hadBlankLine && this.linesAfterBlank == 1) {
            this.block.setTight(false);
            this.hadBlankLine = false;
        }
        return true;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        if (parserState.isBlank()) {
            this.hadBlankLine = true;
            this.linesAfterBlank = 0;
        } else if (this.hadBlankLine) {
            this.linesAfterBlank++;
        }
        return BlockContinue.atIndex(parserState.getIndex());
    }

    /* access modifiers changed from: private */
    public static ListData parseList(CharSequence charSequence, int i, int i2, boolean z) {
        ListMarkerData parseListMarker = parseListMarker(charSequence, i);
        if (parseListMarker == null) {
            return null;
        }
        ListBlock listBlock = parseListMarker.listBlock;
        int i3 = parseListMarker.indexAfterMarker;
        int i4 = i2 + (i3 - i);
        boolean z2 = false;
        int length = charSequence.length();
        int i5 = i4;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt != 9) {
                if (charAt != ' ') {
                    z2 = true;
                    break;
                }
                i5++;
            } else {
                i5 += Parsing.columnsToNextTabStop(i5);
            }
            i3++;
        }
        if (z && (((listBlock instanceof OrderedList) && ((OrderedList) listBlock).getStartNumber() != 1) || !z2)) {
            return null;
        }
        if (!z2 || i5 - i4 > Parsing.CODE_BLOCK_INDENT) {
            i5 = i4 + 1;
        }
        return new ListData(listBlock, i5);
    }

    private static ListMarkerData parseListMarker(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if (charAt != '*' && charAt != '+' && charAt != '-') {
            return parseOrderedList(charSequence, i);
        }
        int i2 = i + 1;
        if (!isSpaceTabOrEnd(charSequence, i2)) {
            return null;
        }
        BulletList bulletList = new BulletList();
        bulletList.setBulletMarker(charAt);
        return new ListMarkerData(bulletList, i2);
    }

    private static ListMarkerData parseOrderedList(CharSequence charSequence, int i) {
        char charAt;
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (true) {
            if (i3 < length) {
                charAt = charSequence.charAt(i3);
                if (charAt != ')' && charAt != '.') {
                    switch (charAt) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            i2++;
                            if (i2 > 9) {
                                return null;
                            }
                            i3++;
                        default:
                            return null;
                    }
                }
            }
        }
        if (i2 >= 1) {
            int i4 = i3 + 1;
            if (isSpaceTabOrEnd(charSequence, i4)) {
                String charSequence2 = charSequence.subSequence(i, i3).toString();
                OrderedList orderedList = new OrderedList();
                orderedList.setStartNumber(Integer.parseInt(charSequence2));
                orderedList.setDelimiter(charAt);
                return new ListMarkerData(orderedList, i4);
            }
        }
        return null;
    }

    private static boolean isSpaceTabOrEnd(CharSequence charSequence, int i) {
        char charAt;
        if (i >= charSequence.length() || (charAt = charSequence.charAt(i)) == 9 || charAt == ' ') {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean listsMatch(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return equals(Character.valueOf(((BulletList) listBlock).getBulletMarker()), Character.valueOf(((BulletList) listBlock2).getBulletMarker()));
        }
        if (!(listBlock instanceof OrderedList) || !(listBlock2 instanceof OrderedList)) {
            return false;
        }
        return equals(Character.valueOf(((OrderedList) listBlock).getDelimiter()), Character.valueOf(((OrderedList) listBlock2).getDelimiter()));
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser matchedBlockParser2 = matchedBlockParser.getMatchedBlockParser();
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            ListData access$000 = ListBlockParser.parseList(parserState.getLine(), parserState.getNextNonSpaceIndex(), parserState.getColumn() + parserState.getIndent(), matchedBlockParser.getParagraphContent() != null);
            if (access$000 == null) {
                return BlockStart.none();
            }
            int i = access$000.contentColumn;
            ListItemParser listItemParser = new ListItemParser(i - parserState.getColumn());
            if (!(matchedBlockParser2 instanceof ListBlockParser) || !ListBlockParser.listsMatch((ListBlock) matchedBlockParser2.getBlock(), access$000.listBlock)) {
                ListBlockParser listBlockParser = new ListBlockParser(access$000.listBlock);
                access$000.listBlock.setTight(true);
                return BlockStart.m221of(listBlockParser, listItemParser).atColumn(i);
            }
            return BlockStart.m221of(listItemParser).atColumn(i);
        }
    }

    private static class ListData {
        final int contentColumn;
        final ListBlock listBlock;

        ListData(ListBlock listBlock2, int i) {
            this.listBlock = listBlock2;
            this.contentColumn = i;
        }
    }

    private static class ListMarkerData {
        final int indexAfterMarker;
        final ListBlock listBlock;

        ListMarkerData(ListBlock listBlock2, int i) {
            this.listBlock = listBlock2;
            this.indexAfterMarker = i;
        }
    }
}
