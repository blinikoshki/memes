package editor.optionsui.text.textfont;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import editor.database.EditorDatabaseManager;
import editor.database.dao.RecentFontsDao;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/text/textfont/TextFontsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
final class TextFontsFragment$textFontsViewModel$2 extends Lambda implements Function0<TextFontsViewModel> {
    final /* synthetic */ TextFontsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFontsFragment$textFontsViewModel$2(TextFontsFragment textFontsFragment) {
        super(0);
        this.this$0 = textFontsFragment;
    }

    public final TextFontsViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<TextFontsViewModel>(this) {
            final /* synthetic */ TextFontsFragment$textFontsViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final TextFontsViewModel invoke() {
                EditorDatabaseManager editorDatabaseManager = EditorDatabaseManager.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                RecentFontsDao recentFontsDao = editorDatabaseManager.mo63492db(requireContext).getRecentFontsDao();
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                AssetManager assets = requireActivity.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "requireActivity().assets");
                return new TextFontsViewModel(recentFontsDao, new TextFontsProvider(assets));
            }
        })).get(TextFontsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (TextFontsViewModel) viewModel;
    }
}
