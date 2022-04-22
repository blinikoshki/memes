package org.commonmark.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

public class Parser {
    private final List<BlockParserFactory> blockParserFactories;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final InlineParserFactory inlineParserFactory;
    private final List<PostProcessor> postProcessors;

    public interface ParserExtension extends Extension {
        void extend(Builder builder);
    }

    private Parser(Builder builder) {
        this.blockParserFactories = DocumentParser.calculateBlockParserFactories(builder.blockParserFactories, builder.enabledBlockTypes);
        InlineParserFactory access$200 = builder.getInlineParserFactory();
        this.inlineParserFactory = access$200;
        this.postProcessors = builder.postProcessors;
        List<DelimiterProcessor> access$400 = builder.delimiterProcessors;
        this.delimiterProcessors = access$400;
        access$200.create(new InlineParserContextImpl(access$400, Collections.emptyMap()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public Node parse(String str) {
        Objects.requireNonNull(str, "input must not be null");
        return postProcess(createDocumentParser().parse(str));
    }

    public Node parseReader(Reader reader) throws IOException {
        Objects.requireNonNull(reader, "input must not be null");
        return postProcess(createDocumentParser().parse(reader));
    }

    private DocumentParser createDocumentParser() {
        return new DocumentParser(this.blockParserFactories, this.inlineParserFactory, this.delimiterProcessors);
    }

    private Node postProcess(Node node) {
        for (PostProcessor process : this.postProcessors) {
            node = process.process(node);
        }
        return node;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final List<BlockParserFactory> blockParserFactories = new ArrayList();
        /* access modifiers changed from: private */
        public final List<DelimiterProcessor> delimiterProcessors = new ArrayList();
        /* access modifiers changed from: private */
        public Set<Class<? extends Block>> enabledBlockTypes = DocumentParser.getDefaultBlockParserTypes();
        private InlineParserFactory inlineParserFactory;
        /* access modifiers changed from: private */
        public final List<PostProcessor> postProcessors = new ArrayList();

        public Parser build() {
            return new Parser(this);
        }

        public Builder extensions(Iterable<? extends Extension> iterable) {
            Objects.requireNonNull(iterable, "extensions must not be null");
            for (Extension extension : iterable) {
                if (extension instanceof ParserExtension) {
                    ((ParserExtension) extension).extend(this);
                }
            }
            return this;
        }

        public Builder enabledBlockTypes(Set<Class<? extends Block>> set) {
            Objects.requireNonNull(set, "enabledBlockTypes must not be null");
            this.enabledBlockTypes = set;
            return this;
        }

        public Builder customBlockParserFactory(BlockParserFactory blockParserFactory) {
            Objects.requireNonNull(blockParserFactory, "blockParserFactory must not be null");
            this.blockParserFactories.add(blockParserFactory);
            return this;
        }

        public Builder customDelimiterProcessor(DelimiterProcessor delimiterProcessor) {
            Objects.requireNonNull(delimiterProcessor, "delimiterProcessor must not be null");
            this.delimiterProcessors.add(delimiterProcessor);
            return this;
        }

        public Builder postProcessor(PostProcessor postProcessor) {
            Objects.requireNonNull(postProcessor, "postProcessor must not be null");
            this.postProcessors.add(postProcessor);
            return this;
        }

        public Builder inlineParserFactory(InlineParserFactory inlineParserFactory2) {
            this.inlineParserFactory = inlineParserFactory2;
            return this;
        }

        /* access modifiers changed from: private */
        public InlineParserFactory getInlineParserFactory() {
            InlineParserFactory inlineParserFactory2 = this.inlineParserFactory;
            if (inlineParserFactory2 != null) {
                return inlineParserFactory2;
            }
            return new InlineParserFactory() {
                public InlineParser create(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }
    }
}
