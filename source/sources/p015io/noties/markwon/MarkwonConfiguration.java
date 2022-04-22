package p015io.noties.markwon;

import p015io.noties.markwon.core.MarkwonTheme;
import p015io.noties.markwon.image.AsyncDrawableLoader;
import p015io.noties.markwon.image.ImageSizeResolver;
import p015io.noties.markwon.image.ImageSizeResolverDef;
import p015io.noties.markwon.image.destination.ImageDestinationProcessor;
import p015io.noties.markwon.syntax.SyntaxHighlight;
import p015io.noties.markwon.syntax.SyntaxHighlightNoOp;

/* renamed from: io.noties.markwon.MarkwonConfiguration */
public class MarkwonConfiguration {
    private final AsyncDrawableLoader asyncDrawableLoader;
    private final ImageDestinationProcessor imageDestinationProcessor;
    private final ImageSizeResolver imageSizeResolver;
    private final LinkResolver linkResolver;
    private final MarkwonSpansFactory spansFactory;
    private final SyntaxHighlight syntaxHighlight;
    private final MarkwonTheme theme;

    public static Builder builder() {
        return new Builder();
    }

    private MarkwonConfiguration(Builder builder) {
        this.theme = builder.theme;
        this.asyncDrawableLoader = builder.asyncDrawableLoader;
        this.syntaxHighlight = builder.syntaxHighlight;
        this.linkResolver = builder.linkResolver;
        this.imageDestinationProcessor = builder.imageDestinationProcessor;
        this.imageSizeResolver = builder.imageSizeResolver;
        this.spansFactory = builder.spansFactory;
    }

    public MarkwonTheme theme() {
        return this.theme;
    }

    public AsyncDrawableLoader asyncDrawableLoader() {
        return this.asyncDrawableLoader;
    }

    public SyntaxHighlight syntaxHighlight() {
        return this.syntaxHighlight;
    }

    public LinkResolver linkResolver() {
        return this.linkResolver;
    }

    public ImageDestinationProcessor imageDestinationProcessor() {
        return this.imageDestinationProcessor;
    }

    public ImageSizeResolver imageSizeResolver() {
        return this.imageSizeResolver;
    }

    public MarkwonSpansFactory spansFactory() {
        return this.spansFactory;
    }

    /* renamed from: io.noties.markwon.MarkwonConfiguration$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public AsyncDrawableLoader asyncDrawableLoader;
        /* access modifiers changed from: private */
        public ImageDestinationProcessor imageDestinationProcessor;
        /* access modifiers changed from: private */
        public ImageSizeResolver imageSizeResolver;
        /* access modifiers changed from: private */
        public LinkResolver linkResolver;
        /* access modifiers changed from: private */
        public MarkwonSpansFactory spansFactory;
        /* access modifiers changed from: private */
        public SyntaxHighlight syntaxHighlight;
        /* access modifiers changed from: private */
        public MarkwonTheme theme;

        Builder() {
        }

        public Builder asyncDrawableLoader(AsyncDrawableLoader asyncDrawableLoader2) {
            this.asyncDrawableLoader = asyncDrawableLoader2;
            return this;
        }

        public Builder syntaxHighlight(SyntaxHighlight syntaxHighlight2) {
            this.syntaxHighlight = syntaxHighlight2;
            return this;
        }

        public Builder linkResolver(LinkResolver linkResolver2) {
            this.linkResolver = linkResolver2;
            return this;
        }

        public Builder imageDestinationProcessor(ImageDestinationProcessor imageDestinationProcessor2) {
            this.imageDestinationProcessor = imageDestinationProcessor2;
            return this;
        }

        public Builder imageSizeResolver(ImageSizeResolver imageSizeResolver2) {
            this.imageSizeResolver = imageSizeResolver2;
            return this;
        }

        public MarkwonConfiguration build(MarkwonTheme markwonTheme, MarkwonSpansFactory markwonSpansFactory) {
            this.theme = markwonTheme;
            this.spansFactory = markwonSpansFactory;
            if (this.asyncDrawableLoader == null) {
                this.asyncDrawableLoader = AsyncDrawableLoader.noOp();
            }
            if (this.syntaxHighlight == null) {
                this.syntaxHighlight = new SyntaxHighlightNoOp();
            }
            if (this.linkResolver == null) {
                this.linkResolver = new LinkResolverDef();
            }
            if (this.imageDestinationProcessor == null) {
                this.imageDestinationProcessor = ImageDestinationProcessor.noOp();
            }
            if (this.imageSizeResolver == null) {
                this.imageSizeResolver = new ImageSizeResolverDef();
            }
            return new MarkwonConfiguration(this);
        }
    }
}
