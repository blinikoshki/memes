package editor.optionsui.layerpaint.pattern;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/layerpaint/pattern/PatternsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: PatternsFragment.kt */
final class PatternsFragment$viewModel$2 extends Lambda implements Function0<PatternsViewModel> {
    final /* synthetic */ PatternsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PatternsFragment$viewModel$2(PatternsFragment patternsFragment) {
        super(0);
        this.this$0 = patternsFragment;
    }

    public final PatternsViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<PatternsViewModel>(this) {
            final /* synthetic */ PatternsFragment$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final PatternsViewModel invoke() {
                AssetsProvider.Companion companion = AssetsProvider.Companion;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new PatternsViewModel(companion.from(requireContext));
            }
        })).get(PatternsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (PatternsViewModel) viewModel;
    }
}
