package p015io.noties.markwon;

import p015io.noties.markwon.MarkwonVisitor;

/* renamed from: io.noties.markwon.MarkwonVisitorFactory */
abstract class MarkwonVisitorFactory {
    /* access modifiers changed from: package-private */
    public abstract MarkwonVisitor create();

    MarkwonVisitorFactory() {
    }

    static MarkwonVisitorFactory create(final MarkwonVisitor.Builder builder, final MarkwonConfiguration markwonConfiguration) {
        return new MarkwonVisitorFactory() {
            /* access modifiers changed from: package-private */
            public MarkwonVisitor create() {
                return MarkwonVisitor.Builder.this.build(markwonConfiguration, new RenderPropsImpl());
            }
        };
    }
}
