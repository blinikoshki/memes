package editor.tools.filters.tabs;

import androidx.lifecycle.LiveData;
import com.memes.commons.util.SingleLiveEvent;
import editor.core.NicoViewModel;
import editor.tools.filters.conflation.FilterRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/tools/filters/tabs/MediaFilterTabsViewModel;", "Leditor/core/NicoViewModel;", "()V", "_tabActionSelected", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/tools/filters/tabs/MediaFilterTabAction;", "_tabSelected", "Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "applyChanges", "", "discardChanges", "onFilterTabActionSelected", "Landroidx/lifecycle/LiveData;", "onFilterTabSelected", "setSelectedFilterTab", "filterTab", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaFilterTabsViewModel.kt */
public final class MediaFilterTabsViewModel extends NicoViewModel {
    private final SingleLiveEvent<MediaFilterTabAction> _tabActionSelected = new SingleLiveEvent<>();
    private final SingleLiveEvent<FilterRequest.FilterTab> _tabSelected = new SingleLiveEvent<>();

    public final LiveData<MediaFilterTabAction> onFilterTabActionSelected() {
        return this._tabActionSelected;
    }

    public final LiveData<FilterRequest.FilterTab> onFilterTabSelected() {
        return this._tabSelected;
    }

    public final void setSelectedFilterTab(FilterRequest.FilterTab filterTab) {
        Intrinsics.checkNotNullParameter(filterTab, "filterTab");
        this._tabSelected.setValue(filterTab);
    }

    public final void applyChanges() {
        this._tabActionSelected.setValue(MediaFilterTabAction.DONE);
    }

    public final void discardChanges() {
        this._tabActionSelected.setValue(MediaFilterTabAction.CANCEL);
    }
}
