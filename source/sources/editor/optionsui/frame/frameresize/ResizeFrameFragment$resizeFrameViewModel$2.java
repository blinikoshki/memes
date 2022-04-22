package editor.optionsui.frame.frameresize;

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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/frame/frameresize/ResizeFrameViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameFragment.kt */
final class ResizeFrameFragment$resizeFrameViewModel$2 extends Lambda implements Function0<ResizeFrameViewModel> {
    final /* synthetic */ ResizeFrameFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResizeFrameFragment$resizeFrameViewModel$2(ResizeFrameFragment resizeFrameFragment) {
        super(0);
        this.this$0 = resizeFrameFragment;
    }

    public final ResizeFrameViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<ResizeFrameViewModel>(this) {
            final /* synthetic */ ResizeFrameFragment$resizeFrameViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ResizeFrameViewModel invoke() {
                AssetsProvider.Companion companion = AssetsProvider.Companion;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new ResizeFrameViewModel(companion.from(requireContext));
            }
        })).get(ResizeFrameViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (ResizeFrameViewModel) viewModel;
    }
}
