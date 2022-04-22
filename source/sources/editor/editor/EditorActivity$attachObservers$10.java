package editor.editor;

import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import editor.optionsui.watermark.Watermark;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "watermark", "Leditor/optionsui/watermark/Watermark;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$10 extends Lambda implements Function1<Watermark, Unit> {
    final /* synthetic */ EditorActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorActivity$attachObservers$10(EditorActivity editorActivity) {
        super(1);
        this.this$0 = editorActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Watermark) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Watermark watermark) {
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        if (watermark instanceof TextWatermark) {
            this.this$0.getFrame().apply((TextWatermark) watermark);
        } else if (watermark instanceof PhotoWatermark) {
            this.this$0.getFrame().apply((PhotoWatermark) watermark);
        } else {
            throw new RuntimeException("Unknown Watermark: " + watermark);
        }
    }
}
