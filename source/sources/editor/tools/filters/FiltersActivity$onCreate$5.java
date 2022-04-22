package editor.tools.filters;

import androidx.lifecycle.Observer;
import editor.gpu.conflation.GlConflatedFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "filter", "Leditor/gpu/conflation/GlConflatedFilter;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
final class FiltersActivity$onCreate$5<T> implements Observer<GlConflatedFilter> {
    final /* synthetic */ FiltersActivity this$0;

    FiltersActivity$onCreate$5(FiltersActivity filtersActivity) {
        this.this$0 = filtersActivity;
    }

    public final void onChanged(GlConflatedFilter glConflatedFilter) {
        FiltersActivity filtersActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(glConflatedFilter, "filter");
        filtersActivity.applyConflatedFilter(glConflatedFilter);
    }
}
