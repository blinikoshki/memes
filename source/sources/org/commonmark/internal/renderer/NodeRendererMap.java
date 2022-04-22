package org.commonmark.internal.renderer;

import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

public class NodeRendererMap {
    private final Map<Class<? extends Node>, NodeRenderer> renderers = new HashMap(32);

    public void add(NodeRenderer nodeRenderer) {
        for (Class<? extends Node> put : nodeRenderer.getNodeTypes()) {
            this.renderers.put(put, nodeRenderer);
        }
    }

    public void render(Node node) {
        NodeRenderer nodeRenderer = this.renderers.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.render(node);
        }
    }
}
