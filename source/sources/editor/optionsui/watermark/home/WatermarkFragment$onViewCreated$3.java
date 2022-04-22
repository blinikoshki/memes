package editor.optionsui.watermark.home;

import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "p1", "Leditor/editor/plan/EditorPlan;", "p2", "Leditor/editor/plan/EditorPlanRequirement;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkFragment.kt */
final /* synthetic */ class WatermarkFragment$onViewCreated$3 extends FunctionReferenceImpl implements Function2<EditorPlan, EditorPlanRequirement, Unit> {
    WatermarkFragment$onViewCreated$3(WatermarkViewModel watermarkViewModel) {
        super(2, watermarkViewModel, WatermarkViewModel.class, "setEditorPlan", "setEditorPlan(Leditor/editor/plan/EditorPlan;Leditor/editor/plan/EditorPlanRequirement;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((EditorPlan) obj, (EditorPlanRequirement) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(EditorPlan editorPlan, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan, "p1");
        ((WatermarkViewModel) this.receiver).setEditorPlan(editorPlan, editorPlanRequirement);
    }
}
