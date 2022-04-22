package p015io.noties.markwon.utils;

import android.graphics.drawable.Drawable;

@Deprecated
/* renamed from: io.noties.markwon.utils.DrawableUtils */
public abstract class DrawableUtils {
    public static void intrinsicBounds(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private DrawableUtils() {
    }
}
