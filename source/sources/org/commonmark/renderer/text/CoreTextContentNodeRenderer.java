package org.commonmark.renderer.text;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.internal.renderer.text.BulletListHolder;
import org.commonmark.internal.renderer.text.ListHolder;
import org.commonmark.internal.renderer.text.OrderedListHolder;
import org.commonmark.node.AbstractVisitor;
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
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

public class CoreTextContentNodeRenderer extends AbstractVisitor implements NodeRenderer {
    protected final TextContentNodeRendererContext context;
    private ListHolder listHolder;
    private final TextContentWriter textContent;

    public CoreTextContentNodeRenderer(TextContentNodeRendererContext textContentNodeRendererContext) {
        this.context = textContentNodeRendererContext;
        this.textContent = textContentNodeRendererContext.getWriter();
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

    public void visit(BlockQuote blockQuote) {
        this.textContent.write((char) Typography.leftGuillemete);
        visitChildren(blockQuote);
        this.textContent.write((char) Typography.rightGuillemete);
        writeEndOfLineIfNeeded(blockQuote, (Character) null);
    }

    public void visit(BulletList bulletList) {
        if (this.listHolder != null) {
            writeEndOfLine();
        }
        this.listHolder = new BulletListHolder(this.listHolder, bulletList);
        visitChildren(bulletList);
        writeEndOfLineIfNeeded(bulletList, (Character) null);
        if (this.listHolder.getParent() != null) {
            this.listHolder = this.listHolder.getParent();
        } else {
            this.listHolder = null;
        }
    }

    public void visit(Code code) {
        this.textContent.write((char) Typography.quote);
        this.textContent.write(code.getLiteral());
        this.textContent.write((char) Typography.quote);
    }

    public void visit(FencedCodeBlock fencedCodeBlock) {
        if (this.context.stripNewlines()) {
            this.textContent.writeStripped(fencedCodeBlock.getLiteral());
            writeEndOfLineIfNeeded(fencedCodeBlock, (Character) null);
            return;
        }
        this.textContent.write(fencedCodeBlock.getLiteral());
    }

    public void visit(HardLineBreak hardLineBreak) {
        writeEndOfLineIfNeeded(hardLineBreak, (Character) null);
    }

    public void visit(Heading heading) {
        visitChildren(heading);
        writeEndOfLineIfNeeded(heading, ':');
    }

    public void visit(ThematicBreak thematicBreak) {
        if (!this.context.stripNewlines()) {
            this.textContent.write("***");
        }
        writeEndOfLineIfNeeded(thematicBreak, (Character) null);
    }

    public void visit(HtmlInline htmlInline) {
        writeText(htmlInline.getLiteral());
    }

    public void visit(HtmlBlock htmlBlock) {
        writeText(htmlBlock.getLiteral());
    }

    public void visit(Image image) {
        writeLink(image, image.getTitle(), image.getDestination());
    }

    public void visit(IndentedCodeBlock indentedCodeBlock) {
        if (this.context.stripNewlines()) {
            this.textContent.writeStripped(indentedCodeBlock.getLiteral());
            writeEndOfLineIfNeeded(indentedCodeBlock, (Character) null);
            return;
        }
        this.textContent.write(indentedCodeBlock.getLiteral());
    }

    public void visit(Link link) {
        writeLink(link, link.getTitle(), link.getDestination());
    }

    public void visit(ListItem listItem) {
        ListHolder listHolder2 = this.listHolder;
        if (listHolder2 != null && (listHolder2 instanceof OrderedListHolder)) {
            OrderedListHolder orderedListHolder = (OrderedListHolder) listHolder2;
            String indent = this.context.stripNewlines() ? "" : orderedListHolder.getIndent();
            TextContentWriter textContentWriter = this.textContent;
            textContentWriter.write(indent + orderedListHolder.getCounter() + orderedListHolder.getDelimiter() + StringUtils.SPACE);
            visitChildren(listItem);
            writeEndOfLineIfNeeded(listItem, (Character) null);
            orderedListHolder.increaseCounter();
        } else if (listHolder2 != null && (listHolder2 instanceof BulletListHolder)) {
            BulletListHolder bulletListHolder = (BulletListHolder) listHolder2;
            if (!this.context.stripNewlines()) {
                TextContentWriter textContentWriter2 = this.textContent;
                textContentWriter2.write(bulletListHolder.getIndent() + bulletListHolder.getMarker() + StringUtils.SPACE);
            }
            visitChildren(listItem);
            writeEndOfLineIfNeeded(listItem, (Character) null);
        }
    }

    public void visit(OrderedList orderedList) {
        if (this.listHolder != null) {
            writeEndOfLine();
        }
        this.listHolder = new OrderedListHolder(this.listHolder, orderedList);
        visitChildren(orderedList);
        writeEndOfLineIfNeeded(orderedList, (Character) null);
        if (this.listHolder.getParent() != null) {
            this.listHolder = this.listHolder.getParent();
        } else {
            this.listHolder = null;
        }
    }

    public void visit(Paragraph paragraph) {
        visitChildren(paragraph);
        if (paragraph.getParent() == null || (paragraph.getParent() instanceof Document)) {
            writeEndOfLineIfNeeded(paragraph, (Character) null);
        }
    }

    public void visit(SoftLineBreak softLineBreak) {
        writeEndOfLineIfNeeded(softLineBreak, (Character) null);
    }

    public void visit(Text text) {
        writeText(text.getLiteral());
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

    private void writeText(String str) {
        if (this.context.stripNewlines()) {
            this.textContent.writeStripped(str);
        } else {
            this.textContent.write(str);
        }
    }

    private void writeLink(Node node, String str, String str2) {
        boolean z = true;
        boolean z2 = node.getFirstChild() != null;
        boolean z3 = str != null && !str.equals(str2);
        if (str2 == null || str2.equals("")) {
            z = false;
        }
        if (z2) {
            this.textContent.write((char) Typography.quote);
            visitChildren(node);
            this.textContent.write((char) Typography.quote);
            if (z3 || z) {
                this.textContent.whitespace();
                this.textContent.write('(');
            }
        }
        if (z3) {
            this.textContent.write(str);
            if (z) {
                this.textContent.colon();
                this.textContent.whitespace();
            }
        }
        if (z) {
            this.textContent.write(str2);
        }
        if (!z2) {
            return;
        }
        if (z3 || z) {
            this.textContent.write(')');
        }
    }

    private void writeEndOfLineIfNeeded(Node node, Character ch) {
        if (this.context.stripNewlines()) {
            if (ch != null) {
                this.textContent.write(ch.charValue());
            }
            if (node.getNext() != null) {
                this.textContent.whitespace();
            }
        } else if (node.getNext() != null) {
            this.textContent.line();
        }
    }

    private void writeEndOfLine() {
        if (this.context.stripNewlines()) {
            this.textContent.whitespace();
        } else {
            this.textContent.line();
        }
    }
}
