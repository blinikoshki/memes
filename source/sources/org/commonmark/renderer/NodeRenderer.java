package org.commonmark.renderer;

import java.util.Set;
import org.commonmark.node.Node;

public interface NodeRenderer {
    Set<Class<? extends Node>> getNodeTypes();

    void render(Node node);
}
