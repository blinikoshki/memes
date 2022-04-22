package editor.optionsui.text.textsize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NTextSizeFragmentBinding;
import editor.core.NicoFragment;
import editor.editor.equipment.text.TextConfig;
import editor.optionsui.text.tabs.TextTabsViewModel;
import editor.util.ExtKt;
import editor.util.FloatRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, mo26107d2 = {"Leditor/optionsui/text/textsize/TextSizeFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NTextSizeFragmentBinding;", "textSizeRange", "Leditor/util/FloatRange;", "textSizeViewModel", "Leditor/optionsui/text/textsize/TextSizeViewModel;", "getTextSizeViewModel", "()Leditor/optionsui/text/textsize/TextSizeViewModel;", "textSizeViewModel$delegate", "Lkotlin/Lazy;", "textTabsViewModel", "Leditor/optionsui/text/tabs/TextTabsViewModel;", "getTextTabsViewModel", "()Leditor/optionsui/text/tabs/TextTabsViewModel;", "textTabsViewModel$delegate", "initAutoSizeSwitch", "", "initTextSizeSlider", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "resetTextSizeSlider", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextSizeFragment.kt */
public final class TextSizeFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NTextSizeFragmentBinding binding;
    private final FloatRange textSizeRange = TextConfig.INSTANCE.textSizeRange();
    private final Lazy textSizeViewModel$delegate = LazyKt.lazy(new TextSizeFragment$textSizeViewModel$2(this));
    private final Lazy textTabsViewModel$delegate = LazyKt.lazy(new TextSizeFragment$textTabsViewModel$2(this));

    /* access modifiers changed from: private */
    public final TextSizeViewModel getTextSizeViewModel() {
        return (TextSizeViewModel) this.textSizeViewModel$delegate.getValue();
    }

    private final TextTabsViewModel getTextTabsViewModel() {
        return (TextTabsViewModel) this.textTabsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ NTextSizeFragmentBinding access$getBinding$p(TextSizeFragment textSizeFragment) {
        NTextSizeFragmentBinding nTextSizeFragmentBinding = textSizeFragment.binding;
        if (nTextSizeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextSizeFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextSizeFragmentBinding inflate = NTextSizeFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextSizeFragmentBinding…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        initTextSizeSlider();
        initAutoSizeSwitch();
        NTextSizeFragmentBinding nTextSizeFragmentBinding = this.binding;
        if (nTextSizeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextSizeFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getTextSizeViewModel().setOnPropertyUpdatedListener(getTextTabsViewModel());
        getTextTabsViewModel().onTextStyleSet().observe(getViewLifecycleOwner(), new TextSizeFragment$onViewCreated$1(this));
    }

    private final void initTextSizeSlider() {
        NTextSizeFragmentBinding nTextSizeFragmentBinding = this.binding;
        if (nTextSizeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding.textSizeSlider.setMinValue(this.textSizeRange.getMinimum());
        NTextSizeFragmentBinding nTextSizeFragmentBinding2 = this.binding;
        if (nTextSizeFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding2.textSizeSlider.setMaxValue(this.textSizeRange.getMaximum());
        NTextSizeFragmentBinding nTextSizeFragmentBinding3 = this.binding;
        if (nTextSizeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding3.textSizeSlider.setValue(this.textSizeRange.getDefault());
        NTextSizeFragmentBinding nTextSizeFragmentBinding4 = this.binding;
        if (nTextSizeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding4.textSizeSlider.setOnChangeListener(new TextSizeFragment$initTextSizeSlider$1(this));
    }

    private final void initAutoSizeSwitch() {
        NTextSizeFragmentBinding nTextSizeFragmentBinding = this.binding;
        if (nTextSizeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding.autoTextSizeSwitch.setOnCheckedChangeListener(new TextSizeFragment$initAutoSizeSwitch$1(this));
    }

    /* access modifiers changed from: private */
    public final void resetTextSizeSlider() {
        float f = this.textSizeRange.getDefault();
        NTextSizeFragmentBinding nTextSizeFragmentBinding = this.binding;
        if (nTextSizeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextSizeFragmentBinding.textSizeSlider.setValue(f);
        getTextSizeViewModel().changeTextSize(f);
    }
}
