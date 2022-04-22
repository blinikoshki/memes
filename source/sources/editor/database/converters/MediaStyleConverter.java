package editor.database.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import editor.editor.equipment.media.MediaStyle;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\f"}, mo26107d2 = {"Leditor/database/converters/MediaStyleConverter;", "", "()V", "toJson", "", "style", "Leditor/editor/equipment/media/MediaStyle;", "styles", "", "toStyle", "value", "toStyles", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaStyleConverter.kt */
public final class MediaStyleConverter {
    public final String toJson(MediaStyle mediaStyle) {
        if (mediaStyle == null) {
            return null;
        }
        return new Gson().toJson((Object) mediaStyle);
    }

    public final String toJson(List<MediaStyle> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return new Gson().toJson((Object) list);
    }

    public final MediaStyle toStyle(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return (MediaStyle) new Gson().fromJson(str, MediaStyle.class);
    }

    public final List<MediaStyle> toStyles(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, MediaStyle.class);
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…, MediaStyle::class.java)");
        return (List) new Gson().fromJson(str, parameterized.getType());
    }
}
