package p015io.noties.markwon;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import java.util.List;
import org.commonmark.node.Node;
import p015io.noties.markwon.core.CorePlugin;

/* renamed from: io.noties.markwon.Markwon */
public abstract class Markwon {

    /* renamed from: io.noties.markwon.Markwon$Builder */
    public interface Builder {
        Builder bufferType(TextView.BufferType bufferType);

        Markwon build();

        Builder fallbackToRawInputWhenEmpty(boolean z);

        Builder textSetter(TextSetter textSetter);

        Builder usePlugin(MarkwonPlugin markwonPlugin);

        Builder usePlugins(Iterable<? extends MarkwonPlugin> iterable);
    }

    /* renamed from: io.noties.markwon.Markwon$TextSetter */
    public interface TextSetter {
        void setText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable);
    }

    public abstract MarkwonConfiguration configuration();

    public abstract <P extends MarkwonPlugin> P getPlugin(Class<P> cls);

    public abstract List<? extends MarkwonPlugin> getPlugins();

    public abstract boolean hasPlugin(Class<? extends MarkwonPlugin> cls);

    public abstract Node parse(String str);

    public abstract Spanned render(Node node);

    public abstract <P extends MarkwonPlugin> P requirePlugin(Class<P> cls);

    public abstract void setMarkdown(TextView textView, String str);

    public abstract void setParsedMarkdown(TextView textView, Spanned spanned);

    public abstract Spanned toMarkdown(String str);

    public static Markwon create(Context context) {
        return builder(context).usePlugin(CorePlugin.create()).build();
    }

    public static Builder builder(Context context) {
        return new MarkwonBuilderImpl(context).usePlugin(CorePlugin.create());
    }

    public static Builder builderNoCore(Context context) {
        return new MarkwonBuilderImpl(context);
    }
}
