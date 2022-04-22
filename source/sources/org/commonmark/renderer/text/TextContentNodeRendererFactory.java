package org.commonmark.renderer.text;

import org.commonmark.renderer.NodeRenderer;

public interface TextContentNodeRendererFactory {
    NodeRenderer create(TextContentNodeRendererContext textContentNodeRendererContext);
}
