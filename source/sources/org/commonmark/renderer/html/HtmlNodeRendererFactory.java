package org.commonmark.renderer.html;

import org.commonmark.renderer.NodeRenderer;

public interface HtmlNodeRendererFactory {
    NodeRenderer create(HtmlNodeRendererContext htmlNodeRendererContext);
}
