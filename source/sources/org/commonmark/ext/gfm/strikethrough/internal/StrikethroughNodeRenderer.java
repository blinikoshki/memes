package org.commonmark.ext.gfm.strikethrough.internal;

import java.util.Collections;
import java.util.Set;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

abstract class StrikethroughNodeRenderer implements NodeRenderer {
    StrikethroughNodeRenderer() {
    }

    public Set<Class<? extends Node>> getNodeTypes() {
        return Collections.singleton(Strikethrough.class);
    }
}
