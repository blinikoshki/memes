package p015io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.commonmark.parser.Parser;
import p015io.noties.markwon.Markwon;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonSpansFactoryImpl;
import p015io.noties.markwon.MarkwonVisitorImpl;
import p015io.noties.markwon.core.MarkwonTheme;

/* renamed from: io.noties.markwon.MarkwonBuilderImpl */
class MarkwonBuilderImpl implements Markwon.Builder {
    private TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
    private final Context context;
    private boolean fallbackToRawInputWhenEmpty = true;
    private final List<MarkwonPlugin> plugins = new ArrayList(3);
    private Markwon.TextSetter textSetter;

    MarkwonBuilderImpl(Context context2) {
        this.context = context2;
    }

    public Markwon.Builder bufferType(TextView.BufferType bufferType2) {
        this.bufferType = bufferType2;
        return this;
    }

    public Markwon.Builder textSetter(Markwon.TextSetter textSetter2) {
        this.textSetter = textSetter2;
        return this;
    }

    public Markwon.Builder usePlugin(MarkwonPlugin markwonPlugin) {
        this.plugins.add(markwonPlugin);
        return this;
    }

    public Markwon.Builder usePlugins(Iterable<? extends MarkwonPlugin> iterable) {
        for (MarkwonPlugin markwonPlugin : iterable) {
            Objects.requireNonNull(markwonPlugin);
            this.plugins.add(markwonPlugin);
        }
        return this;
    }

    public Markwon.Builder fallbackToRawInputWhenEmpty(boolean z) {
        this.fallbackToRawInputWhenEmpty = z;
        return this;
    }

    public Markwon build() {
        if (!this.plugins.isEmpty()) {
            List<MarkwonPlugin> preparePlugins = preparePlugins(this.plugins);
            Parser.Builder builder = new Parser.Builder();
            MarkwonTheme.Builder builderWithDefaults = MarkwonTheme.builderWithDefaults(this.context);
            MarkwonConfiguration.Builder builder2 = new MarkwonConfiguration.Builder();
            MarkwonVisitorImpl.BuilderImpl builderImpl = new MarkwonVisitorImpl.BuilderImpl();
            MarkwonSpansFactoryImpl.BuilderImpl builderImpl2 = new MarkwonSpansFactoryImpl.BuilderImpl();
            for (MarkwonPlugin next : preparePlugins) {
                next.configureParser(builder);
                next.configureTheme(builderWithDefaults);
                next.configureConfiguration(builder2);
                next.configureVisitor(builderImpl);
                next.configureSpansFactory(builderImpl2);
            }
            MarkwonConfiguration build = builder2.build(builderWithDefaults.build(), builderImpl2.build());
            return new MarkwonImpl(this.bufferType, this.textSetter, builder.build(), MarkwonVisitorFactory.create(builderImpl, build), build, Collections.unmodifiableList(preparePlugins), this.fallbackToRawInputWhenEmpty);
        }
        throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
    }

    private static List<MarkwonPlugin> preparePlugins(List<MarkwonPlugin> list) {
        return new RegistryImpl(list).process();
    }
}
