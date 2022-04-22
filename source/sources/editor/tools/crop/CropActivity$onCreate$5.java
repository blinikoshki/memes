package editor.tools.crop;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "options", "", "Leditor/tools/crop/CropOption;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
final class CropActivity$onCreate$5<T> implements Observer<List<? extends CropOption>> {
    final /* synthetic */ CropActivity this$0;

    CropActivity$onCreate$5(CropActivity cropActivity) {
        this.this$0 = cropActivity;
    }

    public final void onChanged(List<? extends CropOption> list) {
        this.this$0.getCropOptionsAdapter().setItems(list);
        CropActivity cropActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(list, "options");
        cropActivity.onCropOptionSelected((CropOption) CollectionsKt.first(list));
    }
}
