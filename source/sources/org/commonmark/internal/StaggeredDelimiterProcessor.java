package org.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private final char delim;
    private int minLength = 0;
    private LinkedList<DelimiterProcessor> processors = new LinkedList<>();

    StaggeredDelimiterProcessor(char c) {
        this.delim = c;
    }

    public char getOpeningCharacter() {
        return this.delim;
    }

    public char getClosingCharacter() {
        return this.delim;
    }

    public int getMinLength() {
        return this.minLength;
    }

    /* access modifiers changed from: package-private */
    public void add(DelimiterProcessor delimiterProcessor) {
        boolean z;
        int minLength2;
        int minLength3 = delimiterProcessor.getMinLength();
        ListIterator listIterator = this.processors.listIterator();
        do {
            if (listIterator.hasNext()) {
                minLength2 = ((DelimiterProcessor) listIterator.next()).getMinLength();
                if (minLength3 > minLength2) {
                    listIterator.previous();
                    listIterator.add(delimiterProcessor);
                    z = true;
                }
            } else {
                z = false;
            }
            if (!z) {
                this.processors.add(delimiterProcessor);
                this.minLength = minLength3;
                return;
            }
            return;
        } while (minLength3 != minLength2);
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.delim + "' and minimum length " + minLength3);
    }

    private DelimiterProcessor findProcessor(int i) {
        Iterator it = this.processors.iterator();
        while (it.hasNext()) {
            DelimiterProcessor delimiterProcessor = (DelimiterProcessor) it.next();
            if (delimiterProcessor.getMinLength() <= i) {
                return delimiterProcessor;
            }
        }
        return this.processors.getFirst();
    }

    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return findProcessor(delimiterRun.length()).getDelimiterUse(delimiterRun, delimiterRun2);
    }

    public void process(Text text, Text text2, int i) {
        findProcessor(i).process(text, text2, i);
    }
}
