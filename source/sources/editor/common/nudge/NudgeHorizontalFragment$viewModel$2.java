package editor.common.nudge;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/common/nudge/NudgeViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NudgeHorizontalFragment.kt */
final class NudgeHorizontalFragment$viewModel$2 extends Lambda implements Function0<NudgeViewModel> {
    final /* synthetic */ NudgeHorizontalFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NudgeHorizontalFragment$viewModel$2(NudgeHorizontalFragment nudgeHorizontalFragment) {
        super(0);
        this.this$0 = nudgeHorizontalFragment;
    }

    public final NudgeViewModel invoke() {
        ViewModel viewModel;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Function0 function0 = C46611.INSTANCE;
        if (function0 == null) {
            viewModel = ViewModelProviders.m17of(requireActivity).get(NudgeViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(this).get(T::class.java)");
        } else {
            viewModel = ViewModelProviders.m18of(requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(NudgeViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        }
        return (NudgeViewModel) viewModel;
    }
}
