package editor.optionsui.media.mediaadjust;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import editor.optionsui.media.tabs.MediaOptionViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/media/tabs/MediaOptionViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaAdjustFragment.kt */
final class MediaAdjustFragment$viewModel$2 extends Lambda implements Function0<MediaOptionViewModel> {
    final /* synthetic */ MediaAdjustFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaAdjustFragment$viewModel$2(MediaAdjustFragment mediaAdjustFragment) {
        super(0);
        this.this$0 = mediaAdjustFragment;
    }

    public final MediaOptionViewModel invoke() {
        ViewModel viewModel;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Function0 function0 = C48701.INSTANCE;
        if (function0 == null) {
            viewModel = ViewModelProviders.m17of(requireActivity).get(MediaOptionViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(this).get(T::class.java)");
        } else {
            viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(MediaOptionViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        }
        return (MediaOptionViewModel) viewModel;
    }
}
