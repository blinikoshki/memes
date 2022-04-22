package p015io.noties.markwon.image.gif;

import android.util.Log;

/* renamed from: io.noties.markwon.image.gif.GifSupport */
public abstract class GifSupport {
    private static boolean HAS_GIF;

    static String missingMessage() {
        return "`pl.droidsonroids.gif:android-gif-drawable:*` dependency is missing, please add to your project explicitly if you wish to use GIF media-decoder";
    }

    static {
        boolean z;
        try {
            Class.forName("pl.droidsonroids.gif.GifDrawable");
            z = true;
        } catch (Throwable unused) {
            Log.w("MarkwonImagesPlugin", missingMessage());
            z = false;
        }
        HAS_GIF = z;
    }

    public static boolean hasGifSupport() {
        return HAS_GIF;
    }

    private GifSupport() {
    }
}
