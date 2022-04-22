package editor.tools.filters.deepfryfilters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.core.NicoViewModel;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.gpu.conflation.GlConflatedFilter;
import editor.optionsui.OnEditorPlanRequestedListener;
import editor.tools.filters.conflation.FilterType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersViewModel;", "Leditor/core/NicoViewModel;", "()V", "_filterPreviewSelected", "Landroidx/lifecycle/MutableLiveData;", "", "_filterSelected", "Leditor/gpu/conflation/GlConflatedFilter;", "_filters", "", "Leditor/tools/filters/deepfryfilters/DeepFryFilter;", "editorPlan", "Leditor/editor/plan/EditorPlan;", "editorPlanRequestedListener", "Leditor/optionsui/OnEditorPlanRequestedListener;", "fetchFilters", "", "filterType", "Leditor/tools/filters/conflation/FilterType;", "filters", "Landroidx/lifecycle/LiveData;", "onFilterPreviewSelected", "onFilterSelected", "selectFilter", "filter", "setContentType", "contentType", "", "setEditorPlan", "newPlan", "satisfiedRequirement", "Leditor/editor/plan/EditorPlanRequirement;", "setOnEditorPlanRequestedListener", "listener", "setSelectedFilterName", "name", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeepFryFiltersViewModel.kt */
public final class DeepFryFiltersViewModel extends NicoViewModel {
    private final MutableLiveData<String> _filterPreviewSelected = new MutableLiveData<>();
    private final MutableLiveData<GlConflatedFilter> _filterSelected = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<DeepFryFilter>> _filters = new MutableLiveData<>();
    private final EditorPlan editorPlan = EditorPlan.Companion.rookie();
    private OnEditorPlanRequestedListener editorPlanRequestedListener;

    public final LiveData<List<DeepFryFilter>> filters() {
        return this._filters;
    }

    public final LiveData<String> onFilterPreviewSelected() {
        return this._filterPreviewSelected;
    }

    public final LiveData<GlConflatedFilter> onFilterSelected() {
        return this._filterSelected;
    }

    public final void setOnEditorPlanRequestedListener(OnEditorPlanRequestedListener onEditorPlanRequestedListener) {
        Intrinsics.checkNotNullParameter(onEditorPlanRequestedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.editorPlanRequestedListener = onEditorPlanRequestedListener;
    }

    public final void setEditorPlan(EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan2, "newPlan");
        this.editorPlan.updateBy(editorPlan2);
        if ((editorPlanRequirement instanceof EditorPlanRequirement.OfGlFilter) && editorPlanRequirement.isNotExpired() && this.editorPlan.ofType(editorPlanRequirement.getRequiredPlanType())) {
            editorPlanRequirement.expire();
        }
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
        fetchFilters(filterType);
    }

    private final void fetchFilters(FilterType filterType) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeepFryFiltersViewModel$fetchFilters$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void selectFilter(GlConflatedFilter glConflatedFilter) {
        Intrinsics.checkNotNullParameter(glConflatedFilter, "filter");
        if (this.editorPlan.isPremium() || !glConflatedFilter.isPremium()) {
            this._filterSelected.setValue(glConflatedFilter);
            return;
        }
        EditorPlanRequirement.OfGlFilter ofGlFilter = new EditorPlanRequirement.OfGlFilter();
        OnEditorPlanRequestedListener onEditorPlanRequestedListener = this.editorPlanRequestedListener;
        if (onEditorPlanRequestedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editorPlanRequestedListener");
        }
        onEditorPlanRequestedListener.onEditorPlanRequested(ofGlFilter);
    }

    public final void setSelectedFilterName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this._filterPreviewSelected.setValue(str);
    }
}
