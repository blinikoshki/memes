package editor.optionsui.watermark.savedwatermarks;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksFragment.kt */
final class SavedWatermarksFragment$viewModel$2 extends Lambda implements Function0<SavedWatermarksViewModel> {
    final /* synthetic */ SavedWatermarksFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedWatermarksFragment$viewModel$2(SavedWatermarksFragment savedWatermarksFragment) {
        super(0);
        this.this$0 = savedWatermarksFragment;
    }

    public final SavedWatermarksViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<SavedWatermarksViewModel>(this) {
            final /* synthetic */ SavedWatermarksFragment$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SavedWatermarksViewModel invoke() {
                EditorDatabaseManager editorDatabaseManager = EditorDatabaseManager.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new SavedWatermarksViewModel(editorDatabaseManager.mo63492db(requireContext).getSavedWatermarksDao(), OutputTargetGenerator.Companion.fromExternalCacheDirectory$default(OutputTargetGenerator.Companion, (String) null, 1, (Object) null));
            }
        })).get(SavedWatermarksViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (SavedWatermarksViewModel) viewModel;
    }
}
