package org.commonmark.internal;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

public class InlineParserImpl implements InlineParser {
    private static final String ASCII_PUNCTUATION = "!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~";
    private static final Pattern AUTOLINK = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    private static final String CDATA = "<!\\[CDATA\\[[\\s\\S]*?\\]\\]>";
    private static final String DECLARATION = "<![A-Z]+\\s+[^>]*>";
    private static final Pattern EMAIL_AUTOLINK = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern ENTITY_HERE = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern ESCAPABLE = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    private static final Pattern FINAL_SPACE = Pattern.compile(" *$");
    private static final String HTMLCOMMENT = "<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->";
    private static final String HTMLTAG = "(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)";
    private static final Pattern HTML_TAG = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    private static final String PROCESSINGINSTRUCTION = "[<][?].*?[?][>]";
    private static final Pattern PUNCTUATION = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern SPNL = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern TICKS = Pattern.compile("`+");
    private static final Pattern TICKS_HERE = Pattern.compile("^`+");
    private static final Pattern UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
    private final InlineParserContext context;
    private final BitSet delimiterCharacters;
    private final Map<Character, DelimiterProcessor> delimiterProcessors;
    private int index;
    private String input;
    private Bracket lastBracket;
    private Delimiter lastDelimiter;
    private final BitSet specialCharacters;

    public InlineParserImpl(InlineParserContext inlineParserContext) {
        Map<Character, DelimiterProcessor> calculateDelimiterProcessors = calculateDelimiterProcessors(inlineParserContext.getCustomDelimiterProcessors());
        this.delimiterProcessors = calculateDelimiterProcessors;
        BitSet calculateDelimiterCharacters = calculateDelimiterCharacters(calculateDelimiterProcessors.keySet());
        this.delimiterCharacters = calculateDelimiterCharacters;
        this.specialCharacters = calculateSpecialCharacters(calculateDelimiterCharacters);
        this.context = inlineParserContext;
    }

    public static BitSet calculateDelimiterCharacters(Set<Character> set) {
        BitSet bitSet = new BitSet();
        for (Character charValue : set) {
            bitSet.set(charValue.charValue());
        }
        return bitSet;
    }

    public static BitSet calculateSpecialCharacters(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    public static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(List<DelimiterProcessor> list) {
        HashMap hashMap = new HashMap();
        addDelimiterProcessors(Arrays.asList(new DelimiterProcessor[]{new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()}), hashMap);
        addDelimiterProcessors(list, hashMap);
        return hashMap;
    }

    private static void addDelimiterProcessors(Iterable<DelimiterProcessor> iterable, Map<Character, DelimiterProcessor> map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        for (DelimiterProcessor next : iterable) {
            char openingCharacter = next.getOpeningCharacter();
            char closingCharacter = next.getClosingCharacter();
            if (openingCharacter == closingCharacter) {
                DelimiterProcessor delimiterProcessor = map.get(Character.valueOf(openingCharacter));
                if (delimiterProcessor == null || delimiterProcessor.getOpeningCharacter() != delimiterProcessor.getClosingCharacter()) {
                    addDelimiterProcessorForChar(openingCharacter, next, map);
                } else {
                    if (delimiterProcessor instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor;
                    } else {
                        StaggeredDelimiterProcessor staggeredDelimiterProcessor2 = new StaggeredDelimiterProcessor(openingCharacter);
                        staggeredDelimiterProcessor2.add(delimiterProcessor);
                        staggeredDelimiterProcessor = staggeredDelimiterProcessor2;
                    }
                    staggeredDelimiterProcessor.add(next);
                    map.put(Character.valueOf(openingCharacter), staggeredDelimiterProcessor);
                }
            } else {
                addDelimiterProcessorForChar(openingCharacter, next, map);
                addDelimiterProcessorForChar(closingCharacter, next, map);
            }
        }
    }

    private static void addDelimiterProcessorForChar(char c, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        if (map.put(Character.valueOf(c), delimiterProcessor) != null) {
            throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c + "'");
        }
    }

    public void parse(String str, Node node) {
        reset(str.trim());
        Node node2 = null;
        while (true) {
            node2 = parseInline(node2);
            if (node2 != null) {
                node.appendChild(node2);
            } else {
                processDelimiters((Delimiter) null);
                mergeChildTextNodes(node);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void reset(String str) {
        this.input = str;
        this.index = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
    }

    private Text text(String str, int i, int i2) {
        return new Text(str.substring(i, i2));
    }

    private Text text(String str) {
        return new Text(str);
    }

    private Node parseInline(Node node) {
        Node node2;
        char peek = peek();
        if (peek == 0) {
            return null;
        }
        if (peek == 10) {
            node2 = parseNewline(node);
        } else if (peek == '!') {
            node2 = parseBang();
        } else if (peek == '&') {
            node2 = parseEntity();
        } else if (peek == '<') {
            node2 = parseAutolink();
            if (node2 == null) {
                node2 = parseHtmlInline();
            }
        } else if (peek != '`') {
            switch (peek) {
                case '[':
                    node2 = parseOpenBracket();
                    break;
                case '\\':
                    node2 = parseBackslash();
                    break;
                case ']':
                    node2 = parseCloseBracket();
                    break;
                default:
                    if (!this.delimiterCharacters.get(peek)) {
                        node2 = parseString();
                        break;
                    } else {
                        node2 = parseDelimiters(this.delimiterProcessors.get(Character.valueOf(peek)), peek);
                        break;
                    }
            }
        } else {
            node2 = parseBackticks();
        }
        if (node2 != null) {
            return node2;
        }
        this.index++;
        return text(String.valueOf(peek));
    }

    private String match(Pattern pattern) {
        if (this.index >= this.input.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.input);
        matcher.region(this.index, this.input.length());
        if (!matcher.find()) {
            return null;
        }
        this.index = matcher.end();
        return matcher.group();
    }

    private char peek() {
        if (this.index < this.input.length()) {
            return this.input.charAt(this.index);
        }
        return 0;
    }

    private void spnl() {
        match(SPNL);
    }

    private Node parseNewline(Node node) {
        this.index++;
        if (node instanceof Text) {
            Text text = (Text) node;
            if (text.getLiteral().endsWith(StringUtils.SPACE)) {
                String literal = text.getLiteral();
                Matcher matcher = FINAL_SPACE.matcher(literal);
                int end = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (end > 0) {
                    text.setLiteral(literal.substring(0, literal.length() - end));
                }
                if (end >= 2) {
                    return new HardLineBreak();
                }
                return new SoftLineBreak();
            }
        }
        return new SoftLineBreak();
    }

    private Node parseBackslash() {
        this.index++;
        if (peek() == 10) {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.index++;
            return hardLineBreak;
        }
        if (this.index < this.input.length()) {
            Pattern pattern = ESCAPABLE;
            String str = this.input;
            int i = this.index;
            if (pattern.matcher(str.substring(i, i + 1)).matches()) {
                String str2 = this.input;
                int i2 = this.index;
                Text text = text(str2, i2, i2 + 1);
                this.index++;
                return text;
            }
        }
        return text("\\");
    }

    private Node parseBackticks() {
        String match;
        String match2 = match(TICKS_HERE);
        if (match2 == null) {
            return null;
        }
        int i = this.index;
        do {
            match = match(TICKS);
            if (match == null) {
                this.index = i;
                return text(match2);
            }
        } while (!match.equals(match2));
        Code code = new Code();
        String replace = this.input.substring(i, this.index - match2.length()).replace(10, ' ');
        if (replace.length() >= 3 && replace.charAt(0) == ' ' && replace.charAt(replace.length() - 1) == ' ' && Parsing.hasNonSpace(replace)) {
            replace = replace.substring(1, replace.length() - 1);
        }
        code.setLiteral(replace);
        return code;
    }

    private Node parseDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        DelimiterData scanDelimiters = scanDelimiters(delimiterProcessor, c);
        if (scanDelimiters == null) {
            return null;
        }
        int i = scanDelimiters.count;
        int i2 = this.index;
        int i3 = i2 + i;
        this.index = i3;
        Text text = text(this.input, i2, i3);
        Delimiter delimiter = new Delimiter(text, c, scanDelimiters.canOpen, scanDelimiters.canClose, this.lastDelimiter);
        this.lastDelimiter = delimiter;
        delimiter.length = i;
        this.lastDelimiter.originalLength = i;
        if (this.lastDelimiter.previous != null) {
            this.lastDelimiter.previous.next = this.lastDelimiter;
        }
        return text;
    }

    private Node parseOpenBracket() {
        int i = this.index;
        this.index = i + 1;
        Text text = text("[");
        addBracket(Bracket.link(text, i, this.lastBracket, this.lastDelimiter));
        return text;
    }

    private Node parseBang() {
        int i = this.index;
        this.index = i + 1;
        if (peek() != '[') {
            return text("!");
        }
        this.index++;
        Text text = text("![");
        addBracket(Bracket.image(text, i + 1, this.lastBracket, this.lastDelimiter));
        return text;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.commonmark.node.Node parseCloseBracket() {
        /*
            r12 = this;
            int r0 = r12.index
            r1 = 1
            int r0 = r0 + r1
            r12.index = r0
            org.commonmark.internal.Bracket r2 = r12.lastBracket
            java.lang.String r3 = "]"
            if (r2 != 0) goto L_0x0011
            org.commonmark.node.Text r0 = r12.text(r3)
            return r0
        L_0x0011:
            boolean r4 = r2.allowed
            if (r4 != 0) goto L_0x001d
            r12.removeLastBracket()
            org.commonmark.node.Text r0 = r12.text(r3)
            return r0
        L_0x001d:
            char r4 = r12.peek()
            r5 = 40
            r6 = 0
            r7 = 0
            if (r4 != r5) goto L_0x006b
            int r4 = r12.index
            int r4 = r4 + r1
            r12.index = r4
            r12.spnl()
            java.lang.String r4 = r12.parseLinkDestination()
            if (r4 == 0) goto L_0x0069
            r12.spnl()
            java.util.regex.Pattern r5 = WHITESPACE
            java.lang.String r8 = r12.input
            int r9 = r12.index
            int r10 = r9 + -1
            java.lang.String r8 = r8.substring(r10, r9)
            java.util.regex.Matcher r5 = r5.matcher(r8)
            boolean r5 = r5.matches()
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = r12.parseLinkTitle()
            r12.spnl()
            goto L_0x0057
        L_0x0056:
            r5 = r7
        L_0x0057:
            char r8 = r12.peek()
            r9 = 41
            if (r8 != r9) goto L_0x0066
            int r8 = r12.index
            int r8 = r8 + r1
            r12.index = r8
            r8 = 1
            goto L_0x006e
        L_0x0066:
            r12.index = r0
            goto L_0x006d
        L_0x0069:
            r5 = r7
            goto L_0x006d
        L_0x006b:
            r4 = r7
            r5 = r4
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r8 != 0) goto L_0x00a6
            int r9 = r12.index
            r12.parseLinkLabel()
            int r10 = r12.index
            int r10 = r10 - r9
            r11 = 2
            if (r10 <= r11) goto L_0x0083
            java.lang.String r7 = r12.input
            int r10 = r10 + r9
            java.lang.String r7 = r7.substring(r9, r10)
            goto L_0x008f
        L_0x0083:
            boolean r9 = r2.bracketAfter
            if (r9 != 0) goto L_0x008f
            java.lang.String r7 = r12.input
            int r9 = r2.index
            java.lang.String r7 = r7.substring(r9, r0)
        L_0x008f:
            if (r7 == 0) goto L_0x00a6
            java.lang.String r7 = org.commonmark.internal.util.Escaping.normalizeReference(r7)
            org.commonmark.parser.InlineParserContext r9 = r12.context
            org.commonmark.node.LinkReferenceDefinition r7 = r9.getLinkReferenceDefinition(r7)
            if (r7 == 0) goto L_0x00a6
            java.lang.String r4 = r7.getDestination()
            java.lang.String r5 = r7.getTitle()
            goto L_0x00a7
        L_0x00a6:
            r1 = r8
        L_0x00a7:
            if (r1 == 0) goto L_0x00eb
            boolean r0 = r2.image
            if (r0 == 0) goto L_0x00b3
            org.commonmark.node.Image r0 = new org.commonmark.node.Image
            r0.<init>(r4, r5)
            goto L_0x00b8
        L_0x00b3:
            org.commonmark.node.Link r0 = new org.commonmark.node.Link
            r0.<init>(r4, r5)
        L_0x00b8:
            org.commonmark.node.Text r1 = r2.node
            org.commonmark.node.Node r1 = r1.getNext()
        L_0x00be:
            if (r1 == 0) goto L_0x00c9
            org.commonmark.node.Node r3 = r1.getNext()
            r0.appendChild(r1)
            r1 = r3
            goto L_0x00be
        L_0x00c9:
            org.commonmark.internal.Delimiter r1 = r2.previousDelimiter
            r12.processDelimiters(r1)
            r12.mergeChildTextNodes(r0)
            org.commonmark.node.Text r1 = r2.node
            r1.unlink()
            r12.removeLastBracket()
            boolean r1 = r2.image
            if (r1 != 0) goto L_0x00ea
            org.commonmark.internal.Bracket r1 = r12.lastBracket
        L_0x00df:
            if (r1 == 0) goto L_0x00ea
            boolean r2 = r1.image
            if (r2 != 0) goto L_0x00e7
            r1.allowed = r6
        L_0x00e7:
            org.commonmark.internal.Bracket r1 = r1.previous
            goto L_0x00df
        L_0x00ea:
            return r0
        L_0x00eb:
            r12.index = r0
            r12.removeLastBracket()
            org.commonmark.node.Text r0 = r12.text(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.parseCloseBracket():org.commonmark.node.Node");
    }

    private void addBracket(Bracket bracket) {
        Bracket bracket2 = this.lastBracket;
        if (bracket2 != null) {
            bracket2.bracketAfter = true;
        }
        this.lastBracket = bracket;
    }

    private void removeLastBracket() {
        this.lastBracket = this.lastBracket.previous;
    }

    private String parseLinkDestination() {
        String str;
        int scanLinkDestination = LinkScanner.scanLinkDestination(this.input, this.index);
        if (scanLinkDestination == -1) {
            return null;
        }
        if (peek() == '<') {
            str = this.input.substring(this.index + 1, scanLinkDestination - 1);
        } else {
            str = this.input.substring(this.index, scanLinkDestination);
        }
        this.index = scanLinkDestination;
        return Escaping.unescapeString(str);
    }

    private String parseLinkTitle() {
        int scanLinkTitle = LinkScanner.scanLinkTitle(this.input, this.index);
        if (scanLinkTitle == -1) {
            return null;
        }
        String substring = this.input.substring(this.index + 1, scanLinkTitle - 1);
        this.index = scanLinkTitle;
        return Escaping.unescapeString(substring);
    }

    /* access modifiers changed from: package-private */
    public int parseLinkLabel() {
        if (this.index < this.input.length() && this.input.charAt(this.index) == '[') {
            int i = this.index + 1;
            int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(this.input, i);
            int i2 = scanLinkLabelContent - i;
            if (scanLinkLabelContent != -1 && i2 <= 999 && scanLinkLabelContent < this.input.length() && this.input.charAt(scanLinkLabelContent) == ']') {
                this.index = scanLinkLabelContent + 1;
                return i2 + 2;
            }
        }
        return 0;
    }

    private Node parseAutolink() {
        String match = match(EMAIL_AUTOLINK);
        if (match != null) {
            String substring = match.substring(1, match.length() - 1);
            Link link = new Link("mailto:" + substring, (String) null);
            link.appendChild(new Text(substring));
            return link;
        }
        String match2 = match(AUTOLINK);
        if (match2 == null) {
            return null;
        }
        String substring2 = match2.substring(1, match2.length() - 1);
        Link link2 = new Link(substring2, (String) null);
        link2.appendChild(new Text(substring2));
        return link2;
    }

    private Node parseHtmlInline() {
        String match = match(HTML_TAG);
        if (match == null) {
            return null;
        }
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.setLiteral(match);
        return htmlInline;
    }

    private Node parseEntity() {
        String match = match(ENTITY_HERE);
        if (match != null) {
            return text(Html5Entities.entityToString(match));
        }
        return null;
    }

    private Node parseString() {
        int i = this.index;
        int length = this.input.length();
        while (true) {
            int i2 = this.index;
            if (i2 == length || this.specialCharacters.get(this.input.charAt(i2))) {
                int i3 = this.index;
            } else {
                this.index++;
            }
        }
        int i32 = this.index;
        if (i != i32) {
            return text(this.input, i, i32);
        }
        return null;
    }

    private DelimiterData scanDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        String str;
        boolean z;
        int i = this.index;
        boolean z2 = false;
        int i2 = 0;
        while (peek() == c) {
            i2++;
            this.index++;
        }
        if (i2 < delimiterProcessor.getMinLength()) {
            this.index = i;
            return null;
        }
        String str2 = StringUtils.f466LF;
        if (i == 0) {
            str = str2;
        } else {
            str = this.input.substring(i - 1, i);
        }
        char peek = peek();
        if (peek != 0) {
            str2 = String.valueOf(peek);
        }
        Pattern pattern = PUNCTUATION;
        boolean matches = pattern.matcher(str).matches();
        Pattern pattern2 = UNICODE_WHITESPACE_CHAR;
        boolean matches2 = pattern2.matcher(str).matches();
        boolean matches3 = pattern.matcher(str2).matches();
        boolean matches4 = pattern2.matcher(str2).matches();
        boolean z3 = !matches4 && (!matches3 || matches2 || matches);
        boolean z4 = !matches2 && (!matches || matches4 || matches3);
        if (c == '_') {
            z = z3 && (!z4 || matches);
            if (z4 && (!z3 || matches3)) {
                z2 = true;
            }
        } else {
            boolean z5 = z3 && c == delimiterProcessor.getOpeningCharacter();
            if (z4 && c == delimiterProcessor.getClosingCharacter()) {
                z2 = true;
            }
            z = z5;
        }
        this.index = i;
        return new DelimiterData(i2, z, z2);
    }

    private void processDelimiters(Delimiter delimiter) {
        boolean z;
        HashMap hashMap = new HashMap();
        Delimiter delimiter2 = this.lastDelimiter;
        while (delimiter2 != null && delimiter2.previous != delimiter) {
            delimiter2 = delimiter2.previous;
        }
        while (delimiter2 != null) {
            char c = delimiter2.delimiterChar;
            DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c));
            if (!delimiter2.canClose || delimiterProcessor == null) {
                delimiter2 = delimiter2.next;
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter delimiter3 = delimiter2.previous;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    z = true;
                    if (delimiter3 == null || delimiter3 == delimiter || delimiter3 == hashMap.get(Character.valueOf(c))) {
                        z = false;
                    } else {
                        if (delimiter3.canOpen && delimiter3.delimiterChar == openingCharacter) {
                            i = delimiterProcessor.getDelimiterUse(delimiter3, delimiter2);
                            z2 = true;
                            if (i > 0) {
                                break;
                            }
                        }
                        delimiter3 = delimiter3.previous;
                    }
                }
                z = false;
                if (!z) {
                    if (!z2) {
                        hashMap.put(Character.valueOf(c), delimiter2.previous);
                        if (!delimiter2.canOpen) {
                            removeDelimiterKeepNode(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.next;
                } else {
                    Text text = delimiter3.node;
                    Text text2 = delimiter2.node;
                    delimiter3.length -= i;
                    delimiter2.length -= i;
                    text.setLiteral(text.getLiteral().substring(0, text.getLiteral().length() - i));
                    text2.setLiteral(text2.getLiteral().substring(0, text2.getLiteral().length() - i));
                    removeDelimitersBetween(delimiter3, delimiter2);
                    mergeTextNodesBetweenExclusive(text, text2);
                    delimiterProcessor.process(text, text2, i);
                    if (delimiter3.length == 0) {
                        removeDelimiterAndNode(delimiter3);
                    }
                    if (delimiter2.length == 0) {
                        Delimiter delimiter4 = delimiter2.next;
                        removeDelimiterAndNode(delimiter2);
                        delimiter2 = delimiter4;
                    }
                }
            }
        }
        while (true) {
            Delimiter delimiter5 = this.lastDelimiter;
            if (delimiter5 != null && delimiter5 != delimiter) {
                removeDelimiterKeepNode(delimiter5);
            } else {
                return;
            }
        }
    }

    private void removeDelimitersBetween(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.previous;
        while (delimiter3 != null && delimiter3 != delimiter) {
            Delimiter delimiter4 = delimiter3.previous;
            removeDelimiterKeepNode(delimiter3);
            delimiter3 = delimiter4;
        }
    }

    private void removeDelimiterAndNode(Delimiter delimiter) {
        delimiter.node.unlink();
        removeDelimiter(delimiter);
    }

    private void removeDelimiterKeepNode(Delimiter delimiter) {
        removeDelimiter(delimiter);
    }

    private void removeDelimiter(Delimiter delimiter) {
        if (delimiter.previous != null) {
            delimiter.previous.next = delimiter.next;
        }
        if (delimiter.next == null) {
            this.lastDelimiter = delimiter.previous;
            return;
        }
        delimiter.next.previous = delimiter.previous;
    }

    private void mergeTextNodesBetweenExclusive(Node node, Node node2) {
        if (node != node2 && node.getNext() != node2) {
            mergeTextNodesInclusive(node.getNext(), node2.getPrevious());
        }
    }

    private void mergeChildTextNodes(Node node) {
        if (node.getFirstChild() != node.getLastChild()) {
            mergeTextNodesInclusive(node.getFirstChild(), node.getLastChild());
        }
    }

    private void mergeTextNodesInclusive(Node node, Node node2) {
        Text text = null;
        Text text2 = null;
        int i = 0;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                i += text2.getLiteral().length();
            } else {
                mergeIfNeeded(text, text2, i);
                text = null;
                text2 = null;
                i = 0;
            }
            if (node == node2) {
                break;
            }
            node = node.getNext();
        }
        mergeIfNeeded(text, text2, i);
    }

    private void mergeIfNeeded(Text text, Text text2, int i) {
        if (text != null && text2 != null && text != text2) {
            StringBuilder sb = new StringBuilder(i);
            sb.append(text.getLiteral());
            Node next = text.getNext();
            Node next2 = text2.getNext();
            while (next != next2) {
                sb.append(((Text) next).getLiteral());
                Node next3 = next.getNext();
                next.unlink();
                next = next3;
            }
            text.setLiteral(sb.toString());
        }
    }

    private static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final int count;

        DelimiterData(int i, boolean z, boolean z2) {
            this.count = i;
            this.canOpen = z;
            this.canClose = z2;
        }
    }
}
