package org.commonmark.parser;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.delimiter.DelimiterProcessor;

public interface InlineParserContext {
    List<DelimiterProcessor> getCustomDelimiterProcessors();

    LinkReferenceDefinition getLinkReferenceDefinition(String str);
}
