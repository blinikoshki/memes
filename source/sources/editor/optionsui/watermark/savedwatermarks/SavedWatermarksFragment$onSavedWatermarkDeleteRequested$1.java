package editor.optionsui.watermark.savedwatermarks;

import editor.optionsui.watermark.Watermark;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksFragment.kt */
final class SavedWatermarksFragment$onSavedWatermarkDeleteRequested$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Watermark $watermark;
    final /* synthetic */ SavedWatermarksFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedWatermarksFragment$onSavedWatermarkDeleteRequested$1(SavedWatermarksFragment savedWatermarksFragment, Watermark watermark) {
        super(0);
        this.this$0 = savedWatermarksFragment;
        this.$watermark = watermark;
    }

    public final void invoke() {
        this.this$0.getViewModel().deleteWatermark(this.$watermark);
    }
}
