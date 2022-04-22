package org.commonmark.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.parser.delimiter.DelimiterProcessor;

public class DocumentParser implements ParserState {
    private static final Set<Class<? extends Block>> CORE_FACTORY_TYPES = new LinkedHashSet(Arrays.asList(new Class[]{BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class}));
    private static final Map<Class<? extends Block>, BlockParserFactory> NODES_TO_CORE_FACTORIES;
    private List<BlockParser> activeBlockParsers = new ArrayList();
    private Set<BlockParser> allBlockParsers = new LinkedHashSet();
    private boolean blank;
    private final List<BlockParserFactory> blockParserFactories;
    private int column = 0;
    private boolean columnIsInTab;
    private final Map<String, LinkReferenceDefinition> definitions = new LinkedHashMap();
    private final List<DelimiterProcessor> delimiterProcessors;
    private final DocumentBlockParser documentBlockParser;
    private int indent = 0;
    private int index = 0;
    private final InlineParserFactory inlineParserFactory;
    private CharSequence line;
    private int nextNonSpace = 0;
    private int nextNonSpaceColumn = 0;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(BlockQuote.class, new BlockQuoteParser.Factory());
        hashMap.put(Heading.class, new HeadingParser.Factory());
        hashMap.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        hashMap.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        hashMap.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        hashMap.put(ListBlock.class, new ListBlockParser.Factory());
        hashMap.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        NODES_TO_CORE_FACTORIES = Collections.unmodifiableMap(hashMap);
    }

    public DocumentParser(List<BlockParserFactory> list, InlineParserFactory inlineParserFactory2, List<DelimiterProcessor> list2) {
        this.blockParserFactories = list;
        this.inlineParserFactory = inlineParserFactory2;
        this.delimiterProcessors = list2;
        DocumentBlockParser documentBlockParser2 = new DocumentBlockParser();
        this.documentBlockParser = documentBlockParser2;
        activateBlockParser(documentBlockParser2);
    }

    public static Set<Class<? extends Block>> getDefaultBlockParserTypes() {
        return CORE_FACTORY_TYPES;
    }

    public static List<BlockParserFactory> calculateBlockParserFactories(List<BlockParserFactory> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (Class<? extends Block> cls : set) {
            arrayList.add(NODES_TO_CORE_FACTORIES.get(cls));
        }
        return arrayList;
    }

    public Document parse(String str) {
        int i = 0;
        while (true) {
            int findLineBreak = Parsing.findLineBreak(str, i);
            if (findLineBreak == -1) {
                break;
            }
            incorporateLine(str.substring(i, findLineBreak));
            i = findLineBreak + 1;
            if (i < str.length() && str.charAt(findLineBreak) == 13 && str.charAt(i) == 10) {
                i = findLineBreak + 2;
            }
        }
        if (str.length() > 0 && (i == 0 || i < str.length())) {
            incorporateLine(str.substring(i));
        }
        return finalizeAndProcess();
    }

    public Document parse(Reader reader) throws IOException {
        BufferedReader bufferedReader;
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader);
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return finalizeAndProcess();
            }
            incorporateLine(readLine);
        }
    }

    public CharSequence getLine() {
        return this.line;
    }

    public int getIndex() {
        return this.index;
    }

    public int getNextNonSpaceIndex() {
        return this.nextNonSpace;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndent() {
        return this.indent;
    }

    public boolean isBlank() {
        return this.blank;
    }

    public BlockParser getActiveBlockParser() {
        List<BlockParser> list = this.activeBlockParsers;
        return list.get(list.size() - 1);
    }

    private void incorporateLine(CharSequence charSequence) {
        this.line = Parsing.prepareLine(charSequence);
        this.index = 0;
        this.column = 0;
        this.columnIsInTab = false;
        List<BlockParser> list = this.activeBlockParsers;
        int i = 1;
        for (BlockParser next : list.subList(1, list.size())) {
            findNextNonSpace();
            BlockContinue tryContinue = next.tryContinue(this);
            if (!(tryContinue instanceof BlockContinueImpl)) {
                break;
            }
            BlockContinueImpl blockContinueImpl = (BlockContinueImpl) tryContinue;
            if (blockContinueImpl.isFinalize()) {
                finalize(next);
                return;
            }
            if (blockContinueImpl.getNewIndex() != -1) {
                setNewIndex(blockContinueImpl.getNewIndex());
            } else if (blockContinueImpl.getNewColumn() != -1) {
                setNewColumn(blockContinueImpl.getNewColumn());
            }
            i++;
        }
        List<BlockParser> list2 = this.activeBlockParsers;
        ArrayList arrayList = new ArrayList(list2.subList(i, list2.size()));
        BlockParser blockParser = this.activeBlockParsers.get(i - 1);
        boolean isEmpty = arrayList.isEmpty();
        boolean z = (blockParser.getBlock() instanceof Paragraph) || blockParser.isContainer();
        while (true) {
            if (!z) {
                break;
            }
            findNextNonSpace();
            if (isBlank() || (this.indent < Parsing.CODE_BLOCK_INDENT && Parsing.isLetter(this.line, this.nextNonSpace))) {
                setNewIndex(this.nextNonSpace);
            } else {
                BlockStartImpl findBlockStart = findBlockStart(blockParser);
                if (findBlockStart == null) {
                    setNewIndex(this.nextNonSpace);
                    break;
                }
                if (!isEmpty) {
                    finalizeBlocks(arrayList);
                    isEmpty = true;
                }
                if (findBlockStart.getNewIndex() != -1) {
                    setNewIndex(findBlockStart.getNewIndex());
                } else if (findBlockStart.getNewColumn() != -1) {
                    setNewColumn(findBlockStart.getNewColumn());
                }
                if (findBlockStart.isReplaceActiveBlockParser()) {
                    prepareActiveBlockParserForReplacement();
                }
                BlockParser[] blockParsers = findBlockStart.getBlockParsers();
                int length = blockParsers.length;
                int i2 = 0;
                while (i2 < length) {
                    BlockParser blockParser2 = blockParsers[i2];
                    i2++;
                    BlockParser addChild = addChild(blockParser2);
                    z = blockParser2.isContainer();
                    blockParser = addChild;
                }
            }
        }
        if (isEmpty || isBlank() || !getActiveBlockParser().canHaveLazyContinuationLines()) {
            if (!isEmpty) {
                finalizeBlocks(arrayList);
            }
            if (!blockParser.isContainer()) {
                addLine();
            } else if (!isBlank()) {
                addChild(new ParagraphParser());
                addLine();
            }
        } else {
            addLine();
        }
    }

    private void findNextNonSpace() {
        int i = this.index;
        int i2 = this.column;
        this.blank = true;
        int length = this.line.length();
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = this.line.charAt(i);
            if (charAt == 9) {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (charAt != ' ') {
                this.blank = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.nextNonSpace = i;
        this.nextNonSpaceColumn = i2;
        this.indent = i2 - this.column;
    }

    private void setNewIndex(int i) {
        int i2 = this.nextNonSpace;
        if (i >= i2) {
            this.index = i2;
            this.column = this.nextNonSpaceColumn;
        }
        int length = this.line.length();
        while (true) {
            int i3 = this.index;
            if (i3 >= i || i3 == length) {
                this.columnIsInTab = false;
            } else {
                advance();
            }
        }
        this.columnIsInTab = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setNewColumn(int r4) {
        /*
            r3 = this;
            int r0 = r3.nextNonSpaceColumn
            if (r4 < r0) goto L_0x000a
            int r1 = r3.nextNonSpace
            r3.index = r1
            r3.column = r0
        L_0x000a:
            java.lang.CharSequence r0 = r3.line
            int r0 = r0.length()
        L_0x0010:
            int r1 = r3.column
            if (r1 >= r4) goto L_0x001c
            int r2 = r3.index
            if (r2 == r0) goto L_0x001c
            r3.advance()
            goto L_0x0010
        L_0x001c:
            if (r1 <= r4) goto L_0x0029
            int r0 = r3.index
            r1 = 1
            int r0 = r0 - r1
            r3.index = r0
            r3.column = r4
            r3.columnIsInTab = r1
            goto L_0x002c
        L_0x0029:
            r4 = 0
            r3.columnIsInTab = r4
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.DocumentParser.setNewColumn(int):void");
    }

    private void advance() {
        if (this.line.charAt(this.index) == 9) {
            this.index++;
            int i = this.column;
            this.column = i + Parsing.columnsToNextTabStop(i);
            return;
        }
        this.index++;
        this.column++;
    }

    private void addLine() {
        CharSequence charSequence;
        if (this.columnIsInTab) {
            CharSequence charSequence2 = this.line;
            CharSequence subSequence = charSequence2.subSequence(this.index + 1, charSequence2.length());
            int columnsToNextTabStop = Parsing.columnsToNextTabStop(this.column);
            StringBuilder sb = new StringBuilder(subSequence.length() + columnsToNextTabStop);
            for (int i = 0; i < columnsToNextTabStop; i++) {
                sb.append(' ');
            }
            sb.append(subSequence);
            charSequence = sb.toString();
        } else {
            CharSequence charSequence3 = this.line;
            charSequence = charSequence3.subSequence(this.index, charSequence3.length());
        }
        getActiveBlockParser().addLine(charSequence);
    }

    private BlockStartImpl findBlockStart(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        for (BlockParserFactory tryStart : this.blockParserFactories) {
            BlockStart tryStart2 = tryStart.tryStart(this, matchedBlockParserImpl);
            if (tryStart2 instanceof BlockStartImpl) {
                return (BlockStartImpl) tryStart2;
            }
        }
        return null;
    }

    private void finalize(BlockParser blockParser) {
        if (getActiveBlockParser() == blockParser) {
            deactivateBlockParser();
        }
        if (blockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) blockParser);
        }
        blockParser.closeBlock();
    }

    private void addDefinitionsFrom(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition next : paragraphParser.getDefinitions()) {
            paragraphParser.getBlock().insertBefore(next);
            String label = next.getLabel();
            if (!this.definitions.containsKey(label)) {
                this.definitions.put(label, next);
            }
        }
    }

    private void processInlines() {
        InlineParser create = this.inlineParserFactory.create(new InlineParserContextImpl(this.delimiterProcessors, this.definitions));
        for (BlockParser parseInlines : this.allBlockParsers) {
            parseInlines.parseInlines(create);
        }
    }

    private <T extends BlockParser> T addChild(T t) {
        while (!getActiveBlockParser().canContain(t.getBlock())) {
            finalize(getActiveBlockParser());
        }
        getActiveBlockParser().getBlock().appendChild(t.getBlock());
        activateBlockParser(t);
        return t;
    }

    private void activateBlockParser(BlockParser blockParser) {
        this.activeBlockParsers.add(blockParser);
        this.allBlockParsers.add(blockParser);
    }

    private void deactivateBlockParser() {
        List<BlockParser> list = this.activeBlockParsers;
        list.remove(list.size() - 1);
    }

    private void prepareActiveBlockParserForReplacement() {
        BlockParser activeBlockParser = getActiveBlockParser();
        deactivateBlockParser();
        this.allBlockParsers.remove(activeBlockParser);
        if (activeBlockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) activeBlockParser);
        }
        activeBlockParser.getBlock().unlink();
    }

    private void finalizeBlocks(List<BlockParser> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            finalize(list.get(size));
        }
    }

    private Document finalizeAndProcess() {
        finalizeBlocks(this.activeBlockParsers);
        processInlines();
        return this.documentBlockParser.getBlock();
    }

    private static class MatchedBlockParserImpl implements MatchedBlockParser {
        private final BlockParser matchedBlockParser;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.matchedBlockParser = blockParser;
        }

        public BlockParser getMatchedBlockParser() {
            return this.matchedBlockParser;
        }

        public CharSequence getParagraphContent() {
            BlockParser blockParser = this.matchedBlockParser;
            if (!(blockParser instanceof ParagraphParser)) {
                return null;
            }
            CharSequence contentString = ((ParagraphParser) blockParser).getContentString();
            if (contentString.length() == 0) {
                return null;
            }
            return contentString;
        }
    }
}
