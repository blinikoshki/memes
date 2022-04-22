package p015io.noties.markwon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
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
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import p015io.noties.markwon.MarkwonVisitor;

/* renamed from: io.noties.markwon.MarkwonVisitorImpl */
class MarkwonVisitorImpl implements MarkwonVisitor {
    private final MarkwonVisitor.BlockHandler blockHandler;
    private final SpannableBuilder builder;
    private final MarkwonConfiguration configuration;
    private final Map<Class<? extends Node>, MarkwonVisitor.NodeVisitor<? extends Node>> nodes;
    private final RenderProps renderProps;

    MarkwonVisitorImpl(MarkwonConfiguration markwonConfiguration, RenderProps renderProps2, SpannableBuilder spannableBuilder, Map<Class<? extends Node>, MarkwonVisitor.NodeVisitor<? extends Node>> map, MarkwonVisitor.BlockHandler blockHandler2) {
        this.configuration = markwonConfiguration;
        this.renderProps = renderProps2;
        this.builder = spannableBuilder;
        this.nodes = map;
        this.blockHandler = blockHandler2;
    }

    public void visit(BlockQuote blockQuote) {
        visit((Node) blockQuote);
    }

    public void visit(BulletList bulletList) {
        visit((Node) bulletList);
    }

    public void visit(Code code) {
        visit((Node) code);
    }

    public void visit(Document document) {
        visit((Node) document);
    }

    public void visit(Emphasis emphasis) {
        visit((Node) emphasis);
    }

    public void visit(FencedCodeBlock fencedCodeBlock) {
        visit((Node) fencedCodeBlock);
    }

    public void visit(HardLineBreak hardLineBreak) {
        visit((Node) hardLineBreak);
    }

    public void visit(Heading heading) {
        visit((Node) heading);
    }

    public void visit(ThematicBreak thematicBreak) {
        visit((Node) thematicBreak);
    }

    public void visit(HtmlInline htmlInline) {
        visit((Node) htmlInline);
    }

    public void visit(HtmlBlock htmlBlock) {
        visit((Node) htmlBlock);
    }

    public void visit(Image image) {
        visit((Node) image);
    }

    public void visit(IndentedCodeBlock indentedCodeBlock) {
        visit((Node) indentedCodeBlock);
    }

    public void visit(Link link) {
        visit((Node) link);
    }

    public void visit(ListItem listItem) {
        visit((Node) listItem);
    }

    public void visit(OrderedList orderedList) {
        visit((Node) orderedList);
    }

    public void visit(Paragraph paragraph) {
        visit((Node) paragraph);
    }

    public void visit(SoftLineBreak softLineBreak) {
        visit((Node) softLineBreak);
    }

    public void visit(StrongEmphasis strongEmphasis) {
        visit((Node) strongEmphasis);
    }

    public void visit(Text text) {
        visit((Node) text);
    }

    public void visit(LinkReferenceDefinition linkReferenceDefinition) {
        visit((Node) linkReferenceDefinition);
    }

    public void visit(CustomBlock customBlock) {
        visit((Node) customBlock);
    }

    public void visit(CustomNode customNode) {
        visit((Node) customNode);
    }

    private void visit(Node node) {
        MarkwonVisitor.NodeVisitor nodeVisitor = this.nodes.get(node.getClass());
        if (nodeVisitor != null) {
            nodeVisitor.visit(this, node);
        } else {
            visitChildren(node);
        }
    }

    public MarkwonConfiguration configuration() {
        return this.configuration;
    }

    public RenderProps renderProps() {
        return this.renderProps;
    }

    public SpannableBuilder builder() {
        return this.builder;
    }

    public void visitChildren(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(this);
            firstChild = next;
        }
    }

    public boolean hasNext(Node node) {
        return node.getNext() != null;
    }

    public void ensureNewLine() {
        if (this.builder.length() > 0 && 10 != this.builder.lastChar()) {
            this.builder.append(10);
        }
    }

    public void forceNewLine() {
        this.builder.append(10);
    }

    public int length() {
        return this.builder.length();
    }

    public void setSpans(int i, Object obj) {
        SpannableBuilder spannableBuilder = this.builder;
        SpannableBuilder.setSpans(spannableBuilder, obj, i, spannableBuilder.length());
    }

    public void clear() {
        this.renderProps.clearAll();
        this.builder.clear();
    }

    public <N extends Node> void setSpansForNode(N n, int i) {
        setSpansForNode(n.getClass(), i);
    }

    public <N extends Node> void setSpansForNode(Class<N> cls, int i) {
        setSpans(i, this.configuration.spansFactory().require(cls).getSpans(this.configuration, this.renderProps));
    }

    public <N extends Node> void setSpansForNodeOptional(N n, int i) {
        setSpansForNodeOptional(n.getClass(), i);
    }

    public <N extends Node> void setSpansForNodeOptional(Class<N> cls, int i) {
        SpanFactory spanFactory = this.configuration.spansFactory().get(cls);
        if (spanFactory != null) {
            setSpans(i, spanFactory.getSpans(this.configuration, this.renderProps));
        }
    }

    public void blockStart(Node node) {
        this.blockHandler.blockStart(this, node);
    }

    public void blockEnd(Node node) {
        this.blockHandler.blockEnd(this, node);
    }

    /* renamed from: io.noties.markwon.MarkwonVisitorImpl$BuilderImpl */
    static class BuilderImpl implements MarkwonVisitor.Builder {
        private MarkwonVisitor.BlockHandler blockHandler;
        private final Map<Class<? extends Node>, MarkwonVisitor.NodeVisitor<? extends Node>> nodes = new HashMap();

        BuilderImpl() {
        }

        /* renamed from: on */
        public <N extends Node> MarkwonVisitor.Builder mo23135on(Class<N> cls, MarkwonVisitor.NodeVisitor<? super N> nodeVisitor) {
            if (nodeVisitor == null) {
                this.nodes.remove(cls);
            } else {
                this.nodes.put(cls, nodeVisitor);
            }
            return this;
        }

        public MarkwonVisitor.Builder blockHandler(MarkwonVisitor.BlockHandler blockHandler2) {
            this.blockHandler = blockHandler2;
            return this;
        }

        public MarkwonVisitor build(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
            MarkwonVisitor.BlockHandler blockHandler2 = this.blockHandler;
            if (blockHandler2 == null) {
                blockHandler2 = new BlockHandlerDef();
            }
            return new MarkwonVisitorImpl(markwonConfiguration, renderProps, new SpannableBuilder(), Collections.unmodifiableMap(this.nodes), blockHandler2);
        }
    }
}
