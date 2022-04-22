package editor.tools.filters.basicfilters;

import androidx.lifecycle.Observer;
import editor.tools.filters.conflation.FilterType;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "filterType", "Leditor/tools/filters/conflation/FilterType;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BasicFiltersFragment.kt */
final class BasicFiltersFragment$onViewCreated$3<T> implements Observer<FilterType> {
    final /* synthetic */ BasicFiltersFragment this$0;

    BasicFiltersFragment$onViewCreated$3(BasicFiltersFragment basicFiltersFragment) {
        this.this$0 = basicFiltersFragment;
    }

    public final void onChanged(FilterType filterType) {
        BasicFiltersAdapter access$getFiltersAdapter$p = this.this$0.getFiltersAdapter();
        if (filterType == null) {
            filterType = FilterType.IMAGE;
        }
        access$getFiltersAdapter$p.setFilterType(filterType);
    }
}
