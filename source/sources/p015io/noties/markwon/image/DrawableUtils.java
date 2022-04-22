package p015io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: io.noties.markwon.image.DrawableUtils */
public abstract class DrawableUtils {
    public static Rect intrinsicBounds(Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static void applyIntrinsicBounds(Drawable drawable) {
        drawable.setBounds(intrinsicBounds(drawable));
    }

    public static void applyIntrinsicBoundsIfEmpty(Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(intrinsicBounds(drawable));
        }
    }

    private DrawableUtils() {
    }
}
