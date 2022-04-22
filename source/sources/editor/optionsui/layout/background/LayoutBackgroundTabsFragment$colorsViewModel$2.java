package editor.optionsui.layout.background;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import editor.optionsui.layerpaint.color.ColorsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/layerpaint/color/ColorsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundTabsFragment.kt */
final class LayoutBackgroundTabsFragment$colorsViewModel$2 extends Lambda implements Function0<ColorsViewModel> {
    final /* synthetic */ LayoutBackgroundTabsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutBackgroundTabsFragment$colorsViewModel$2(LayoutBackgroundTabsFragment layoutBackgroundTabsFragment) {
        super(0);
        this.this$0 = layoutBackgroundTabsFragment;
    }

    public final ColorsViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ColorsViewModel>(this) {
            final /* synthetic */ LayoutBackgroundTabsFragment$colorsViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ColorsViewModel invoke() {
                return new ColorsViewModel(this.this$0.this$0.getAssetsProvider());
            }
        })).get(ColorsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (ColorsViewModel) viewModel;
    }
}
