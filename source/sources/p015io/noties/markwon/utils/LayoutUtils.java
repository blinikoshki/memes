package p015io.noties.markwon.utils;

import android.os.Build;
import android.text.Layout;

/* renamed from: io.noties.markwon.utils.LayoutUtils */
public abstract class LayoutUtils {
    private static final float DEFAULT_EXTRA = 0.0f;
    private static final float DEFAULT_MULTIPLIER = 1.0f;

    public static int getLineBottomWithoutPaddingAndSpacing(Layout layout, int i) {
        int lineBottom = layout.getLineBottom(i);
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT >= 19;
        boolean z3 = i == layout.getLineCount() - 1;
        float spacingAdd = layout.getSpacingAdd();
        float spacingMultiplier = layout.getSpacingMultiplier();
        if (!(spacingAdd == 0.0f && spacingMultiplier == 1.0f)) {
            z = true;
        }
        if (z && (!z3 || !z2)) {
            if (Float.compare(1.0f, spacingMultiplier) != 0) {
                float lineHeight = (float) getLineHeight(layout, i);
                spacingAdd = lineHeight - ((lineHeight - spacingAdd) / spacingMultiplier);
            }
            lineBottom = (int) ((((float) lineBottom) - spacingAdd) + 0.5f);
        }
        return (!z3 || i != layout.getLineCount() - 1) ? lineBottom : lineBottom - layout.getBottomPadding();
    }

    public static int getLineTopWithoutPadding(Layout layout, int i) {
        int lineTop = layout.getLineTop(i);
        return i == 0 ? lineTop - layout.getTopPadding() : lineTop;
    }

    public static int getLineHeight(Layout layout, int i) {
        return layout.getLineTop(i + 1) - layout.getLineTop(i);
    }

    private LayoutUtils() {
    }
}
