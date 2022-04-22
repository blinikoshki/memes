package editor.editor.equipment.text;

import android.content.res.Resources;
import com.memes.editor.C4175R;
import editor.optionsui.text.textedit.TextAlignment;
import editor.optionsui.text.textedit.TextCapMode;
import editor.optionsui.text.textedit.TextFontStyle;
import editor.optionsui.text.textfont.TextFont;
import editor.util.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&¨\u0006."}, mo26107d2 = {"Leditor/editor/equipment/text/TextConfig;", "", "()V", "DEFAULT_ALIGNMENT", "Leditor/optionsui/text/textedit/TextAlignment;", "getDEFAULT_ALIGNMENT", "()Leditor/optionsui/text/textedit/TextAlignment;", "DEFAULT_BACKGROUND_COLOR", "", "DEFAULT_CAP_MODE", "Leditor/optionsui/text/textedit/TextCapMode;", "getDEFAULT_CAP_MODE", "()Leditor/optionsui/text/textedit/TextCapMode;", "DEFAULT_COLOR", "DEFAULT_FONT", "Leditor/optionsui/text/textfont/TextFont;", "getDEFAULT_FONT", "()Leditor/optionsui/text/textfont/TextFont;", "DEFAULT_FONT_STYLE", "Leditor/optionsui/text/textedit/TextFontStyle;", "getDEFAULT_FONT_STYLE", "()Leditor/optionsui/text/textedit/TextFontStyle;", "DEFAULT_TEXT", "MAX_MARGIN", "", "MAX_SIZE", "", "getMAX_SIZE", "()F", "setMAX_SIZE", "(F)V", "MIN_MARGIN", "MIN_SIZE", "getMIN_SIZE", "setMIN_SIZE", "letterSpacingRange", "Leditor/util/FloatRange;", "getLetterSpacingRange", "()Leditor/util/FloatRange;", "lineSpacingRange", "getLineSpacingRange", "initResources", "", "resources", "Landroid/content/res/Resources;", "textSizeRange", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextConfig.kt */
public final class TextConfig {
    private static final TextAlignment DEFAULT_ALIGNMENT = TextAlignment.CENTER;
    public static final String DEFAULT_BACKGROUND_COLOR = "#00000000";
    private static final TextCapMode DEFAULT_CAP_MODE = new TextCapMode(false, false, false, 7, (DefaultConstructorMarker) null);
    public static final String DEFAULT_COLOR = "#000000";
    private static final TextFont DEFAULT_FONT = TextFont.Companion.memesDefault();
    private static final TextFontStyle DEFAULT_FONT_STYLE = new TextFontStyle(false, false, false, 7, (DefaultConstructorMarker) null);
    public static final String DEFAULT_TEXT = "Type Text";
    public static final TextConfig INSTANCE = new TextConfig();
    public static final int MAX_MARGIN = 100;
    private static float MAX_SIZE = 80.0f;
    public static final int MIN_MARGIN = 0;
    private static float MIN_SIZE = 32.0f;
    private static final FloatRange letterSpacingRange = new FloatRange(0.0f, -0.1f, 0.7f);
    private static final FloatRange lineSpacingRange = new FloatRange(1.0f, 0.5f, 1.5f);

    private TextConfig() {
    }

    public final float getMIN_SIZE() {
        return MIN_SIZE;
    }

    public final void setMIN_SIZE(float f) {
        MIN_SIZE = f;
    }

    public final float getMAX_SIZE() {
        return MAX_SIZE;
    }

    public final void setMAX_SIZE(float f) {
        MAX_SIZE = f;
    }

    public final TextAlignment getDEFAULT_ALIGNMENT() {
        return DEFAULT_ALIGNMENT;
    }

    public final TextFontStyle getDEFAULT_FONT_STYLE() {
        return DEFAULT_FONT_STYLE;
    }

    public final TextCapMode getDEFAULT_CAP_MODE() {
        return DEFAULT_CAP_MODE;
    }

    public final TextFont getDEFAULT_FONT() {
        return DEFAULT_FONT;
    }

    public final void initResources(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        MIN_SIZE = resources.getDimension(C4175R.dimen._8ssp);
        MAX_SIZE = resources.getDimension(C4175R.dimen._28ssp);
        Timber.m300d("Initialized Text Sizes: (" + MIN_SIZE + ", " + MAX_SIZE + ')', new Object[0]);
    }

    public final FloatRange textSizeRange() {
        float f = MIN_SIZE;
        float f2 = MAX_SIZE;
        return new FloatRange((f + f2) / 2.0f, f, f2);
    }

    public final FloatRange getLetterSpacingRange() {
        return letterSpacingRange;
    }

    public final FloatRange getLineSpacingRange() {
        return lineSpacingRange;
    }
}
