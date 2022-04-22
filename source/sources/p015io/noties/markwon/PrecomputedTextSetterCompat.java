package p015io.noties.markwon;

import android.os.Build;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import p015io.noties.markwon.Markwon;

/* renamed from: io.noties.markwon.PrecomputedTextSetterCompat */
public class PrecomputedTextSetterCompat implements Markwon.TextSetter {
    private final Executor executor;

    public static PrecomputedTextSetterCompat create(Executor executor2) {
        return new PrecomputedTextSetterCompat(executor2);
    }

    PrecomputedTextSetterCompat(Executor executor2) {
        this.executor = executor2;
    }

    public void setText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
        if (Build.VERSION.SDK_INT < 21) {
            applyText(textView, spanned, bufferType, runnable);
            return;
        }
        final WeakReference weakReference = new WeakReference(textView);
        final Spanned spanned2 = spanned;
        final TextView.BufferType bufferType2 = bufferType;
        final Runnable runnable2 = runnable;
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    PrecomputedTextCompat access$000 = PrecomputedTextSetterCompat.precomputedText((TextView) weakReference.get(), spanned2);
                    if (access$000 != null) {
                        PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), access$000, bufferType2, runnable2);
                    }
                } catch (Throwable th) {
                    Log.e("PrecomputdTxtSetterCmpt", "Exception during pre-computing text", th);
                    PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), spanned2, bufferType2, runnable2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static PrecomputedTextCompat precomputedText(TextView textView, Spanned spanned) {
        PrecomputedTextCompat.Params params;
        if (textView == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            params = new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        } else {
            PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(textView.getPaint());
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            }
            params = builder.build();
        }
        return PrecomputedTextCompat.create(spanned, params);
    }

    /* access modifiers changed from: private */
    public static void applyText(final TextView textView, final Spanned spanned, final TextView.BufferType bufferType, final Runnable runnable) {
        if (textView != null) {
            textView.post(new Runnable() {
                public void run() {
                    textView.setText(spanned, bufferType);
                    runnable.run();
                }
            });
        }
    }
}
