package org.commonmark.renderer;

import org.commonmark.node.Node;

public interface Renderer {
    String render(Node node);

    void render(Node node, Appendable appendable);
}
