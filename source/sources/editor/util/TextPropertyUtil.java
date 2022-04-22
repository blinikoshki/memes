package editor.util;

import androidx.core.view.GravityCompat;
import editor.editor.equipment.text.TextConfig;
import editor.optionsui.text.textedit.TextAlignment;
import editor.optionsui.text.textedit.TextCapMode;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¨\u0006\u0015"}, mo26107d2 = {"Leditor/util/TextPropertyUtil;", "", "()V", "alignmentToGravity", "", "alignment", "Leditor/optionsui/text/textedit/TextAlignment;", "gravityToAlignment", "gravity", "marginPercentToValue", "percent", "marginValueToPercent", "value", "sizePercentToValue", "", "transformTextToCapMode", "", "capMode", "Leditor/optionsui/text/textedit/TextCapMode;", "charSequence", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextPropertyUtil.kt */
public final class TextPropertyUtil {
    public static final TextPropertyUtil INSTANCE = new TextPropertyUtil();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextAlignment.LEFT.ordinal()] = 1;
            iArr[TextAlignment.CENTER.ordinal()] = 2;
            iArr[TextAlignment.RIGHT.ordinal()] = 3;
        }
    }

    public final int marginPercentToValue(int i) {
        return (i * 1) + 0;
    }

    private TextPropertyUtil() {
    }

    public final float sizePercentToValue(int i) {
        return (((float) i) * ((TextConfig.INSTANCE.getMAX_SIZE() - TextConfig.INSTANCE.getMIN_SIZE()) / ((float) 100))) + TextConfig.INSTANCE.getMIN_SIZE();
    }

    public final int marginValueToPercent(int i) {
        return ((i + 0) * 100) / 100;
    }

    public final String transformTextToCapMode(TextCapMode textCapMode, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(textCapMode, "capMode");
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        String obj = charSequence.toString();
        if (textCapMode.getCapAll()) {
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String upperCase = obj.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } else if (textCapMode.getCapWords()) {
            return ExtKt.capWords(obj);
        } else {
            if (!textCapMode.getCapNone()) {
                return obj;
            }
            Locale locale2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale2, "Locale.ENGLISH");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = obj.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
    }

    public final int alignmentToGravity(TextAlignment textAlignment) {
        Intrinsics.checkNotNullParameter(textAlignment, "alignment");
        int i = WhenMappings.$EnumSwitchMapping$0[textAlignment.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (textAlignment.getCenterVertically()) {
                    return 8388629;
                } else {
                    return GravityCompat.END;
                }
            } else if (textAlignment.getCenterVertically()) {
                return 17;
            } else {
                return 1;
            }
        } else if (textAlignment.getCenterVertically()) {
            return 8388627;
        } else {
            return GravityCompat.START;
        }
    }

    public final TextAlignment gravityToAlignment(int i) {
        switch (i) {
            case 17:
                return TextAlignment.CENTER;
            case GravityCompat.START:
                return TextAlignment.LEFT;
            case GravityCompat.END:
                return TextAlignment.RIGHT;
            case 8388627:
                return TextAlignment.LEFT;
            case 8388629:
                return TextAlignment.RIGHT;
            default:
                return TextAlignment.LEFT;
        }
    }
}
