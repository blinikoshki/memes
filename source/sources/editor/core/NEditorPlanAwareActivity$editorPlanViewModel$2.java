package editor.core;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.editor.EditorPlanViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/editor/EditorPlanViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NEditorPlanAwareActivity.kt */
final class NEditorPlanAwareActivity$editorPlanViewModel$2 extends Lambda implements Function0<EditorPlanViewModel> {
    final /* synthetic */ NEditorPlanAwareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NEditorPlanAwareActivity$editorPlanViewModel$2(NEditorPlanAwareActivity nEditorPlanAwareActivity) {
        super(0);
        this.this$0 = nEditorPlanAwareActivity;
    }

    public final EditorPlanViewModel invoke() {
        ViewModel viewModel;
        NEditorPlanAwareActivity nEditorPlanAwareActivity = this.this$0;
        Function0 function0 = C46621.INSTANCE;
        if (function0 == null) {
            viewModel = ViewModelProviders.m17of((FragmentActivity) nEditorPlanAwareActivity).get(EditorPlanViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(this).get(T::class.java)");
        } else {
            viewModel = ViewModelProviders.m18of((FragmentActivity) nEditorPlanAwareActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(EditorPlanViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        }
        return (EditorPlanViewModel) viewModel;
    }
}
