package editor.optionsui.media.mediaedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.memes.editor.databinding.NMediaEditFragmentBinding;
import editor.optionsui.media.tabs.MediaOptionViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/media/mediaedit/MediaEditFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaEditFragmentBinding;", "viewModel", "Leditor/optionsui/media/tabs/MediaOptionViewModel;", "getViewModel", "()Leditor/optionsui/media/tabs/MediaOptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaEditFragment.kt */
public final class MediaEditFragment extends Fragment {
    private NMediaEditFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MediaEditFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final MediaOptionViewModel getViewModel() {
        return (MediaOptionViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NMediaEditFragmentBinding inflate = NMediaEditFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaEditFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.showFullSizeOptionView.setOnOptionButtonClickListener(new MediaEditFragment$onCreateView$1(this));
        NMediaEditFragmentBinding nMediaEditFragmentBinding = this.binding;
        if (nMediaEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEditFragmentBinding.duplicateOptionView.setOnOptionButtonClickListener(new MediaEditFragment$onCreateView$2(this));
        NMediaEditFragmentBinding nMediaEditFragmentBinding2 = this.binding;
        if (nMediaEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEditFragmentBinding2.replaceOptionView.setOnOptionButtonClickListener(new MediaEditFragment$onCreateView$3(this));
        NMediaEditFragmentBinding nMediaEditFragmentBinding3 = this.binding;
        if (nMediaEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaEditFragmentBinding3.deleteOptionView.setOnOptionButtonClickListener(new MediaEditFragment$onCreateView$4(this));
        NMediaEditFragmentBinding nMediaEditFragmentBinding4 = this.binding;
        if (nMediaEditFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaEditFragmentBinding4.getRoot();
    }
}
