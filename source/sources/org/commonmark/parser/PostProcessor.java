package org.commonmark.parser;

import org.commonmark.node.Node;

public interface PostProcessor {
    Node process(Node node);
}
