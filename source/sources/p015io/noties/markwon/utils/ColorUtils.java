package p015io.noties.markwon.utils;

import android.graphics.Color;
import androidx.core.view.ViewCompat;

/* renamed from: io.noties.markwon.utils.ColorUtils */
public abstract class ColorUtils {
    public static int applyAlpha(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }

    public static int blend(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (f * ((float) Color.blue(i2)))));
    }

    private ColorUtils() {
    }
}
