package editor.tools.filters.basicfilters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NBasicFiltersFragmentBinding;
import editor.tools.filters.basicfilters.BasicFilter;
import editor.tools.filters.basicfilters.BasicFiltersAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersFragment;", "Landroidx/fragment/app/Fragment;", "Leditor/tools/filters/basicfilters/BasicFiltersAdapter$Callback;", "()V", "binding", "Lcom/memes/editor/databinding/NBasicFiltersFragmentBinding;", "filtersAdapter", "Leditor/tools/filters/basicfilters/BasicFiltersAdapter;", "getFiltersAdapter", "()Leditor/tools/filters/basicfilters/BasicFiltersAdapter;", "filtersAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Leditor/tools/filters/basicfilters/BasicFiltersViewModel;", "getViewModel", "()Leditor/tools/filters/basicfilters/BasicFiltersViewModel;", "viewModel$delegate", "onBasicFilterSelected", "", "filterPreview", "Leditor/tools/filters/basicfilters/BasicFilter$Preview;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BasicFiltersFragment.kt */
public final class BasicFiltersFragment extends Fragment implements BasicFiltersAdapter.Callback {
    private NBasicFiltersFragmentBinding binding;
    private final Lazy filtersAdapter$delegate = LazyKt.lazy(new BasicFiltersFragment$filtersAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new BasicFiltersFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final BasicFiltersAdapter getFiltersAdapter() {
        return (BasicFiltersAdapter) this.filtersAdapter$delegate.getValue();
    }

    private final BasicFiltersViewModel getViewModel() {
        return (BasicFiltersViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NBasicFiltersFragmentBinding inflate = NBasicFiltersFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NBasicFiltersFragmentBin…flater, container, false)");
        this.binding = inflate;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NBasicFiltersFragmentBinding nBasicFiltersFragmentBinding = this.binding;
        if (nBasicFiltersFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nBasicFiltersFragmentBinding.filtersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.filtersRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NBasicFiltersFragmentBinding nBasicFiltersFragmentBinding2 = this.binding;
        if (nBasicFiltersFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nBasicFiltersFragmentBinding2.filtersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.filtersRecyclerView");
        recyclerView2.setAdapter(getFiltersAdapter());
        NBasicFiltersFragmentBinding nBasicFiltersFragmentBinding3 = this.binding;
        if (nBasicFiltersFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nBasicFiltersFragmentBinding3.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getViewModel().filters().observe(getViewLifecycleOwner(), new BasicFiltersFragment$onViewCreated$1(this));
        getViewModel().onFilterPreviewSelected().observe(getViewLifecycleOwner(), new BasicFiltersFragment$onViewCreated$2(this));
        getViewModel().onFilterTypeChanged().observe(getViewLifecycleOwner(), new BasicFiltersFragment$onViewCreated$3(this));
    }

    public void onBasicFilterSelected(BasicFilter.Preview preview) {
        Intrinsics.checkNotNullParameter(preview, "filterPreview");
        getViewModel().selectFilter(preview.getFilter());
    }
}
