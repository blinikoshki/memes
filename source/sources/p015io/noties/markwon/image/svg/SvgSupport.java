package p015io.noties.markwon.image.svg;

import android.util.Log;

/* renamed from: io.noties.markwon.image.svg.SvgSupport */
public abstract class SvgSupport {
    private static final boolean HAS_SVG;

    static String missingMessage() {
        return "`com.caverock:androidsvg:*` dependency is missing, please add to your project explicitly if you wish to use SVG media-decoder";
    }

    static {
        boolean z;
        try {
            Class.forName("com.caverock.androidsvg.SVG");
            z = true;
        } catch (Throwable unused) {
            Log.w("MarkwonImagesPlugin", missingMessage());
            z = false;
        }
        HAS_SVG = z;
    }

    public static boolean hasSvgSupport() {
        return HAS_SVG;
    }

    private SvgSupport() {
    }
}
