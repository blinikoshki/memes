package editor.mediaselection;

import editor.mediaselection.items.MediaSelectionItemsViewModel;
import editor.mediaselection.paints.ColorsHorizontalSelectionAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/paints/ColorsHorizontalSelectionAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$colorsAdapter$2 extends Lambda implements Function0<ColorsHorizontalSelectionAdapter> {
    final /* synthetic */ MediaSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionActivity$colorsAdapter$2(MediaSelectionActivity mediaSelectionActivity) {
        super(0);
        this.this$0 = mediaSelectionActivity;
    }

    public final ColorsHorizontalSelectionAdapter invoke() {
        MediaSelectionActivity mediaSelectionActivity = this.this$0;
        return new ColorsHorizontalSelectionAdapter(mediaSelectionActivity, new Function2<LayerPaint.Color, Boolean, Boolean>(mediaSelectionActivity.getViewModel()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((LayerPaint.Color) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(LayerPaint.Color color, boolean z) {
                Intrinsics.checkNotNullParameter(color, "p1");
                return ((MediaSelectionItemsViewModel) this.receiver).setColorSelected(color, z);
            }
        });
    }
}
