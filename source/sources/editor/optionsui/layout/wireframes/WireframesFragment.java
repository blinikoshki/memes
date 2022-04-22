package editor.optionsui.layout.wireframes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NWireframesFragmentBinding;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NWireframesFragmentBinding;", "viewModel", "Leditor/optionsui/layout/wireframes/WireframesViewModel;", "getViewModel", "()Leditor/optionsui/layout/wireframes/WireframesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframesFragment.kt */
public final class WireframesFragment extends Fragment {
    private NWireframesFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new WireframesFragment$viewModel$2(this));

    private final WireframesViewModel getViewModel() {
        return (WireframesViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NWireframesFragmentBinding inflate = NWireframesFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NWireframesFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NWireframesFragmentBinding nWireframesFragmentBinding = this.binding;
        if (nWireframesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nWireframesFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NWireframesFragmentBinding nWireframesFragmentBinding = this.binding;
        if (nWireframesFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nWireframesFragmentBinding.wireframesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.wireframesRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        WireframesAdapter wireframesAdapter = new WireframesAdapter(requireContext, new WireframesFragment$onViewCreated$adapter$1(getViewModel()));
        NWireframesFragmentBinding nWireframesFragmentBinding2 = this.binding;
        if (nWireframesFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nWireframesFragmentBinding2.wireframesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.wireframesRecyclerView");
        recyclerView2.setAdapter(wireframesAdapter);
        getViewModel().wireframeItems().observe(getViewLifecycleOwner(), new WireframesFragment$onViewCreated$1(wireframesAdapter));
        getViewModel().selectedWireframeId().observe(getViewLifecycleOwner(), new WireframesFragment$onViewCreated$2(wireframesAdapter));
    }
}
