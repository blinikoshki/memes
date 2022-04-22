package editor.optionsui.frame.frameresize;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NResizeFrameFragmentBinding;
import editor.optionsui.frame.frameresize.customframesizeinput.CustomFrameSizeInputBottomSheet;
import editor.optionsui.frame.tabs.FrameTabsViewModel;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/ResizeFrameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NResizeFrameFragmentBinding;", "frameSizeInputSheet", "Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet;", "getFrameSizeInputSheet", "()Leditor/optionsui/frame/frameresize/customframesizeinput/CustomFrameSizeInputBottomSheet;", "frameSizeInputSheet$delegate", "Lkotlin/Lazy;", "frameTabsViewModel", "Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "getFrameTabsViewModel", "()Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "frameTabsViewModel$delegate", "resizeFrameViewModel", "Leditor/optionsui/frame/frameresize/ResizeFrameViewModel;", "getResizeFrameViewModel", "()Leditor/optionsui/frame/frameresize/ResizeFrameViewModel;", "resizeFrameViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showFrameSizeInputSheet", "targetFrameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ResizeFrameFragment.kt */
public final class ResizeFrameFragment extends Fragment {
    private NResizeFrameFragmentBinding binding;
    private final Lazy frameSizeInputSheet$delegate = LazyKt.lazy(ResizeFrameFragment$frameSizeInputSheet$2.INSTANCE);
    private final Lazy frameTabsViewModel$delegate = LazyKt.lazy(new ResizeFrameFragment$frameTabsViewModel$2(this));
    private final Lazy resizeFrameViewModel$delegate = LazyKt.lazy(new ResizeFrameFragment$resizeFrameViewModel$2(this));

    private final CustomFrameSizeInputBottomSheet getFrameSizeInputSheet() {
        return (CustomFrameSizeInputBottomSheet) this.frameSizeInputSheet$delegate.getValue();
    }

    private final FrameTabsViewModel getFrameTabsViewModel() {
        return (FrameTabsViewModel) this.frameTabsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ResizeFrameViewModel getResizeFrameViewModel() {
        return (ResizeFrameViewModel) this.resizeFrameViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NResizeFrameFragmentBinding inflate = NResizeFrameFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NResizeFrameFragmentBind…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NResizeFrameFragmentBinding nResizeFrameFragmentBinding = this.binding;
        if (nResizeFrameFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nResizeFrameFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getResizeFrameViewModel().setOnPropertyUpdatedListener(getFrameTabsViewModel());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NResizeFrameFragmentBinding nResizeFrameFragmentBinding = this.binding;
        if (nResizeFrameFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nResizeFrameFragmentBinding.frameSizesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.frameSizesRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FrameSizesAdapter frameSizesAdapter = new FrameSizesAdapter(requireContext, new ResizeFrameFragment$onViewCreated$adapter$1(getResizeFrameViewModel()));
        NResizeFrameFragmentBinding nResizeFrameFragmentBinding2 = this.binding;
        if (nResizeFrameFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nResizeFrameFragmentBinding2.frameSizesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.frameSizesRecyclerView");
        recyclerView2.setAdapter(frameSizesAdapter);
        getFrameTabsViewModel().onFrameStyleSet().observe(getViewLifecycleOwner(), new ResizeFrameFragment$onViewCreated$1(this));
        getResizeFrameViewModel().resizeFrameItems().observe(getViewLifecycleOwner(), new ResizeFrameFragment$onViewCreated$2(frameSizesAdapter));
        getResizeFrameViewModel().selectedFrameRatio().observe(getViewLifecycleOwner(), new ResizeFrameFragment$onViewCreated$3(frameSizesAdapter));
        getResizeFrameViewModel().onCustomFrameSizeInputRequested().observe(getViewLifecycleOwner(), new ResizeFrameFragment$onViewCreated$4(this));
    }

    /* access modifiers changed from: private */
    public final void showFrameSizeInputSheet(FrameSize frameSize) {
        CustomFrameSizeInputBottomSheet frameSizeInputSheet = getFrameSizeInputSheet();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        frameSizeInputSheet.show(parentFragmentManager, frameSize, new ResizeFrameFragment$showFrameSizeInputSheet$1(this));
    }
}
