package org.commonmark.renderer.html;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.Renderer;

public class HtmlRenderer implements Renderer {
    /* access modifiers changed from: private */
    public final List<AttributeProviderFactory> attributeProviderFactories;
    /* access modifiers changed from: private */
    public final boolean escapeHtml;
    /* access modifiers changed from: private */
    public final List<HtmlNodeRendererFactory> nodeRendererFactories;
    /* access modifiers changed from: private */
    public final boolean percentEncodeUrls;
    /* access modifiers changed from: private */
    public final String softbreak;

    public interface HtmlRendererExtension extends Extension {
        void extend(Builder builder);
    }

    private HtmlRenderer(Builder builder) {
        this.softbreak = builder.softbreak;
        this.escapeHtml = builder.escapeHtml;
        this.percentEncodeUrls = builder.percentEncodeUrls;
        this.attributeProviderFactories = new ArrayList(builder.attributeProviderFactories);
        ArrayList arrayList = new ArrayList(builder.nodeRendererFactories.size() + 1);
        this.nodeRendererFactories = arrayList;
        arrayList.addAll(builder.nodeRendererFactories);
        arrayList.add(new HtmlNodeRendererFactory() {
            public NodeRenderer create(HtmlNodeRendererContext htmlNodeRendererContext) {
                return new CoreHtmlNodeRenderer(htmlNodeRendererContext);
            }
        });
    }

    public static Builder builder() {
        return new Builder();
    }

    public void render(Node node, Appendable appendable) {
        Objects.requireNonNull(node, "node must not be null");
        new RendererContext(new HtmlWriter(appendable)).render(node);
    }

    public String render(Node node) {
        Objects.requireNonNull(node, "node must not be null");
        StringBuilder sb = new StringBuilder();
        render(node, sb);
        return sb.toString();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public List<AttributeProviderFactory> attributeProviderFactories = new ArrayList();
        /* access modifiers changed from: private */
        public boolean escapeHtml = false;
        /* access modifiers changed from: private */
        public List<HtmlNodeRendererFactory> nodeRendererFactories = new ArrayList();
        /* access modifiers changed from: private */
        public boolean percentEncodeUrls = false;
        /* access modifiers changed from: private */
        public String softbreak = StringUtils.f466LF;

        public HtmlRenderer build() {
            return new HtmlRenderer(this);
        }

        public Builder softbreak(String str) {
            this.softbreak = str;
            return this;
        }

        public Builder escapeHtml(boolean z) {
            this.escapeHtml = z;
            return this;
        }

        public Builder percentEncodeUrls(boolean z) {
            this.percentEncodeUrls = z;
            return this;
        }

        public Builder attributeProviderFactory(AttributeProviderFactory attributeProviderFactory) {
            Objects.requireNonNull(attributeProviderFactory, "attributeProviderFactory must not be null");
            this.attributeProviderFactories.add(attributeProviderFactory);
            return this;
        }

        public Builder nodeRendererFactory(HtmlNodeRendererFactory htmlNodeRendererFactory) {
            Objects.requireNonNull(htmlNodeRendererFactory, "nodeRendererFactory must not be null");
            this.nodeRendererFactories.add(htmlNodeRendererFactory);
            return this;
        }

        public Builder extensions(Iterable<? extends Extension> iterable) {
            Objects.requireNonNull(iterable, "extensions must not be null");
            for (Extension extension : iterable) {
                if (extension instanceof HtmlRendererExtension) {
                    ((HtmlRendererExtension) extension).extend(this);
                }
            }
            return this;
        }
    }

    private class RendererContext implements HtmlNodeRendererContext, AttributeProviderContext {
        private final List<AttributeProvider> attributeProviders;
        private final HtmlWriter htmlWriter;
        private final NodeRendererMap nodeRendererMap;

        private RendererContext(HtmlWriter htmlWriter2) {
            this.nodeRendererMap = new NodeRendererMap();
            this.htmlWriter = htmlWriter2;
            this.attributeProviders = new ArrayList(HtmlRenderer.this.attributeProviderFactories.size());
            for (AttributeProviderFactory create : HtmlRenderer.this.attributeProviderFactories) {
                this.attributeProviders.add(create.create(this));
            }
            for (int size = HtmlRenderer.this.nodeRendererFactories.size() - 1; size >= 0; size--) {
                this.nodeRendererMap.add(((HtmlNodeRendererFactory) HtmlRenderer.this.nodeRendererFactories.get(size)).create(this));
            }
        }

        public boolean shouldEscapeHtml() {
            return HtmlRenderer.this.escapeHtml;
        }

        public String encodeUrl(String str) {
            return HtmlRenderer.this.percentEncodeUrls ? Escaping.percentEncodeUrl(str) : str;
        }

        public Map<String, String> extendAttributes(Node node, String str, Map<String, String> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            setCustomAttributes(node, str, linkedHashMap);
            return linkedHashMap;
        }

        public HtmlWriter getWriter() {
            return this.htmlWriter;
        }

        public String getSoftbreak() {
            return HtmlRenderer.this.softbreak;
        }

        public void render(Node node) {
            this.nodeRendererMap.render(node);
        }

        private void setCustomAttributes(Node node, String str, Map<String, String> map) {
            for (AttributeProvider attributes : this.attributeProviders) {
                attributes.setAttributes(node, str, map);
            }
        }
    }
}
