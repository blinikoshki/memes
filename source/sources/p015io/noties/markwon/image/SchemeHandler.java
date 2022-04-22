package p015io.noties.markwon.image;

import android.net.Uri;
import java.util.Collection;

/* renamed from: io.noties.markwon.image.SchemeHandler */
public abstract class SchemeHandler {
    public abstract ImageItem handle(String str, Uri uri);

    public abstract Collection<String> supportedSchemes();
}
