package editor.optionsui.text.textadjust;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NTextAdjustFragmentBinding;
import editor.core.NicoFragment;
import editor.editor.equipment.core.CoreConfig;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, mo26107d2 = {"Leditor/optionsui/text/textadjust/TextAdjustFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NTextAdjustFragmentBinding;", "viewModel", "Leditor/optionsui/text/textadjust/TextAdjustViewModel;", "getViewModel", "()Leditor/optionsui/text/textadjust/TextAdjustViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initFooter", "", "initOpacitySlider", "initRotateSlider", "initScaleSlider", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "resetSliders", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextAdjustFragment.kt */
public final class TextAdjustFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NTextAdjustFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new TextAdjustFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final TextAdjustViewModel getViewModel() {
        return (TextAdjustViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NTextAdjustFragmentBinding access$getBinding$p(TextAdjustFragment textAdjustFragment) {
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = textAdjustFragment.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextAdjustFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextAdjustFragmentBinding inflate = NTextAdjustFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextAdjustFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.header.setTitle(C4175R.string.adjust);
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.header.setOnResetButtonClickListener(new TextAdjustFragment$onCreateView$1(this));
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding3 = this.binding;
        if (nTextAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextAdjustFragmentBinding3.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        initOpacitySlider();
        initScaleSlider();
        initRotateSlider();
        initFooter();
        getViewModel().onOpacitySet().observe(getViewLifecycleOwner(), new TextAdjustFragment$onViewCreated$1(this));
        getViewModel().onTextScaleSet().observe(getViewLifecycleOwner(), new TextAdjustFragment$onViewCreated$2(this));
        getViewModel().onTextRotationSet().observe(getViewLifecycleOwner(), new TextAdjustFragment$onViewCreated$3(this));
    }

    private final void initOpacitySlider() {
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.opacitySlider.setMinValue(CoreConfig.INSTANCE.getOpacityRange().getMinimum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.opacitySlider.setMaxValue(CoreConfig.INSTANCE.getOpacityRange().getMaximum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding3 = this.binding;
        if (nTextAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding3.opacitySlider.setValue(CoreConfig.INSTANCE.getOpacityRange().getDefault());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding4 = this.binding;
        if (nTextAdjustFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding4.opacitySlider.setOnChangeListener(new TextAdjustFragment$initOpacitySlider$1(this));
    }

    private final void initScaleSlider() {
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.scaleSlider.setMinValue(CoreConfig.INSTANCE.getScaleRange().getMinimum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.scaleSlider.setMaxValue(CoreConfig.INSTANCE.getScaleRange().getMaximum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding3 = this.binding;
        if (nTextAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding3.scaleSlider.setValue(CoreConfig.INSTANCE.getScaleRange().getDefault());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding4 = this.binding;
        if (nTextAdjustFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding4.scaleSlider.setOnChangeListener(new TextAdjustFragment$initScaleSlider$1(this));
    }

    private final void initRotateSlider() {
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.rotationSlider.setMinValue(CoreConfig.INSTANCE.getRotationRange().getMinimum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.rotationSlider.setMaxValue(CoreConfig.INSTANCE.getRotationRange().getMaximum());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding3 = this.binding;
        if (nTextAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding3.rotationSlider.setValue(CoreConfig.INSTANCE.getRotationRange().getDefault());
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding4 = this.binding;
        if (nTextAdjustFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding4.rotationSlider.setOnChangeListener(new TextAdjustFragment$initRotateSlider$1(this));
    }

    /* access modifiers changed from: private */
    public final void resetSliders() {
        float f = CoreConfig.INSTANCE.getOpacityRange().getDefault();
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.opacitySlider.setValue(f);
        getViewModel().changeOpacity(f);
        float f2 = CoreConfig.INSTANCE.getScaleRange().getDefault();
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.scaleSlider.setValue(f2);
        getViewModel().changeScale(f2);
        float f3 = CoreConfig.INSTANCE.getRotationRange().getDefault();
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding3 = this.binding;
        if (nTextAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding3.rotationSlider.setValue(f3);
        getViewModel().changeRotation(f3);
    }

    private final void initFooter() {
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding = this.binding;
        if (nTextAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding.footer.setOnDoneButtonClickListener(new TextAdjustFragment$initFooter$1(this));
        NTextAdjustFragmentBinding nTextAdjustFragmentBinding2 = this.binding;
        if (nTextAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextAdjustFragmentBinding2.footer.setOnCancelButtonClickListener(new TextAdjustFragment$initFooter$2(this));
    }
}
