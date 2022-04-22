package org.commonmark.renderer.html;

import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import editor.ffmpeg.api.FfmpegCommand;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

public class CoreHtmlNodeRenderer extends AbstractVisitor implements NodeRenderer {
    protected final HtmlNodeRendererContext context;
    private final HtmlWriter html;

    public CoreHtmlNodeRenderer(HtmlNodeRendererContext htmlNodeRendererContext) {
        this.context = htmlNodeRendererContext;
        this.html = htmlNodeRendererContext.getWriter();
    }

    public Set<Class<? extends Node>> getNodeTypes() {
        return new HashSet(Arrays.asList(new Class[]{Document.class, Heading.class, Paragraph.class, BlockQuote.class, BulletList.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, IndentedCodeBlock.class, Link.class, ListItem.class, OrderedList.class, Image.class, Emphasis.class, StrongEmphasis.class, Text.class, Code.class, HtmlInline.class, SoftLineBreak.class, HardLineBreak.class}));
    }

    public void render(Node node) {
        node.accept(this);
    }

    public void visit(Document document) {
        visitChildren(document);
    }

    public void visit(Heading heading) {
        String str = "h" + heading.getLevel();
        this.html.line();
        this.html.tag(str, getAttrs(heading, str));
        visitChildren(heading);
        this.html.tag('/' + str);
        this.html.line();
    }

    public void visit(Paragraph paragraph) {
        boolean isInTightList = isInTightList(paragraph);
        if (!isInTightList) {
            this.html.line();
            this.html.tag(TtmlNode.TAG_P, getAttrs(paragraph, TtmlNode.TAG_P));
        }
        visitChildren(paragraph);
        if (!isInTightList) {
            this.html.tag("/p");
            this.html.line();
        }
    }

    public void visit(BlockQuote blockQuote) {
        this.html.line();
        this.html.tag("blockquote", getAttrs(blockQuote, "blockquote"));
        this.html.line();
        visitChildren(blockQuote);
        this.html.line();
        this.html.tag("/blockquote");
        this.html.line();
    }

    public void visit(BulletList bulletList) {
        renderListBlock(bulletList, "ul", getAttrs(bulletList, "ul"));
    }

    public void visit(FencedCodeBlock fencedCodeBlock) {
        String literal = fencedCodeBlock.getLiteral();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String info = fencedCodeBlock.getInfo();
        if (info != null && !info.isEmpty()) {
            int indexOf = info.indexOf(StringUtils.SPACE);
            if (indexOf != -1) {
                info = info.substring(0, indexOf);
            }
            linkedHashMap.put("class", "language-" + info);
        }
        renderCodeBlock(literal, fencedCodeBlock, linkedHashMap);
    }

    public void visit(HtmlBlock htmlBlock) {
        this.html.line();
        if (this.context.shouldEscapeHtml()) {
            this.html.tag(TtmlNode.TAG_P, getAttrs(htmlBlock, TtmlNode.TAG_P));
            this.html.text(htmlBlock.getLiteral());
            this.html.tag("/p");
        } else {
            this.html.raw(htmlBlock.getLiteral());
        }
        this.html.line();
    }

    public void visit(ThematicBreak thematicBreak) {
        this.html.line();
        this.html.tag("hr", getAttrs(thematicBreak, "hr"), true);
        this.html.line();
    }

    public void visit(IndentedCodeBlock indentedCodeBlock) {
        renderCodeBlock(indentedCodeBlock.getLiteral(), indentedCodeBlock, Collections.emptyMap());
    }

    public void visit(Link link) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ShareConstants.WEB_DIALOG_PARAM_HREF, this.context.encodeUrl(link.getDestination()));
        if (link.getTitle() != null) {
            linkedHashMap.put("title", link.getTitle());
        }
        this.html.tag(FfmpegCommand.AUDIO_STREAM, getAttrs(link, FfmpegCommand.AUDIO_STREAM, linkedHashMap));
        visitChildren(link);
        this.html.tag("/a");
    }

    public void visit(ListItem listItem) {
        this.html.tag("li", getAttrs(listItem, "li"));
        visitChildren(listItem);
        this.html.tag("/li");
        this.html.line();
    }

    public void visit(OrderedList orderedList) {
        int startNumber = orderedList.getStartNumber();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (startNumber != 1) {
            linkedHashMap.put(TtmlNode.START, String.valueOf(startNumber));
        }
        renderListBlock(orderedList, "ol", getAttrs(orderedList, "ol", linkedHashMap));
    }

    public void visit(Image image) {
        String encodeUrl = this.context.encodeUrl(image.getDestination());
        AltTextVisitor altTextVisitor = new AltTextVisitor();
        image.accept(altTextVisitor);
        String altText = altTextVisitor.getAltText();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("src", encodeUrl);
        linkedHashMap.put("alt", altText);
        if (image.getTitle() != null) {
            linkedHashMap.put("title", image.getTitle());
        }
        this.html.tag("img", getAttrs(image, "img", linkedHashMap), true);
    }

    public void visit(Emphasis emphasis) {
        this.html.tag(UserDataStore.EMAIL, getAttrs(emphasis, UserDataStore.EMAIL));
        visitChildren(emphasis);
        this.html.tag("/em");
    }

    public void visit(StrongEmphasis strongEmphasis) {
        this.html.tag("strong", getAttrs(strongEmphasis, "strong"));
        visitChildren(strongEmphasis);
        this.html.tag("/strong");
    }

    public void visit(Text text) {
        this.html.text(text.getLiteral());
    }

    public void visit(Code code) {
        this.html.tag("code", getAttrs(code, "code"));
        this.html.text(code.getLiteral());
        this.html.tag("/code");
    }

    public void visit(HtmlInline htmlInline) {
        if (this.context.shouldEscapeHtml()) {
            this.html.text(htmlInline.getLiteral());
        } else {
            this.html.raw(htmlInline.getLiteral());
        }
    }

    public void visit(SoftLineBreak softLineBreak) {
        this.html.raw(this.context.getSoftbreak());
    }

    public void visit(HardLineBreak hardLineBreak) {
        this.html.tag(TtmlNode.TAG_BR, getAttrs(hardLineBreak, TtmlNode.TAG_BR), true);
        this.html.line();
    }

    /* access modifiers changed from: protected */
    public void visitChildren(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            this.context.render(firstChild);
            firstChild = next;
        }
    }

    private void renderCodeBlock(String str, Node node, Map<String, String> map) {
        this.html.line();
        this.html.tag("pre", getAttrs(node, "pre"));
        this.html.tag("code", getAttrs(node, "code", map));
        this.html.text(str);
        this.html.tag("/code");
        this.html.tag("/pre");
        this.html.line();
    }

    private void renderListBlock(ListBlock listBlock, String str, Map<String, String> map) {
        this.html.line();
        this.html.tag(str, map);
        this.html.line();
        visitChildren(listBlock);
        this.html.line();
        HtmlWriter htmlWriter = this.html;
        htmlWriter.tag('/' + str);
        this.html.line();
    }

    private boolean isInTightList(Paragraph paragraph) {
        Node parent;
        Block parent2 = paragraph.getParent();
        if (parent2 == null || (parent = parent2.getParent()) == null || !(parent instanceof ListBlock)) {
            return false;
        }
        return ((ListBlock) parent).isTight();
    }

    private Map<String, String> getAttrs(Node node, String str) {
        return getAttrs(node, str, Collections.emptyMap());
    }

    private Map<String, String> getAttrs(Node node, String str, Map<String, String> map) {
        return this.context.extendAttributes(node, str, map);
    }

    private static class AltTextVisitor extends AbstractVisitor {

        /* renamed from: sb */
        private final StringBuilder f480sb;

        private AltTextVisitor() {
            this.f480sb = new StringBuilder();
        }

        /* access modifiers changed from: package-private */
        public String getAltText() {
            return this.f480sb.toString();
        }

        public void visit(Text text) {
            this.f480sb.append(text.getLiteral());
        }

        public void visit(SoftLineBreak softLineBreak) {
            this.f480sb.append(10);
        }

        public void visit(HardLineBreak hardLineBreak) {
            this.f480sb.append(10);
        }
    }
}
