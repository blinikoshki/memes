package p015io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.Executor;
import p015io.noties.markwon.Markwon;

/* renamed from: io.noties.markwon.PrecomputedFutureTextSetterCompat */
public class PrecomputedFutureTextSetterCompat implements Markwon.TextSetter {
    private final Executor executor;

    public static PrecomputedFutureTextSetterCompat create(Executor executor2) {
        return new PrecomputedFutureTextSetterCompat(executor2);
    }

    public static PrecomputedFutureTextSetterCompat create() {
        return new PrecomputedFutureTextSetterCompat((Executor) null);
    }

    PrecomputedFutureTextSetterCompat(Executor executor2) {
        this.executor = executor2;
    }

    public void setText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
        if (textView instanceof AppCompatTextView) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) textView;
            appCompatTextView.setTextFuture(PrecomputedTextCompat.getTextFuture(spanned, appCompatTextView.getTextMetricsParamsCompat(), this.executor));
            runnable.run();
            return;
        }
        throw new IllegalStateException("TextView provided is not an instance of AppCompatTextView, cannot call setTextFuture(), textView: " + textView);
    }
}
