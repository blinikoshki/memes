package editor.optionsui.watermark;

import com.appsflyer.ServerParameters;
import editor.editor.equipment.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo26107d2 = {"Leditor/optionsui/watermark/TextWatermark;", "Leditor/optionsui/watermark/Watermark;", "uid", "", "thumbnailPath", "timestamp", "", "style", "Leditor/editor/equipment/text/TextStyle;", "(Ljava/lang/String;Ljava/lang/String;JLeditor/editor/equipment/text/TextStyle;)V", "getStyle", "()Leditor/editor/equipment/text/TextStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextWatermark.kt */
public final class TextWatermark extends Watermark {
    private final TextStyle style;

    public final TextStyle getStyle() {
        return this.style;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextWatermark(String str, String str2, long j, TextStyle textStyle) {
        super(str, str2, j);
        Intrinsics.checkNotNullParameter(str, ServerParameters.AF_USER_ID);
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.style = textStyle;
    }
}
