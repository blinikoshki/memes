package editor.optionsui.addcontent.contentpicker;

import editor.common.mediapicker.MimeMediaPicker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/common/mediapicker/MimeMediaPicker;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
final class ContentPickerActivity$mimeMediaImporter$2 extends Lambda implements Function0<MimeMediaPicker> {
    final /* synthetic */ ContentPickerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentPickerActivity$mimeMediaImporter$2(ContentPickerActivity contentPickerActivity) {
        super(0);
        this.this$0 = contentPickerActivity;
    }

    public final MimeMediaPicker invoke() {
        ContentPickerActivity contentPickerActivity = this.this$0;
        return new MimeMediaPicker(contentPickerActivity, contentPickerActivity.getOutputTargetGenerator());
    }
}
