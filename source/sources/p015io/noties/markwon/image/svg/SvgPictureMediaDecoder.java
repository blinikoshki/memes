package p015io.noties.markwon.image.svg;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import p015io.noties.markwon.image.MediaDecoder;

/* renamed from: io.noties.markwon.image.svg.SvgPictureMediaDecoder */
public class SvgPictureMediaDecoder extends MediaDecoder {
    public static final String CONTENT_TYPE = "image/svg+xml";

    public static SvgPictureMediaDecoder create() {
        return new SvgPictureMediaDecoder();
    }

    public Drawable decode(String str, InputStream inputStream) {
        try {
            return new PictureDrawable(SVG.getFromInputStream(inputStream).renderToPicture());
        } catch (SVGParseException e) {
            throw new IllegalStateException("Exception decoding SVG", e);
        }
    }

    public Collection<String> supportedTypes() {
        return Collections.singleton("image/svg+xml");
    }
}
