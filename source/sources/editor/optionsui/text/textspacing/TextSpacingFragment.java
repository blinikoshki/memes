package editor.optionsui.text.textspacing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NTextSpacingFragmentBinding;
import editor.core.NicoFragment;
import editor.editor.equipment.text.TextConfig;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, mo26107d2 = {"Leditor/optionsui/text/textspacing/TextSpacingFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NTextSpacingFragmentBinding;", "viewModel", "Leditor/optionsui/text/textspacing/TextSpacingViewModel;", "getViewModel", "()Leditor/optionsui/text/textspacing/TextSpacingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initFooter", "", "initLetterSpacingSlider", "initLineSpacingSlider", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "resetSliders", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextSpacingFragment.kt */
public final class TextSpacingFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NTextSpacingFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new TextSpacingFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final TextSpacingViewModel getViewModel() {
        return (TextSpacingViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NTextSpacingFragmentBinding access$getBinding$p(TextSpacingFragment textSpacingFragment) {
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = textSpacingFragment.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextSpacingFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextSpacingFragmentBinding inflate = NTextSpacingFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextSpacingFragmentBind…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = this.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding.header.setTitle(C4175R.string.spacing);
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding2 = this.binding;
        if (nTextSpacingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding2.header.setOnResetButtonClickListener(new TextSpacingFragment$onCreateView$1(this));
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding3 = this.binding;
        if (nTextSpacingFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextSpacingFragmentBinding3.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        initLetterSpacingSlider();
        initLineSpacingSlider();
        initFooter();
        getViewModel().onLetterSpacingSet().observe(getViewLifecycleOwner(), new TextSpacingFragment$onViewCreated$1(this));
        getViewModel().onLineSpacingSet().observe(getViewLifecycleOwner(), new TextSpacingFragment$onViewCreated$2(this));
        getViewModel().onTextLineCountSet().observe(getViewLifecycleOwner(), new TextSpacingFragment$onViewCreated$3(this));
    }

    private final void initLetterSpacingSlider() {
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = this.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding.letterSpacingSlider.setMinValue(TextConfig.INSTANCE.getLetterSpacingRange().getMinimum());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding2 = this.binding;
        if (nTextSpacingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding2.letterSpacingSlider.setMaxValue(TextConfig.INSTANCE.getLetterSpacingRange().getMaximum());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding3 = this.binding;
        if (nTextSpacingFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding3.letterSpacingSlider.setValue(TextConfig.INSTANCE.getLetterSpacingRange().getDefault());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding4 = this.binding;
        if (nTextSpacingFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding4.letterSpacingSlider.setOnChangeListener(new TextSpacingFragment$initLetterSpacingSlider$1(this));
    }

    private final void initLineSpacingSlider() {
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = this.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding.lineSpacingSlider.setMinValue(TextConfig.INSTANCE.getLineSpacingRange().getMinimum());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding2 = this.binding;
        if (nTextSpacingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding2.lineSpacingSlider.setMaxValue(TextConfig.INSTANCE.getLineSpacingRange().getMaximum());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding3 = this.binding;
        if (nTextSpacingFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding3.lineSpacingSlider.setValue(TextConfig.INSTANCE.getLineSpacingRange().getDefault());
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding4 = this.binding;
        if (nTextSpacingFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding4.lineSpacingSlider.setOnChangeListener(new TextSpacingFragment$initLineSpacingSlider$1(this));
    }

    /* access modifiers changed from: private */
    public final void resetSliders() {
        float f = TextConfig.INSTANCE.getLetterSpacingRange().getDefault();
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = this.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding.letterSpacingSlider.setValue(f);
        getViewModel().changeLetterSpacing(f);
        float f2 = TextConfig.INSTANCE.getLineSpacingRange().getDefault();
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding2 = this.binding;
        if (nTextSpacingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding2.lineSpacingSlider.setValue(f2);
        getViewModel().changeLineSpacing(f2);
    }

    private final void initFooter() {
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding = this.binding;
        if (nTextSpacingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding.footer.setOnDoneButtonClickListener(new TextSpacingFragment$initFooter$1(this));
        NTextSpacingFragmentBinding nTextSpacingFragmentBinding2 = this.binding;
        if (nTextSpacingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSpacingFragmentBinding2.footer.setOnCancelButtonClickListener(new TextSpacingFragment$initFooter$2(this));
    }
}
