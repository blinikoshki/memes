package editor.util;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, mo26107d2 = {"Leditor/util/ColorUtil;", "", "()V", "colorHexToInt", "", "hex", "", "colorIntToHex", "value", "isValidHexString", "", "resolveColor", "context", "Landroid/content/Context;", "colorRes", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorUtil.kt */
public final class ColorUtil {
    public static final ColorUtil INSTANCE = new ColorUtil();

    private ColorUtil() {
    }

    public final int colorHexToInt(String str) {
        Intrinsics.checkNotNullParameter(str, "hex");
        return Color.parseColor(str);
    }

    public final String colorIntToHex(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final boolean isValidHexString(String str) {
        Intrinsics.checkNotNullParameter(str, "hex");
        try {
            Color.parseColor(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final int resolveColor(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getColor(context, i);
    }
}
