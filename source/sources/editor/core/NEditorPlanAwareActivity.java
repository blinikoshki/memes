package editor.core;

import android.os.Bundle;
import editor.editor.EditorPlanViewModel;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.editor.plan.EditorPlanType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0004J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u001c\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo26107d2 = {"Leditor/core/NEditorPlanAwareActivity;", "Leditor/core/NicoActivity;", "()V", "editorPlan", "Leditor/editor/plan/EditorPlan;", "editorPlanViewModel", "Leditor/editor/EditorPlanViewModel;", "getEditorPlanViewModel", "()Leditor/editor/EditorPlanViewModel;", "editorPlanViewModel$delegate", "Lkotlin/Lazy;", "hasPremiumEditorPlan", "", "hasRequiredPlan", "planType", "Leditor/editor/plan/EditorPlanType;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateEditorPlan", "plan", "requirement", "Leditor/editor/plan/EditorPlanRequirement;", "upgradeEditorPlan", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NEditorPlanAwareActivity.kt */
public abstract class NEditorPlanAwareActivity extends NicoActivity {
    private final EditorPlan editorPlan = EditorPlan.Companion.rookie();
    private final Lazy editorPlanViewModel$delegate = LazyKt.lazy(new NEditorPlanAwareActivity$editorPlanViewModel$2(this));

    private final EditorPlanViewModel getEditorPlanViewModel() {
        return (EditorPlanViewModel) this.editorPlanViewModel$delegate.getValue();
    }

    public abstract void upgradeEditorPlan(EditorPlanRequirement editorPlanRequirement);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getEditorPlanViewModel().onEditorPlanRequested().observe(this, new NEditorPlanAwareActivity$onCreate$1(this));
    }

    /* access modifiers changed from: protected */
    public final boolean hasPremiumEditorPlan() {
        return this.editorPlan.isPremium();
    }

    /* access modifiers changed from: protected */
    public final boolean hasRequiredPlan(EditorPlanType editorPlanType) {
        Intrinsics.checkNotNullParameter(editorPlanType, "planType");
        return this.editorPlan.ofType(editorPlanType);
    }

    public static /* synthetic */ void updateEditorPlan$default(NEditorPlanAwareActivity nEditorPlanAwareActivity, EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                editorPlanRequirement = null;
            }
            nEditorPlanAwareActivity.updateEditorPlan(editorPlan2, editorPlanRequirement);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateEditorPlan");
    }

    public void updateEditorPlan(EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan2, "plan");
        this.editorPlan.updateBy(editorPlan2);
        getEditorPlanViewModel().setEditorPlan(editorPlan2, editorPlanRequirement);
    }
}
