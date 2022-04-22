package p015io.noties.markwon.image.gif;

import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import p015io.noties.markwon.image.MediaDecoder;
import pl.droidsonroids.gif.GifDrawable;

/* renamed from: io.noties.markwon.image.gif.GifMediaDecoder */
public class GifMediaDecoder extends MediaDecoder {
    public static final String CONTENT_TYPE = "image/gif";
    private final boolean autoPlayGif;

    public static GifMediaDecoder create() {
        return create(true);
    }

    public static GifMediaDecoder create(boolean z) {
        return new GifMediaDecoder(z);
    }

    protected GifMediaDecoder(boolean z) {
        this.autoPlayGif = z;
        validate();
    }

    public Drawable decode(String str, InputStream inputStream) {
        try {
            try {
                GifDrawable newGifDrawable = newGifDrawable(readBytes(inputStream));
                if (!this.autoPlayGif) {
                    newGifDrawable.pause();
                }
                return newGifDrawable;
            } catch (IOException e) {
                throw new IllegalStateException("Exception creating GifDrawable", e);
            }
        } catch (IOException e2) {
            throw new IllegalStateException("Cannot read GIF input-stream", e2);
        }
    }

    public Collection<String> supportedTypes() {
        return Collections.singleton("image/gif");
    }

    /* access modifiers changed from: protected */
    public GifDrawable newGifDrawable(byte[] bArr) throws IOException {
        return new GifDrawable(bArr);
    }

    protected static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void validate() {
        if (!GifSupport.hasGifSupport()) {
            throw new IllegalStateException(GifSupport.missingMessage());
        }
    }
}
