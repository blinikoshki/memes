package editor.core;

import androidx.lifecycle.Observer;
import editor.editor.plan.EditorPlanRequirement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "requirement", "Leditor/editor/plan/EditorPlanRequirement;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NEditorPlanAwareActivity.kt */
final class NEditorPlanAwareActivity$onCreate$1<T> implements Observer<EditorPlanRequirement> {
    final /* synthetic */ NEditorPlanAwareActivity this$0;

    NEditorPlanAwareActivity$onCreate$1(NEditorPlanAwareActivity nEditorPlanAwareActivity) {
        this.this$0 = nEditorPlanAwareActivity;
    }

    public final void onChanged(EditorPlanRequirement editorPlanRequirement) {
        NEditorPlanAwareActivity nEditorPlanAwareActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(editorPlanRequirement, "requirement");
        nEditorPlanAwareActivity.upgradeEditorPlan(editorPlanRequirement);
    }
}
