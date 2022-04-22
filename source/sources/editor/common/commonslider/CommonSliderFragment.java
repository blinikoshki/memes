package editor.common.commonslider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NCommonSliderFragmentBinding;
import editor.core.NicoFragment;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo26107d2 = {"Leditor/common/commonslider/CommonSliderFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NCommonSliderFragmentBinding;", "viewModel", "Leditor/common/commonslider/CommonSliderViewModel;", "getViewModel", "()Leditor/common/commonslider/CommonSliderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initFooter", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommonSliderFragment.kt */
public final class CommonSliderFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NCommonSliderFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new CommonSliderFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final CommonSliderViewModel getViewModel() {
        return (CommonSliderViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NCommonSliderFragmentBinding access$getBinding$p(CommonSliderFragment commonSliderFragment) {
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding = commonSliderFragment.binding;
        if (nCommonSliderFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nCommonSliderFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NCommonSliderFragmentBinding inflate = NCommonSliderFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NCommonSliderFragmentBin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding = this.binding;
        if (nCommonSliderFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCommonSliderFragmentBinding.header.setTitle("");
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding2 = this.binding;
        if (nCommonSliderFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCommonSliderFragmentBinding2.header.setOnResetButtonClickListener(new CommonSliderFragment$onCreateView$1(this));
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding3 = this.binding;
        if (nCommonSliderFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCommonSliderFragmentBinding3.slider.setOnChangeListener(new CommonSliderFragment$onCreateView$2(this));
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding4 = this.binding;
        if (nCommonSliderFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nCommonSliderFragmentBinding4.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        initFooter();
        getViewModel().onHeaderTitleAvailable().observe(getViewLifecycleOwner(), new CommonSliderFragment$onViewCreated$1(this));
        getViewModel().onSliderRangeAvailable().observe(getViewLifecycleOwner(), new CommonSliderFragment$onViewCreated$2(this));
        getViewModel().onSliderValueAvailable().observe(getViewLifecycleOwner(), new CommonSliderFragment$onViewCreated$3(this));
    }

    private final void initFooter() {
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding = this.binding;
        if (nCommonSliderFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCommonSliderFragmentBinding.footer.setOnDoneButtonClickListener(new CommonSliderFragment$initFooter$1(this));
        NCommonSliderFragmentBinding nCommonSliderFragmentBinding2 = this.binding;
        if (nCommonSliderFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nCommonSliderFragmentBinding2.footer.setOnCancelButtonClickListener(new CommonSliderFragment$initFooter$2(this));
    }
}
