package p015io.noties.markwon.image;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;

/* renamed from: io.noties.markwon.image.DefaultMediaDecoder */
public class DefaultMediaDecoder extends MediaDecoder {
    private final Resources resources;

    public static DefaultMediaDecoder create() {
        return new DefaultMediaDecoder(Resources.getSystem());
    }

    public static DefaultMediaDecoder create(Resources resources2) {
        return new DefaultMediaDecoder(resources2);
    }

    DefaultMediaDecoder(Resources resources2) {
        this.resources = resources2;
    }

    public Drawable decode(String str, InputStream inputStream) {
        try {
            return new BitmapDrawable(this.resources, BitmapFactory.decodeStream(inputStream));
        } catch (Throwable th) {
            throw new IllegalStateException("Exception decoding input-stream", th);
        }
    }

    public Collection<String> supportedTypes() {
        return Collections.emptySet();
    }
}
