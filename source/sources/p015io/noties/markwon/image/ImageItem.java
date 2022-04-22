package p015io.noties.markwon.image;

import android.graphics.drawable.Drawable;
import java.io.InputStream;

/* renamed from: io.noties.markwon.image.ImageItem */
public abstract class ImageItem {
    public abstract WithDecodingNeeded getAsWithDecodingNeeded();

    public abstract WithResult getAsWithResult();

    public abstract boolean hasDecodingNeeded();

    public abstract boolean hasResult();

    public static ImageItem withResult(Drawable drawable) {
        return new WithResult(drawable);
    }

    public static ImageItem withDecodingNeeded(String str, InputStream inputStream) {
        return new WithDecodingNeeded(str, inputStream);
    }

    private ImageItem() {
    }

    /* renamed from: io.noties.markwon.image.ImageItem$WithResult */
    public static class WithResult extends ImageItem {
        private final Drawable result;

        public WithResult getAsWithResult() {
            return this;
        }

        public boolean hasDecodingNeeded() {
            return false;
        }

        public boolean hasResult() {
            return true;
        }

        private WithResult(Drawable drawable) {
            super();
            this.result = drawable;
        }

        public Drawable result() {
            return this.result;
        }

        public WithDecodingNeeded getAsWithDecodingNeeded() {
            throw new IllegalStateException();
        }
    }

    /* renamed from: io.noties.markwon.image.ImageItem$WithDecodingNeeded */
    public static class WithDecodingNeeded extends ImageItem {
        private final String contentType;
        private final InputStream inputStream;

        public WithDecodingNeeded getAsWithDecodingNeeded() {
            return this;
        }

        public boolean hasDecodingNeeded() {
            return true;
        }

        public boolean hasResult() {
            return false;
        }

        private WithDecodingNeeded(String str, InputStream inputStream2) {
            super();
            this.contentType = str;
            this.inputStream = inputStream2;
        }

        public String contentType() {
            return this.contentType;
        }

        public InputStream inputStream() {
            return this.inputStream;
        }

        public WithResult getAsWithResult() {
            throw new IllegalStateException();
        }
    }
}
