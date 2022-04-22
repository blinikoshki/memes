package editor.tools.filters.mediaenhance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NMediaEnhanceFragmentBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Leditor/tools/filters/mediaenhance/MediaEnhanceFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaEnhanceFragmentBinding;", "viewModel", "Leditor/tools/filters/mediaenhance/MediaEnhanceViewModel;", "getViewModel", "()Leditor/tools/filters/mediaenhance/MediaEnhanceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaEnhanceFragment.kt */
public final class MediaEnhanceFragment extends Fragment {
    /* access modifiers changed from: private */
    public NMediaEnhanceFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MediaEnhanceFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final MediaEnhanceViewModel getViewModel() {
        return (MediaEnhanceViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NMediaEnhanceFragmentBinding access$getBinding$p(MediaEnhanceFragment mediaEnhanceFragment) {
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding = mediaEnhanceFragment.binding;
        if (nMediaEnhanceFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaEnhanceFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NMediaEnhanceFragmentBinding inflate = NMediaEnhanceFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaEnhanceFragmentBin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.contrastOptionView.setOnClickListener(new MediaEnhanceFragment$onCreateView$1(this));
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding = this.binding;
        if (nMediaEnhanceFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEnhanceFragmentBinding.brightnessOptionView.setOnClickListener(new MediaEnhanceFragment$onCreateView$2(this));
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding2 = this.binding;
        if (nMediaEnhanceFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEnhanceFragmentBinding2.saturationOptionView.setOnClickListener(new MediaEnhanceFragment$onCreateView$3(this));
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding3 = this.binding;
        if (nMediaEnhanceFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEnhanceFragmentBinding3.pixelationOptionView.setOnClickListener(new MediaEnhanceFragment$onCreateView$4(this));
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding4 = this.binding;
        if (nMediaEnhanceFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEnhanceFragmentBinding4.sharpnessOptionView.setOnClickListener(new MediaEnhanceFragment$onCreateView$5(this));
        NMediaEnhanceFragmentBinding nMediaEnhanceFragmentBinding5 = this.binding;
        if (nMediaEnhanceFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaEnhanceFragmentBinding5.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getViewModel().onContrastFilterAppliedChanged().observe(getViewLifecycleOwner(), new MediaEnhanceFragment$onViewCreated$1(this));
        getViewModel().onBrightnessFilterAppliedChanged().observe(getViewLifecycleOwner(), new MediaEnhanceFragment$onViewCreated$2(this));
        getViewModel().onSaturationFilterAppliedChanged().observe(getViewLifecycleOwner(), new MediaEnhanceFragment$onViewCreated$3(this));
        getViewModel().onPixelationFilterAppliedChanged().observe(getViewLifecycleOwner(), new MediaEnhanceFragment$onViewCreated$4(this));
        getViewModel().onSharpnessFilterAppliedChanged().observe(getViewLifecycleOwner(), new MediaEnhanceFragment$onViewCreated$5(this));
    }
}
