package org.commonmark.renderer.text;

import org.commonmark.node.Node;

public interface TextContentNodeRendererContext {
    TextContentWriter getWriter();

    void render(Node node);

    boolean stripNewlines();
}
