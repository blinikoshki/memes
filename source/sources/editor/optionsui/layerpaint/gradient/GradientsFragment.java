package editor.optionsui.layerpaint.gradient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NGradientsFragmentBinding;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.gradient.GradientsAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, mo26107d2 = {"Leditor/optionsui/layerpaint/gradient/GradientsFragment;", "Landroidx/fragment/app/Fragment;", "Leditor/optionsui/layerpaint/gradient/GradientsAdapter$Callback;", "()V", "binding", "Lcom/memes/editor/databinding/NGradientsFragmentBinding;", "gradientsAdapter", "Leditor/optionsui/layerpaint/gradient/GradientsAdapter;", "getGradientsAdapter", "()Leditor/optionsui/layerpaint/gradient/GradientsAdapter;", "gradientsAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Leditor/optionsui/layerpaint/gradient/GradientsViewModel;", "getViewModel", "()Leditor/optionsui/layerpaint/gradient/GradientsViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGradientSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GradientsFragment.kt */
public final class GradientsFragment extends Fragment implements GradientsAdapter.Callback {
    private NGradientsFragmentBinding binding;
    private final Lazy gradientsAdapter$delegate = LazyKt.lazy(new GradientsFragment$gradientsAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new GradientsFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final GradientsAdapter getGradientsAdapter() {
        return (GradientsAdapter) this.gradientsAdapter$delegate.getValue();
    }

    private final GradientsViewModel getViewModel() {
        return (GradientsViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NGradientsFragmentBinding inflate = NGradientsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NGradientsFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NGradientsFragmentBinding nGradientsFragmentBinding = this.binding;
        if (nGradientsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nGradientsFragmentBinding.gradientsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.gradientsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NGradientsFragmentBinding nGradientsFragmentBinding2 = this.binding;
        if (nGradientsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nGradientsFragmentBinding2.gradientsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.gradientsRecyclerView");
        recyclerView2.setAdapter(getGradientsAdapter());
        getViewModel().onGradientsAvailable().observe(getViewLifecycleOwner(), new GradientsFragment$onViewCreated$1(this));
        getViewModel().onSelectedGradientChanged().observe(getViewLifecycleOwner(), new GradientsFragment$onViewCreated$2(this));
    }

    public void onGradientSelected(LayerPaint.Gradient gradient) {
        Intrinsics.checkNotNullParameter(gradient, "paint");
        getViewModel().changeSelectedGradientPaint(gradient);
    }
}
