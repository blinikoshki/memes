package editor.common.nudge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NNudgeFragmentBinding;
import editor.core.NicoFragment;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo26107d2 = {"Leditor/common/nudge/NudgeFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NNudgeFragmentBinding;", "viewModel", "Leditor/common/nudge/NudgeViewModel;", "getViewModel", "()Leditor/common/nudge/NudgeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setListeners", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NudgeFragment.kt */
public final class NudgeFragment extends NicoFragment {
    private NNudgeFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new NudgeFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final NudgeViewModel getViewModel() {
        return (NudgeViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NNudgeFragmentBinding inflate = NNudgeFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NNudgeFragmentBinding.in…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        setListeners();
        NNudgeFragmentBinding nNudgeFragmentBinding = this.binding;
        if (nNudgeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nNudgeFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NNudgeFragmentBinding nNudgeFragmentBinding = this.binding;
        if (nNudgeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding.footer.setOnDoneButtonClickListener(new NudgeFragment$onViewCreated$1(this));
        NNudgeFragmentBinding nNudgeFragmentBinding2 = this.binding;
        if (nNudgeFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding2.footer.setOnCancelButtonClickListener(new NudgeFragment$onViewCreated$2(this));
    }

    private final void setListeners() {
        NNudgeFragmentBinding nNudgeFragmentBinding = this.binding;
        if (nNudgeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding.upNudgeButton.setOnNudgeButtonClickListener(new NudgeFragment$setListeners$1(getViewModel()));
        NNudgeFragmentBinding nNudgeFragmentBinding2 = this.binding;
        if (nNudgeFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding2.downNudgeButton.setOnNudgeButtonClickListener(new NudgeFragment$setListeners$2(getViewModel()));
        NNudgeFragmentBinding nNudgeFragmentBinding3 = this.binding;
        if (nNudgeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding3.leftNudgeButton.setOnNudgeButtonClickListener(new NudgeFragment$setListeners$3(getViewModel()));
        NNudgeFragmentBinding nNudgeFragmentBinding4 = this.binding;
        if (nNudgeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nNudgeFragmentBinding4.rightNudgeButton.setOnNudgeButtonClickListener(new NudgeFragment$setListeners$4(getViewModel()));
    }
}
