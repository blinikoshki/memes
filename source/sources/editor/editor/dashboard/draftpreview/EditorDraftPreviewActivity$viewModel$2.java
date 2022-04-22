package editor.editor.dashboard.draftpreview;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.memes.commons.output.OutputTargetGenerator;
import editor.core.BaseViewModelFactory;
import editor.database.EditorDatabaseManager;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftPreviewActivity.kt */
final class EditorDraftPreviewActivity$viewModel$2 extends Lambda implements Function0<EditorDraftsViewModel> {
    final /* synthetic */ EditorDraftPreviewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftPreviewActivity$viewModel$2(EditorDraftPreviewActivity editorDraftPreviewActivity) {
        super(0);
        this.this$0 = editorDraftPreviewActivity;
    }

    public final EditorDraftsViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m18of((FragmentActivity) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<EditorDraftsViewModel>(this) {
            final /* synthetic */ EditorDraftPreviewActivity$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final EditorDraftsViewModel invoke() {
                return new EditorDraftsViewModel(EditorDatabaseManager.INSTANCE.mo63492db(this.this$0.this$0).getEditorDraftsDao(), OutputTargetGenerator.Companion.fromExternalCacheDirectory$default(OutputTargetGenerator.Companion, (String) null, 1, (Object) null));
            }
        })).get(EditorDraftsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (EditorDraftsViewModel) viewModel;
    }
}
