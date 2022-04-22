package org.commonmark.renderer.html;

import java.util.Map;
import org.commonmark.node.Node;

public interface AttributeProvider {
    void setAttributes(Node node, String str, Map<String, String> map);
}
