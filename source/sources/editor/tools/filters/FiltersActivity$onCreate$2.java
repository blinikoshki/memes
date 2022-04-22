package editor.tools.filters;

import android.content.Intent;
import androidx.lifecycle.Observer;
import editor.gpu.gpuimage.GPUImageView;
import editor.tools.filters.FiltersActivity;
import editor.tools.filters.tabs.MediaFilterTabAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "action", "Leditor/tools/filters/tabs/MediaFilterTabAction;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
final class FiltersActivity$onCreate$2<T> implements Observer<MediaFilterTabAction> {
    final /* synthetic */ FiltersActivity this$0;

    FiltersActivity$onCreate$2(FiltersActivity filtersActivity) {
        this.this$0 = filtersActivity;
    }

    public final void onChanged(MediaFilterTabAction mediaFilterTabAction) {
        if (mediaFilterTabAction != null) {
            int i = FiltersActivity.WhenMappings.$EnumSwitchMapping$0[mediaFilterTabAction.ordinal()];
            if (i == 1) {
                FiltersViewModel access$getFiltersViewModel$p = this.this$0.getFiltersViewModel();
                GPUImageView gPUImageView = this.this$0.getBinding().photoView;
                Intrinsics.checkNotNullExpressionValue(gPUImageView, "binding.photoView");
                access$getFiltersViewModel$p.applyFilters(gPUImageView, FiltersActivity.access$getReceivedFilterRequest$p(this.this$0));
            } else if (i == 2) {
                this.this$0.setResult(0, (Intent) null);
                this.this$0.finish();
            }
        }
    }
}
