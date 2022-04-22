package editor.tools.filters.basicfilters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import editor.core.NicoViewModel;
import editor.gpu.conflation.GlConflatedFilter;
import editor.tools.filters.conflation.FilterType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersViewModel;", "Leditor/core/NicoViewModel;", "()V", "_filterPreviewSelected", "Landroidx/lifecycle/MutableLiveData;", "", "_filterSelected", "Leditor/gpu/conflation/GlConflatedFilter;", "_filterTypeChanged", "Leditor/tools/filters/conflation/FilterType;", "_filters", "", "Leditor/tools/filters/basicfilters/BasicFilter;", "fetchFilters", "", "filterType", "filters", "Landroidx/lifecycle/LiveData;", "onFilterPreviewSelected", "onFilterSelected", "onFilterTypeChanged", "selectFilter", "filter", "setContentType", "contentType", "", "setSelectedFilterName", "name", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BasicFiltersViewModel.kt */
public final class BasicFiltersViewModel extends NicoViewModel {
    private final MutableLiveData<String> _filterPreviewSelected = new MutableLiveData<>();
    private final MutableLiveData<GlConflatedFilter> _filterSelected = new MutableLiveData<>();
    private final MutableLiveData<FilterType> _filterTypeChanged = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<BasicFilter>> _filters = new MutableLiveData<>();

    public final LiveData<List<BasicFilter>> filters() {
        return this._filters;
    }

    public final LiveData<String> onFilterPreviewSelected() {
        return this._filterPreviewSelected;
    }

    public final LiveData<GlConflatedFilter> onFilterSelected() {
        return this._filterSelected;
    }

    public final LiveData<FilterType> onFilterTypeChanged() {
        return this._filterTypeChanged;
    }

    public final void setContentType(int i) {
        FilterType filterType;
        if (i == 1231) {
            filterType = FilterType.IMAGE;
        } else if (i == 1232 || i == 1237) {
            filterType = FilterType.VIDEO;
        } else {
            throw new RuntimeException("Unknown content-type: " + i);
        }
        this._filterTypeChanged.setValue(filterType);
        fetchFilters(filterType);
    }

    private final void fetchFilters(FilterType filterType) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BasicFiltersViewModel$fetchFilters$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void selectFilter(GlConflatedFilter glConflatedFilter) {
        Intrinsics.checkNotNullParameter(glConflatedFilter, "filter");
        this._filterSelected.setValue(glConflatedFilter);
    }

    public final void setSelectedFilterName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this._filterPreviewSelected.setValue(str);
    }
}
