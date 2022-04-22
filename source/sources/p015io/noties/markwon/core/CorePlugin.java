package p015io.noties.markwon.core;

import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.text.Typography;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
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
import p015io.noties.markwon.AbstractMarkwonPlugin;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonSpansFactory;
import p015io.noties.markwon.MarkwonVisitor;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;
import p015io.noties.markwon.core.CoreProps;
import p015io.noties.markwon.core.factory.BlockQuoteSpanFactory;
import p015io.noties.markwon.core.factory.CodeBlockSpanFactory;
import p015io.noties.markwon.core.factory.CodeSpanFactory;
import p015io.noties.markwon.core.factory.EmphasisSpanFactory;
import p015io.noties.markwon.core.factory.HeadingSpanFactory;
import p015io.noties.markwon.core.factory.LinkSpanFactory;
import p015io.noties.markwon.core.factory.ListItemSpanFactory;
import p015io.noties.markwon.core.factory.StrongEmphasisSpanFactory;
import p015io.noties.markwon.core.factory.ThematicBreakSpanFactory;
import p015io.noties.markwon.core.spans.OrderedListItemSpan;
import p015io.noties.markwon.core.spans.TextViewSpan;
import p015io.noties.markwon.image.ImageProps;

/* renamed from: io.noties.markwon.core.CorePlugin */
public class CorePlugin extends AbstractMarkwonPlugin {
    private boolean hasExplicitMovementMethod;
    /* access modifiers changed from: private */
    public final List<OnTextAddedListener> onTextAddedListeners = new ArrayList(0);

    /* renamed from: io.noties.markwon.core.CorePlugin$OnTextAddedListener */
    public interface OnTextAddedListener {
        void onTextAdded(MarkwonVisitor markwonVisitor, String str, int i);
    }

    public static CorePlugin create() {
        return new CorePlugin();
    }

    public static Set<Class<? extends Block>> enabledBlockTypes() {
        return new HashSet(Arrays.asList(new Class[]{BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class}));
    }

    protected CorePlugin() {
    }

    public CorePlugin hasExplicitMovementMethod(boolean z) {
        this.hasExplicitMovementMethod = z;
        return this;
    }

    public CorePlugin addOnTextAddedListener(OnTextAddedListener onTextAddedListener) {
        this.onTextAddedListeners.add(onTextAddedListener);
        return this;
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        text(builder);
        strongEmphasis(builder);
        emphasis(builder);
        blockQuote(builder);
        code(builder);
        fencedCodeBlock(builder);
        indentedCodeBlock(builder);
        image(builder);
        bulletList(builder);
        orderedList(builder);
        listItem(builder);
        thematicBreak(builder);
        heading(builder);
        softLineBreak(builder);
        hardLineBreak(builder);
        paragraph(builder);
        link(builder);
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        CodeBlockSpanFactory codeBlockSpanFactory = new CodeBlockSpanFactory();
        builder.setFactory(StrongEmphasis.class, new StrongEmphasisSpanFactory()).setFactory(Emphasis.class, new EmphasisSpanFactory()).setFactory(BlockQuote.class, new BlockQuoteSpanFactory()).setFactory(Code.class, new CodeSpanFactory()).setFactory(FencedCodeBlock.class, codeBlockSpanFactory).setFactory(IndentedCodeBlock.class, codeBlockSpanFactory).setFactory(ListItem.class, new ListItemSpanFactory()).setFactory(Heading.class, new HeadingSpanFactory()).setFactory(Link.class, new LinkSpanFactory()).setFactory(ThematicBreak.class, new ThematicBreakSpanFactory());
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        OrderedListItemSpan.measure(textView, spanned);
        if (spanned instanceof Spannable) {
            TextViewSpan.applyTo((Spannable) spanned, textView);
        }
    }

    public void afterSetText(TextView textView) {
        if (!this.hasExplicitMovementMethod && textView.getMovementMethod() == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void text(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Text.class, new MarkwonVisitor.NodeVisitor<Text>() {
            public void visit(MarkwonVisitor markwonVisitor, Text text) {
                String literal = text.getLiteral();
                markwonVisitor.builder().append(literal);
                if (!CorePlugin.this.onTextAddedListeners.isEmpty()) {
                    int length = markwonVisitor.length() - literal.length();
                    for (OnTextAddedListener onTextAdded : CorePlugin.this.onTextAddedListeners) {
                        onTextAdded.onTextAdded(markwonVisitor, literal, length);
                    }
                }
            }
        });
    }

    private static void strongEmphasis(MarkwonVisitor.Builder builder) {
        builder.mo23135on(StrongEmphasis.class, new MarkwonVisitor.NodeVisitor<StrongEmphasis>() {
            public void visit(MarkwonVisitor markwonVisitor, StrongEmphasis strongEmphasis) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(strongEmphasis);
                markwonVisitor.setSpansForNodeOptional(strongEmphasis, length);
            }
        });
    }

    private static void emphasis(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Emphasis.class, new MarkwonVisitor.NodeVisitor<Emphasis>() {
            public void visit(MarkwonVisitor markwonVisitor, Emphasis emphasis) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(emphasis);
                markwonVisitor.setSpansForNodeOptional(emphasis, length);
            }
        });
    }

    private static void blockQuote(MarkwonVisitor.Builder builder) {
        builder.mo23135on(BlockQuote.class, new MarkwonVisitor.NodeVisitor<BlockQuote>() {
            public void visit(MarkwonVisitor markwonVisitor, BlockQuote blockQuote) {
                markwonVisitor.blockStart(blockQuote);
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(blockQuote);
                markwonVisitor.setSpansForNodeOptional(blockQuote, length);
                markwonVisitor.blockEnd(blockQuote);
            }
        });
    }

    private static void code(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Code.class, new MarkwonVisitor.NodeVisitor<Code>() {
            public void visit(MarkwonVisitor markwonVisitor, Code code) {
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) Typography.nbsp).append(code.getLiteral()).append((char) Typography.nbsp);
                markwonVisitor.setSpansForNodeOptional(code, length);
            }
        });
    }

    private static void fencedCodeBlock(MarkwonVisitor.Builder builder) {
        builder.mo23135on(FencedCodeBlock.class, new MarkwonVisitor.NodeVisitor<FencedCodeBlock>() {
            public void visit(MarkwonVisitor markwonVisitor, FencedCodeBlock fencedCodeBlock) {
                CorePlugin.visitCodeBlock(markwonVisitor, fencedCodeBlock.getInfo(), fencedCodeBlock.getLiteral(), fencedCodeBlock);
            }
        });
    }

    private static void indentedCodeBlock(MarkwonVisitor.Builder builder) {
        builder.mo23135on(IndentedCodeBlock.class, new MarkwonVisitor.NodeVisitor<IndentedCodeBlock>() {
            public void visit(MarkwonVisitor markwonVisitor, IndentedCodeBlock indentedCodeBlock) {
                CorePlugin.visitCodeBlock(markwonVisitor, (String) null, indentedCodeBlock.getLiteral(), indentedCodeBlock);
            }
        });
    }

    private static void image(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Image.class, new MarkwonVisitor.NodeVisitor<Image>() {
            public void visit(MarkwonVisitor markwonVisitor, Image image) {
                SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Image.class);
                if (spanFactory == null) {
                    markwonVisitor.visitChildren(image);
                    return;
                }
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(image);
                if (length == markwonVisitor.length()) {
                    markwonVisitor.builder().append(65532);
                }
                MarkwonConfiguration configuration = markwonVisitor.configuration();
                String process = configuration.imageDestinationProcessor().process(image.getDestination());
                RenderProps renderProps = markwonVisitor.renderProps();
                ImageProps.DESTINATION.set(renderProps, process);
                ImageProps.REPLACEMENT_TEXT_IS_LINK.set(renderProps, Boolean.valueOf(image.getParent() instanceof Link));
                ImageProps.IMAGE_SIZE.set(renderProps, null);
                markwonVisitor.setSpans(length, spanFactory.getSpans(configuration, renderProps));
            }
        });
    }

    static void visitCodeBlock(MarkwonVisitor markwonVisitor, String str, String str2, Node node) {
        markwonVisitor.blockStart(node);
        int length = markwonVisitor.length();
        markwonVisitor.builder().append((char) Typography.nbsp).append(10).append(markwonVisitor.configuration().syntaxHighlight().highlight(str, str2));
        markwonVisitor.ensureNewLine();
        markwonVisitor.builder().append((char) Typography.nbsp);
        CoreProps.CODE_BLOCK_INFO.set(markwonVisitor.renderProps(), str);
        markwonVisitor.setSpansForNodeOptional(node, length);
        markwonVisitor.blockEnd(node);
    }

    private static void bulletList(MarkwonVisitor.Builder builder) {
        builder.mo23135on(BulletList.class, new SimpleBlockNodeVisitor());
    }

    private static void orderedList(MarkwonVisitor.Builder builder) {
        builder.mo23135on(OrderedList.class, new SimpleBlockNodeVisitor());
    }

    private static void listItem(MarkwonVisitor.Builder builder) {
        builder.mo23135on(ListItem.class, new MarkwonVisitor.NodeVisitor<ListItem>() {
            public void visit(MarkwonVisitor markwonVisitor, ListItem listItem) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(listItem);
                Block parent = listItem.getParent();
                if (parent instanceof OrderedList) {
                    OrderedList orderedList = (OrderedList) parent;
                    int startNumber = orderedList.getStartNumber();
                    CoreProps.LIST_ITEM_TYPE.set(markwonVisitor.renderProps(), CoreProps.ListItemType.ORDERED);
                    CoreProps.ORDERED_LIST_ITEM_NUMBER.set(markwonVisitor.renderProps(), Integer.valueOf(startNumber));
                    orderedList.setStartNumber(orderedList.getStartNumber() + 1);
                } else {
                    CoreProps.LIST_ITEM_TYPE.set(markwonVisitor.renderProps(), CoreProps.ListItemType.BULLET);
                    CoreProps.BULLET_LIST_ITEM_LEVEL.set(markwonVisitor.renderProps(), Integer.valueOf(CorePlugin.listLevel(listItem)));
                }
                markwonVisitor.setSpansForNodeOptional(listItem, length);
                if (markwonVisitor.hasNext(listItem)) {
                    markwonVisitor.ensureNewLine();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static int listLevel(Node node) {
        int i = 0;
        for (Node parent = node.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ListItem) {
                i++;
            }
        }
        return i;
    }

    private static void thematicBreak(MarkwonVisitor.Builder builder) {
        builder.mo23135on(ThematicBreak.class, new MarkwonVisitor.NodeVisitor<ThematicBreak>() {
            public void visit(MarkwonVisitor markwonVisitor, ThematicBreak thematicBreak) {
                markwonVisitor.blockStart(thematicBreak);
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) Typography.nbsp);
                markwonVisitor.setSpansForNodeOptional(thematicBreak, length);
                markwonVisitor.blockEnd(thematicBreak);
            }
        });
    }

    private static void heading(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Heading.class, new MarkwonVisitor.NodeVisitor<Heading>() {
            public void visit(MarkwonVisitor markwonVisitor, Heading heading) {
                markwonVisitor.blockStart(heading);
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(heading);
                CoreProps.HEADING_LEVEL.set(markwonVisitor.renderProps(), Integer.valueOf(heading.getLevel()));
                markwonVisitor.setSpansForNodeOptional(heading, length);
                markwonVisitor.blockEnd(heading);
            }
        });
    }

    private static void softLineBreak(MarkwonVisitor.Builder builder) {
        builder.mo23135on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() {
            public void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                markwonVisitor.builder().append(' ');
            }
        });
    }

    private static void hardLineBreak(MarkwonVisitor.Builder builder) {
        builder.mo23135on(HardLineBreak.class, new MarkwonVisitor.NodeVisitor<HardLineBreak>() {
            public void visit(MarkwonVisitor markwonVisitor, HardLineBreak hardLineBreak) {
                markwonVisitor.ensureNewLine();
            }
        });
    }

    private static void paragraph(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Paragraph.class, new MarkwonVisitor.NodeVisitor<Paragraph>() {
            public void visit(MarkwonVisitor markwonVisitor, Paragraph paragraph) {
                boolean access$200 = CorePlugin.isInTightList(paragraph);
                if (!access$200) {
                    markwonVisitor.blockStart(paragraph);
                }
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(paragraph);
                CoreProps.PARAGRAPH_IS_IN_TIGHT_LIST.set(markwonVisitor.renderProps(), Boolean.valueOf(access$200));
                markwonVisitor.setSpansForNodeOptional(paragraph, length);
                if (!access$200) {
                    markwonVisitor.blockEnd(paragraph);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean isInTightList(Paragraph paragraph) {
        Block parent = paragraph.getParent();
        if (parent == null) {
            return false;
        }
        Node parent2 = parent.getParent();
        if (parent2 instanceof ListBlock) {
            return ((ListBlock) parent2).isTight();
        }
        return false;
    }

    private static void link(MarkwonVisitor.Builder builder) {
        builder.mo23135on(Link.class, new MarkwonVisitor.NodeVisitor<Link>() {
            public void visit(MarkwonVisitor markwonVisitor, Link link) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(link);
                CoreProps.LINK_DESTINATION.set(markwonVisitor.renderProps(), link.getDestination());
                markwonVisitor.setSpansForNodeOptional(link, length);
            }
        });
    }
}
