package editor.tools.filters.deepfryfilters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.PairObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NDeepFryFiltersFragmentBinding;
import editor.editor.EditorPlanViewModel;
import editor.tools.filters.deepfryfilters.DeepFryFilter;
import editor.tools.filters.deepfryfilters.DeepFryFiltersAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersFragment;", "Landroidx/fragment/app/Fragment;", "Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$Callback;", "()V", "binding", "Lcom/memes/editor/databinding/NDeepFryFiltersFragmentBinding;", "editorPlanViewModel", "Leditor/editor/EditorPlanViewModel;", "getEditorPlanViewModel", "()Leditor/editor/EditorPlanViewModel;", "editorPlanViewModel$delegate", "Lkotlin/Lazy;", "filtersAdapter", "Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter;", "getFiltersAdapter", "()Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter;", "filtersAdapter$delegate", "viewModel", "Leditor/tools/filters/deepfryfilters/DeepFryFiltersViewModel;", "getViewModel", "()Leditor/tools/filters/deepfryfilters/DeepFryFiltersViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeepFryFilterSelected", "", "filterPreview", "Leditor/tools/filters/deepfryfilters/DeepFryFilter$Preview;", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeepFryFiltersFragment.kt */
public final class DeepFryFiltersFragment extends Fragment implements DeepFryFiltersAdapter.Callback {
    /* access modifiers changed from: private */
    public NDeepFryFiltersFragmentBinding binding;
    private final Lazy editorPlanViewModel$delegate = LazyKt.lazy(new DeepFryFiltersFragment$editorPlanViewModel$2(this));
    private final Lazy filtersAdapter$delegate = LazyKt.lazy(new DeepFryFiltersFragment$filtersAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new DeepFryFiltersFragment$viewModel$2(this));

    private final EditorPlanViewModel getEditorPlanViewModel() {
        return (EditorPlanViewModel) this.editorPlanViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeepFryFiltersAdapter getFiltersAdapter() {
        return (DeepFryFiltersAdapter) this.filtersAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeepFryFiltersViewModel getViewModel() {
        return (DeepFryFiltersViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NDeepFryFiltersFragmentBinding access$getBinding$p(DeepFryFiltersFragment deepFryFiltersFragment) {
        NDeepFryFiltersFragmentBinding nDeepFryFiltersFragmentBinding = deepFryFiltersFragment.binding;
        if (nDeepFryFiltersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nDeepFryFiltersFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NDeepFryFiltersFragmentBinding inflate = NDeepFryFiltersFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NDeepFryFiltersFragmentB…flater, container, false)");
        this.binding = inflate;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NDeepFryFiltersFragmentBinding nDeepFryFiltersFragmentBinding = this.binding;
        if (nDeepFryFiltersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nDeepFryFiltersFragmentBinding.filtersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.filtersRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NDeepFryFiltersFragmentBinding nDeepFryFiltersFragmentBinding2 = this.binding;
        if (nDeepFryFiltersFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nDeepFryFiltersFragmentBinding2.filtersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.filtersRecyclerView");
        recyclerView2.setAdapter(getFiltersAdapter());
        NDeepFryFiltersFragmentBinding nDeepFryFiltersFragmentBinding3 = this.binding;
        if (nDeepFryFiltersFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nDeepFryFiltersFragmentBinding3.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getViewModel().setOnEditorPlanRequestedListener(getEditorPlanViewModel());
        getViewModel().filters().observe(getViewLifecycleOwner(), new DeepFryFiltersFragment$onViewCreated$1(this));
        getViewModel().onFilterPreviewSelected().observe(getViewLifecycleOwner(), new DeepFryFiltersFragment$onViewCreated$2(this));
        getEditorPlanViewModel().onEditorPlanChanged().observe(getViewLifecycleOwner(), new PairObserver(new DeepFryFiltersFragment$onViewCreated$3(this)));
    }

    public void onDeepFryFilterSelected(DeepFryFilter.Preview preview) {
        Intrinsics.checkNotNullParameter(preview, "filterPreview");
        getViewModel().selectFilter(preview.getFilter());
    }
}
