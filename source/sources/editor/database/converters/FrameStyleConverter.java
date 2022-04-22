package editor.database.converters;

import com.google.gson.Gson;
import editor.editor.equipment.frame.FrameStyle;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Leditor/database/converters/FrameStyleConverter;", "", "()V", "toJson", "", "style", "Leditor/editor/equipment/frame/FrameStyle;", "toStyle", "value", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameStyleConverter.kt */
public final class FrameStyleConverter {
    public final FrameStyle toStyle(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return (FrameStyle) new Gson().fromJson(str, FrameStyle.class);
    }

    public final String toJson(FrameStyle frameStyle) {
        if (frameStyle == null) {
            return null;
        }
        return new Gson().toJson((Object) frameStyle);
    }
}
