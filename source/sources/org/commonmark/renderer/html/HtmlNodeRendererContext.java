package org.commonmark.renderer.html;

import java.util.Map;
import org.commonmark.node.Node;

public interface HtmlNodeRendererContext {
    String encodeUrl(String str);

    Map<String, String> extendAttributes(Node node, String str, Map<String, String> map);

    String getSoftbreak();

    HtmlWriter getWriter();

    void render(Node node);

    boolean shouldEscapeHtml();
}
