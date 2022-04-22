package org.commonmark.internal;

import java.util.List;
import java.util.Map;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

public class InlineParserContextImpl implements InlineParserContext {
    private final List<DelimiterProcessor> delimiterProcessors;
    private final Map<String, LinkReferenceDefinition> linkReferenceDefinitions;

    public InlineParserContextImpl(List<DelimiterProcessor> list, Map<String, LinkReferenceDefinition> map) {
        this.delimiterProcessors = list;
        this.linkReferenceDefinitions = map;
    }

    public List<DelimiterProcessor> getCustomDelimiterProcessors() {
        return this.delimiterProcessors;
    }

    public LinkReferenceDefinition getLinkReferenceDefinition(String str) {
        return this.linkReferenceDefinitions.get(str);
    }
}
