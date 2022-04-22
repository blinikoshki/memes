package editor.optionsui.media.mediaadjust;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NMediaAdjustFragmentBinding;
import editor.common.corners.NicoCornerType;
import editor.optionsui.media.tabs.MediaOptionViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo26107d2 = {"Leditor/optionsui/media/mediaadjust/MediaAdjustFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaAdjustFragmentBinding;", "viewModel", "Leditor/optionsui/media/tabs/MediaOptionViewModel;", "getViewModel", "()Leditor/optionsui/media/tabs/MediaOptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showSelectedCornerType", "", "cornerType", "Leditor/common/corners/NicoCornerType;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaAdjustFragment.kt */
public final class MediaAdjustFragment extends Fragment {
    /* access modifiers changed from: private */
    public NMediaAdjustFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MediaAdjustFragment$viewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NicoCornerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NicoCornerType.ROUNDED.ordinal()] = 1;
            iArr[NicoCornerType.SQUARE.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final MediaOptionViewModel getViewModel() {
        return (MediaOptionViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NMediaAdjustFragmentBinding access$getBinding$p(MediaAdjustFragment mediaAdjustFragment) {
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding = mediaAdjustFragment.binding;
        if (nMediaAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaAdjustFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NMediaAdjustFragmentBinding inflate = NMediaAdjustFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaAdjustFragmentBind…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.nudgeOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$1(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding = this.binding;
        if (nMediaAdjustFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding.rotateOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$2(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding2 = this.binding;
        if (nMediaAdjustFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding2.scaleOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$3(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding3 = this.binding;
        if (nMediaAdjustFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding3.cropOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$4(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding4 = this.binding;
        if (nMediaAdjustFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding4.enhanceOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$5(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding5 = this.binding;
        if (nMediaAdjustFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding5.flipHorizontalOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$6(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding6 = this.binding;
        if (nMediaAdjustFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding6.flipVerticalOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$7(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding7 = this.binding;
        if (nMediaAdjustFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding7.opacityOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$8(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding8 = this.binding;
        if (nMediaAdjustFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaAdjustFragmentBinding8.cornerOptionView.setOnOptionButtonClickListener(new MediaAdjustFragment$onCreateView$9(this));
        getViewModel().onInitiallyFlippedHorizontally().observe(getViewLifecycleOwner(), new MediaAdjustFragment$onCreateView$10(this));
        getViewModel().onInitiallyFlippedVertically().observe(getViewLifecycleOwner(), new MediaAdjustFragment$onCreateView$11(this));
        getViewModel().onInitialCorner().observe(getViewLifecycleOwner(), new MediaAdjustFragment$onCreateView$12(this));
        NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding9 = this.binding;
        if (nMediaAdjustFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaAdjustFragmentBinding9.getRoot();
    }

    /* access modifiers changed from: private */
    public final void showSelectedCornerType(NicoCornerType nicoCornerType) {
        int i = WhenMappings.$EnumSwitchMapping$0[nicoCornerType.ordinal()];
        if (i == 1) {
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding = this.binding;
            if (nMediaAdjustFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding.cornerOptionView.setIcon(C4175R.C4178drawable.icon_corner_rounded);
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding2 = this.binding;
            if (nMediaAdjustFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding2.cornerOptionView.setTitle(C4175R.string.rounded);
        } else if (i != 2) {
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding3 = this.binding;
            if (nMediaAdjustFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding3.cornerOptionView.setIcon((Drawable) null);
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding4 = this.binding;
            if (nMediaAdjustFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding4.cornerOptionView.setTitle((String) null);
        } else {
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding5 = this.binding;
            if (nMediaAdjustFragmentBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding5.cornerOptionView.setIcon(C4175R.C4178drawable.icon_corner_square);
            NMediaAdjustFragmentBinding nMediaAdjustFragmentBinding6 = this.binding;
            if (nMediaAdjustFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nMediaAdjustFragmentBinding6.cornerOptionView.setTitle(C4175R.string.rounded);
        }
    }
}
