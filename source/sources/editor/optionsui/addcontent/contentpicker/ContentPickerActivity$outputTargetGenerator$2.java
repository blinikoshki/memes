package editor.optionsui.addcontent.contentpicker;

import com.memes.commons.output.OutputTargetGenerator;
import editor.editor.EditorSession;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/output/OutputTargetGenerator;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
final class ContentPickerActivity$outputTargetGenerator$2 extends Lambda implements Function0<OutputTargetGenerator> {
    public static final ContentPickerActivity$outputTargetGenerator$2 INSTANCE = new ContentPickerActivity$outputTargetGenerator$2();

    ContentPickerActivity$outputTargetGenerator$2() {
        super(0);
    }

    public final OutputTargetGenerator invoke() {
        String str;
        if (EditorSession.INSTANCE.isInitialized()) {
            str = EditorSession.INSTANCE.getValue();
        } else {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "UUID.randomUUID().toString()");
        }
        return OutputTargetGenerator.Companion.fromExternalCacheDirectory(str);
    }
}
