package p015io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import p015io.noties.markwon.C1905R;

/* renamed from: io.noties.markwon.image.AsyncDrawableScheduler */
public abstract class AsyncDrawableScheduler {
    public static void schedule(final TextView textView) {
        Integer num = (Integer) textView.getTag(C1905R.C1908id.markwon_drawables_scheduler_last_text_hashcode);
        int hashCode = textView.getText().hashCode();
        if (num == null || num.intValue() != hashCode) {
            textView.setTag(C1905R.C1908id.markwon_drawables_scheduler_last_text_hashcode, Integer.valueOf(hashCode));
            AsyncDrawableSpan[] extractSpans = extractSpans(textView);
            if (extractSpans != null && extractSpans.length > 0) {
                if (textView.getTag(C1905R.C1908id.markwon_drawables_scheduler) == null) {
                    C19391 r1 = new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                        }

                        public void onViewDetachedFromWindow(View view) {
                            AsyncDrawableScheduler.unschedule(textView);
                            view.removeOnAttachStateChangeListener(this);
                            view.setTag(C1905R.C1908id.markwon_drawables_scheduler, (Object) null);
                        }
                    };
                    textView.addOnAttachStateChangeListener(r1);
                    textView.setTag(C1905R.C1908id.markwon_drawables_scheduler, r1);
                }
                TextViewInvalidator textViewInvalidator = new TextViewInvalidator(textView);
                for (AsyncDrawableSpan drawable : extractSpans) {
                    AsyncDrawable drawable2 = drawable.getDrawable();
                    drawable2.setCallback2(new DrawableCallbackImpl(textView, textViewInvalidator, drawable2.getBounds()));
                }
            }
        }
    }

    public static void unschedule(TextView textView) {
        if (textView.getTag(C1905R.C1908id.markwon_drawables_scheduler_last_text_hashcode) != null) {
            textView.setTag(C1905R.C1908id.markwon_drawables_scheduler_last_text_hashcode, (Object) null);
            AsyncDrawableSpan[] extractSpans = extractSpans(textView);
            if (extractSpans != null && extractSpans.length > 0) {
                for (AsyncDrawableSpan drawable : extractSpans) {
                    drawable.getDrawable().setCallback2((Drawable.Callback) null);
                }
            }
        }
    }

    private static AsyncDrawableSpan[] extractSpans(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (AsyncDrawableSpan[]) ((Spanned) text).getSpans(0, length, AsyncDrawableSpan.class);
    }

    private AsyncDrawableScheduler() {
    }

    /* renamed from: io.noties.markwon.image.AsyncDrawableScheduler$DrawableCallbackImpl */
    private static class DrawableCallbackImpl implements Drawable.Callback {
        private final Invalidator invalidator;
        private Rect previousBounds;
        private final TextView view;

        /* renamed from: io.noties.markwon.image.AsyncDrawableScheduler$DrawableCallbackImpl$Invalidator */
        interface Invalidator {
            void invalidate();
        }

        DrawableCallbackImpl(TextView textView, Invalidator invalidator2, Rect rect) {
            this.view = textView;
            this.invalidator = invalidator2;
            this.previousBounds = new Rect(rect);
        }

        public void invalidateDrawable(final Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.view.post(new Runnable() {
                    public void run() {
                        DrawableCallbackImpl.this.invalidateDrawable(drawable);
                    }
                });
                return;
            }
            Rect bounds = drawable.getBounds();
            if (!this.previousBounds.equals(bounds)) {
                this.invalidator.invalidate();
                this.previousBounds = new Rect(bounds);
                return;
            }
            this.view.postInvalidate();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.view.postDelayed(runnable, j - SystemClock.uptimeMillis());
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.view.removeCallbacks(runnable);
        }
    }

    /* renamed from: io.noties.markwon.image.AsyncDrawableScheduler$TextViewInvalidator */
    private static class TextViewInvalidator implements DrawableCallbackImpl.Invalidator, Runnable {
        private final TextView textView;

        TextViewInvalidator(TextView textView2) {
            this.textView = textView2;
        }

        public void invalidate() {
            this.textView.removeCallbacks(this);
            this.textView.post(this);
        }

        public void run() {
            TextView textView2 = this.textView;
            textView2.setText(textView2.getText());
        }
    }
}
