package p015io.noties.markwon.image.svg;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import p015io.noties.markwon.image.MediaDecoder;

/* renamed from: io.noties.markwon.image.svg.SvgMediaDecoder */
public class SvgMediaDecoder extends MediaDecoder {
    public static final String CONTENT_TYPE = "image/svg+xml";
    private final Resources resources;

    public static SvgMediaDecoder create() {
        return create(Resources.getSystem());
    }

    public static SvgMediaDecoder create(Resources resources2) {
        return new SvgMediaDecoder(resources2);
    }

    SvgMediaDecoder(Resources resources2) {
        this.resources = resources2;
        validate();
    }

    public Drawable decode(String str, InputStream inputStream) {
        try {
            SVG fromInputStream = SVG.getFromInputStream(inputStream);
            float documentWidth = fromInputStream.getDocumentWidth();
            float documentHeight = fromInputStream.getDocumentHeight();
            float f = this.resources.getDisplayMetrics().density;
            Bitmap createBitmap = Bitmap.createBitmap((int) ((documentWidth * f) + 0.5f), (int) ((documentHeight * f) + 0.5f), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(f, f);
            fromInputStream.renderToCanvas(canvas);
            return new BitmapDrawable(this.resources, createBitmap);
        } catch (SVGParseException e) {
            throw new IllegalStateException("Exception decoding SVG", e);
        }
    }

    public Collection<String> supportedTypes() {
        return Collections.singleton("image/svg+xml");
    }

    private static void validate() {
        if (!SvgSupport.hasSvgSupport()) {
            throw new IllegalStateException(SvgSupport.missingMessage());
        }
    }
}
