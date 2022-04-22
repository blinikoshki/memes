package editor.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import editor.core.NicoViewModel;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.optionsui.OnEditorPlanRequestedListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bR\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/editor/EditorPlanViewModel;", "Leditor/core/NicoViewModel;", "Leditor/optionsui/OnEditorPlanRequestedListener;", "()V", "_editorPlanChanged", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Leditor/editor/plan/EditorPlan;", "Leditor/editor/plan/EditorPlanRequirement;", "_editorPlanRequested", "editorPlan", "onEditorPlanChanged", "Landroidx/lifecycle/LiveData;", "onEditorPlanRequested", "", "requirement", "setEditorPlan", "plan", "satisfiedRequirement", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorPlanViewModel.kt */
public final class EditorPlanViewModel extends NicoViewModel implements OnEditorPlanRequestedListener {
    private final MutableLiveData<Pair<EditorPlan, EditorPlanRequirement>> _editorPlanChanged = new MutableLiveData<>();
    private final MutableLiveData<EditorPlanRequirement> _editorPlanRequested = new MutableLiveData<>();
    private final EditorPlan editorPlan = EditorPlan.Companion.rookie();

    public final LiveData<Pair<EditorPlan, EditorPlanRequirement>> onEditorPlanChanged() {
        return this._editorPlanChanged;
    }

    public final LiveData<EditorPlanRequirement> onEditorPlanRequested() {
        return this._editorPlanRequested;
    }

    public static /* synthetic */ void setEditorPlan$default(EditorPlanViewModel editorPlanViewModel, EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement, int i, Object obj) {
        if ((i & 2) != 0) {
            editorPlanRequirement = null;
        }
        editorPlanViewModel.setEditorPlan(editorPlan2, editorPlanRequirement);
    }

    public final void setEditorPlan(EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan2, "plan");
        this.editorPlan.updateBy(editorPlan2);
        this._editorPlanChanged.setValue(new Pair(this.editorPlan, editorPlanRequirement));
    }

    public void onEditorPlanRequested(EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlanRequirement, "requirement");
        this._editorPlanRequested.setValue(editorPlanRequirement);
    }
}
