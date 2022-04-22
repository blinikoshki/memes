package editor.optionsui.text.textfont;

import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "newPlan", "Leditor/editor/plan/EditorPlan;", "satisfiedRequirement", "Leditor/editor/plan/EditorPlanRequirement;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$onViewCreated$12 extends Lambda implements Function2<EditorPlan, EditorPlanRequirement, Unit> {
    final /* synthetic */ TextFontsAdapter $adapter;
    final /* synthetic */ TextFontsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFontsFragment$onViewCreated$12(TextFontsFragment textFontsFragment, TextFontsAdapter textFontsAdapter) {
        super(2);
        this.this$0 = textFontsFragment;
        this.$adapter = textFontsAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((EditorPlan) obj, (EditorPlanRequirement) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(final EditorPlan editorPlan, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan, "newPlan");
        this.this$0.getTextFontsViewModel().setEditorPlan(editorPlan, editorPlanRequirement);
        TextFontsFragment.access$getBinding$p(this.this$0).fontsRecyclerView.post(new Runnable(this) {
            final /* synthetic */ TextFontsFragment$onViewCreated$12 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.$adapter.setHasPremiumPlan(editorPlan.isPremium());
            }
        });
    }
}
