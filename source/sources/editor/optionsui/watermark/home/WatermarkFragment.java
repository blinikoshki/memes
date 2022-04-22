package editor.optionsui.watermark.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.PairObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NWatermarkFragmentBinding;
import editor.core.NicoFragment;
import editor.editor.EditorPlanViewModel;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, mo26107d2 = {"Leditor/optionsui/watermark/home/WatermarkFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NWatermarkFragmentBinding;", "editorPlanViewModel", "Leditor/editor/EditorPlanViewModel;", "getEditorPlanViewModel", "()Leditor/editor/EditorPlanViewModel;", "editorPlanViewModel$delegate", "Lkotlin/Lazy;", "watermarkViewModel", "Leditor/optionsui/watermark/home/WatermarkViewModel;", "getWatermarkViewModel", "()Leditor/optionsui/watermark/home/WatermarkViewModel;", "watermarkViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setListeners", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WatermarkFragment.kt */
public final class WatermarkFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NWatermarkFragmentBinding binding;
    private final Lazy editorPlanViewModel$delegate = LazyKt.lazy(new WatermarkFragment$editorPlanViewModel$2(this));
    private final Lazy watermarkViewModel$delegate = LazyKt.lazy(new WatermarkFragment$watermarkViewModel$2(this));

    private final EditorPlanViewModel getEditorPlanViewModel() {
        return (EditorPlanViewModel) this.editorPlanViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final WatermarkViewModel getWatermarkViewModel() {
        return (WatermarkViewModel) this.watermarkViewModel$delegate.getValue();
    }

    public static final /* synthetic */ NWatermarkFragmentBinding access$getBinding$p(WatermarkFragment watermarkFragment) {
        NWatermarkFragmentBinding nWatermarkFragmentBinding = watermarkFragment.binding;
        if (nWatermarkFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nWatermarkFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NWatermarkFragmentBinding inflate = NWatermarkFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NWatermarkFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        setListeners();
        NWatermarkFragmentBinding nWatermarkFragmentBinding = this.binding;
        if (nWatermarkFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nWatermarkFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getWatermarkViewModel().setOnEditorPlanRequestedListener(getEditorPlanViewModel());
        NWatermarkFragmentBinding nWatermarkFragmentBinding = this.binding;
        if (nWatermarkFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding.footer.setOnCloseButtonClickListener(new WatermarkFragment$onViewCreated$1(this));
        getWatermarkViewModel().onOfficialWatermarkVisibilityChanged().observe(getViewLifecycleOwner(), new WatermarkFragment$onViewCreated$2(this));
        getEditorPlanViewModel().onEditorPlanChanged().observe(getViewLifecycleOwner(), new PairObserver(new WatermarkFragment$onViewCreated$3(getWatermarkViewModel())));
    }

    private final void setListeners() {
        NWatermarkFragmentBinding nWatermarkFragmentBinding = this.binding;
        if (nWatermarkFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding.watermarkSwitch.setOnCheckedChangeListener(new WatermarkFragment$setListeners$1(this));
        NWatermarkFragmentBinding nWatermarkFragmentBinding2 = this.binding;
        if (nWatermarkFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding2.watermarkTextOptionView.setOnClickListener(new WatermarkFragment$setListeners$2(this));
        NWatermarkFragmentBinding nWatermarkFragmentBinding3 = this.binding;
        if (nWatermarkFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding3.watermarkSignatureOptionView.setOnClickListener(new WatermarkFragment$setListeners$3(this));
        NWatermarkFragmentBinding nWatermarkFragmentBinding4 = this.binding;
        if (nWatermarkFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding4.watermarkLogoOptionView.setOnClickListener(new WatermarkFragment$setListeners$4(this));
        NWatermarkFragmentBinding nWatermarkFragmentBinding5 = this.binding;
        if (nWatermarkFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nWatermarkFragmentBinding5.watermarkSavedOptionView.setOnClickListener(new WatermarkFragment$setListeners$5(this));
    }
}
