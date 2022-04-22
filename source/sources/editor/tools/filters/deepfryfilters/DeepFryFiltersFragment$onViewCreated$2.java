package editor.tools.filters.deepfryfilters;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "filterName", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: DeepFryFiltersFragment.kt */
final class DeepFryFiltersFragment$onViewCreated$2<T> implements Observer<String> {
    final /* synthetic */ DeepFryFiltersFragment this$0;

    DeepFryFiltersFragment$onViewCreated$2(DeepFryFiltersFragment deepFryFiltersFragment) {
        this.this$0 = deepFryFiltersFragment;
    }

    public final void onChanged(String str) {
        DeepFryFiltersAdapter access$getFiltersAdapter$p = this.this$0.getFiltersAdapter();
        Intrinsics.checkNotNullExpressionValue(str, "filterName");
        access$getFiltersAdapter$p.setSelectedFilterName(str);
    }
}
