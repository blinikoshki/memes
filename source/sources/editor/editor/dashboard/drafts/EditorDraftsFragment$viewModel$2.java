package editor.editor.dashboard.drafts;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.memes.commons.output.OutputTargetGenerator;
import editor.core.BaseViewModelFactory;
import editor.database.EditorDatabaseManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsFragment.kt */
final class EditorDraftsFragment$viewModel$2 extends Lambda implements Function0<EditorDraftsViewModel> {
    final /* synthetic */ EditorDraftsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsFragment$viewModel$2(EditorDraftsFragment editorDraftsFragment) {
        super(0);
        this.this$0 = editorDraftsFragment;
    }

    public final EditorDraftsViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m16of((Fragment) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<EditorDraftsViewModel>(this) {
            final /* synthetic */ EditorDraftsFragment$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final EditorDraftsViewModel invoke() {
                EditorDatabaseManager editorDatabaseManager = EditorDatabaseManager.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new EditorDraftsViewModel(editorDatabaseManager.mo63492db(requireContext).getEditorDraftsDao(), OutputTargetGenerator.Companion.fromExternalCacheDirectory$default(OutputTargetGenerator.Companion, (String) null, 1, (Object) null));
            }
        })).get(EditorDraftsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (EditorDraftsViewModel) viewModel;
    }
}
