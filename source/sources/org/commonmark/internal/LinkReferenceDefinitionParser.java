package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;

public class LinkReferenceDefinitionParser {
    private final List<LinkReferenceDefinition> definitions = new ArrayList();
    private String destination;
    private StringBuilder label;
    private String normalizedLabel;
    private final StringBuilder paragraph = new StringBuilder();
    private boolean referenceValid = false;
    private State state = State.START_DEFINITION;
    private StringBuilder title;
    private char titleDelimiter;

    enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public void parse(CharSequence charSequence) {
        if (this.paragraph.length() != 0) {
            this.paragraph.append(10);
        }
        this.paragraph.append(charSequence);
        int i = 0;
        while (i < charSequence.length()) {
            switch (C24241.f479x496a1d35[this.state.ordinal()]) {
                case 1:
                    return;
                case 2:
                    i = startDefinition(charSequence, i);
                    break;
                case 3:
                    i = label(charSequence, i);
                    break;
                case 4:
                    i = destination(charSequence, i);
                    break;
                case 5:
                    i = startTitle(charSequence, i);
                    break;
                case 6:
                    i = title(charSequence, i);
                    break;
            }
            if (i == -1) {
                this.state = State.PARAGRAPH;
                return;
            }
        }
    }

    /* renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1 */
    static /* synthetic */ class C24241 {

        /* renamed from: $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State */
        static final /* synthetic */ int[] f479x496a1d35;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.commonmark.internal.LinkReferenceDefinitionParser$State[] r0 = org.commonmark.internal.LinkReferenceDefinitionParser.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f479x496a1d35 = r0
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f479x496a1d35     // Catch:{ NoSuchFieldError -> 0x001d }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_DEFINITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f479x496a1d35     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.LABEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f479x496a1d35     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.DESTINATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f479x496a1d35     // Catch:{ NoSuchFieldError -> 0x003e }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_TITLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f479x496a1d35     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.TITLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.LinkReferenceDefinitionParser.C24241.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence getParagraphContent() {
        return this.paragraph;
    }

    /* access modifiers changed from: package-private */
    public List<LinkReferenceDefinition> getDefinitions() {
        finishReference();
        return this.definitions;
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        return this.state;
    }

    private int startDefinition(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length() || charSequence.charAt(skipSpaceTab) != '[') {
            return -1;
        }
        this.state = State.LABEL;
        this.label = new StringBuilder();
        int i2 = skipSpaceTab + 1;
        if (i2 >= charSequence.length()) {
            this.label.append(10);
        }
        return i2;
    }

    private int label(CharSequence charSequence, int i) {
        int i2;
        int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(charSequence, i);
        if (scanLinkLabelContent == -1) {
            return -1;
        }
        this.label.append(charSequence, i, scanLinkLabelContent);
        if (scanLinkLabelContent >= charSequence.length()) {
            this.label.append(10);
            return scanLinkLabelContent;
        } else if (charSequence.charAt(scanLinkLabelContent) != ']' || (i2 = scanLinkLabelContent + 1) >= charSequence.length() || charSequence.charAt(i2) != ':' || this.label.length() > 999) {
            return -1;
        } else {
            String normalizeLabelContent = Escaping.normalizeLabelContent(this.label.toString());
            if (normalizeLabelContent.isEmpty()) {
                return -1;
            }
            this.normalizedLabel = normalizeLabelContent;
            this.state = State.DESTINATION;
            return Parsing.skipSpaceTab(charSequence, i2 + 1, charSequence.length());
        }
    }

    private int destination(CharSequence charSequence, int i) {
        String str;
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        int scanLinkDestination = LinkScanner.scanLinkDestination(charSequence, skipSpaceTab);
        if (scanLinkDestination == -1) {
            return -1;
        }
        if (charSequence.charAt(skipSpaceTab) == '<') {
            str = charSequence.subSequence(skipSpaceTab + 1, scanLinkDestination - 1).toString();
        } else {
            str = charSequence.subSequence(skipSpaceTab, scanLinkDestination).toString();
        }
        this.destination = str;
        int skipSpaceTab2 = Parsing.skipSpaceTab(charSequence, scanLinkDestination, charSequence.length());
        if (skipSpaceTab2 >= charSequence.length()) {
            this.referenceValid = true;
            this.paragraph.setLength(0);
        } else if (skipSpaceTab2 == scanLinkDestination) {
            return -1;
        }
        this.state = State.START_TITLE;
        return skipSpaceTab2;
    }

    private int startTitle(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length()) {
            this.state = State.START_DEFINITION;
            return skipSpaceTab;
        }
        this.titleDelimiter = 0;
        char charAt = charSequence.charAt(skipSpaceTab);
        if (charAt == '\"' || charAt == '\'') {
            this.titleDelimiter = charAt;
        } else if (charAt == '(') {
            this.titleDelimiter = ')';
        }
        if (this.titleDelimiter != 0) {
            this.state = State.TITLE;
            this.title = new StringBuilder();
            skipSpaceTab++;
            if (skipSpaceTab == charSequence.length()) {
                this.title.append(10);
            }
        } else {
            finishReference();
            this.state = State.START_DEFINITION;
        }
        return skipSpaceTab;
    }

    private int title(CharSequence charSequence, int i) {
        int scanLinkTitleContent = LinkScanner.scanLinkTitleContent(charSequence, i, this.titleDelimiter);
        if (scanLinkTitleContent == -1) {
            return -1;
        }
        this.title.append(charSequence.subSequence(i, scanLinkTitleContent));
        if (scanLinkTitleContent >= charSequence.length()) {
            this.title.append(10);
            return scanLinkTitleContent;
        }
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, scanLinkTitleContent + 1, charSequence.length());
        if (skipSpaceTab != charSequence.length()) {
            return -1;
        }
        this.referenceValid = true;
        finishReference();
        this.paragraph.setLength(0);
        this.state = State.START_DEFINITION;
        return skipSpaceTab;
    }

    private void finishReference() {
        if (this.referenceValid) {
            String unescapeString = Escaping.unescapeString(this.destination);
            StringBuilder sb = this.title;
            this.definitions.add(new LinkReferenceDefinition(this.normalizedLabel, unescapeString, sb != null ? Escaping.unescapeString(sb.toString()) : null));
            this.label = null;
            this.referenceValid = false;
            this.normalizedLabel = null;
            this.destination = null;
            this.title = null;
        }
    }
}
