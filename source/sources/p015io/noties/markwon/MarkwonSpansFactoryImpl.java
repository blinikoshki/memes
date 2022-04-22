package p015io.noties.markwon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import p015io.noties.markwon.MarkwonSpansFactory;

/* renamed from: io.noties.markwon.MarkwonSpansFactoryImpl */
class MarkwonSpansFactoryImpl implements MarkwonSpansFactory {
    private final Map<Class<? extends Node>, SpanFactory> factories;

    MarkwonSpansFactoryImpl(Map<Class<? extends Node>, SpanFactory> map) {
        this.factories = map;
    }

    public <N extends Node> SpanFactory get(Class<N> cls) {
        return this.factories.get(cls);
    }

    public <N extends Node> SpanFactory require(Class<N> cls) {
        SpanFactory spanFactory = get(cls);
        if (spanFactory != null) {
            return spanFactory;
        }
        throw new NullPointerException(cls.getName());
    }

    /* renamed from: io.noties.markwon.MarkwonSpansFactoryImpl$BuilderImpl */
    static class BuilderImpl implements MarkwonSpansFactory.Builder {
        private final Map<Class<? extends Node>, SpanFactory> factories = new HashMap(3);

        BuilderImpl() {
        }

        public <N extends Node> MarkwonSpansFactory.Builder setFactory(Class<N> cls, SpanFactory spanFactory) {
            if (spanFactory == null) {
                this.factories.remove(cls);
            } else {
                this.factories.put(cls, spanFactory);
            }
            return this;
        }

        @Deprecated
        public <N extends Node> MarkwonSpansFactory.Builder addFactory(Class<N> cls, SpanFactory spanFactory) {
            return prependFactory(cls, spanFactory);
        }

        public <N extends Node> MarkwonSpansFactory.Builder appendFactory(Class<N> cls, SpanFactory spanFactory) {
            SpanFactory spanFactory2 = this.factories.get(cls);
            if (spanFactory2 == null) {
                this.factories.put(cls, spanFactory);
            } else if (spanFactory2 instanceof CompositeSpanFactory) {
                ((CompositeSpanFactory) spanFactory2).factories.add(0, spanFactory);
            } else {
                this.factories.put(cls, new CompositeSpanFactory(spanFactory, spanFactory2));
            }
            return this;
        }

        public <N extends Node> MarkwonSpansFactory.Builder prependFactory(Class<N> cls, SpanFactory spanFactory) {
            SpanFactory spanFactory2 = this.factories.get(cls);
            if (spanFactory2 == null) {
                this.factories.put(cls, spanFactory);
            } else if (spanFactory2 instanceof CompositeSpanFactory) {
                ((CompositeSpanFactory) spanFactory2).factories.add(spanFactory);
            } else {
                this.factories.put(cls, new CompositeSpanFactory(spanFactory2, spanFactory));
            }
            return this;
        }

        public <N extends Node> SpanFactory getFactory(Class<N> cls) {
            return this.factories.get(cls);
        }

        public <N extends Node> SpanFactory requireFactory(Class<N> cls) {
            SpanFactory factory = getFactory(cls);
            if (factory != null) {
                return factory;
            }
            throw new NullPointerException(cls.getName());
        }

        public MarkwonSpansFactory build() {
            return new MarkwonSpansFactoryImpl(Collections.unmodifiableMap(this.factories));
        }
    }

    /* renamed from: io.noties.markwon.MarkwonSpansFactoryImpl$CompositeSpanFactory */
    static class CompositeSpanFactory implements SpanFactory {
        final List<SpanFactory> factories;

        CompositeSpanFactory(SpanFactory spanFactory, SpanFactory spanFactory2) {
            ArrayList arrayList = new ArrayList(3);
            this.factories = arrayList;
            arrayList.add(spanFactory);
            arrayList.add(spanFactory2);
        }

        public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
            int size = this.factories.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                objArr[i] = this.factories.get(i).getSpans(markwonConfiguration, renderProps);
            }
            return objArr;
        }
    }
}
