package p015io.noties.markwon.image;

import android.graphics.drawable.Drawable;
import java.io.InputStream;
import java.util.Collection;

/* renamed from: io.noties.markwon.image.MediaDecoder */
public abstract class MediaDecoder {
    public abstract Drawable decode(String str, InputStream inputStream);

    public abstract Collection<String> supportedTypes();
}
