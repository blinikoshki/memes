package editor.editor.dashboard.drafts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NDraftsFragmentBinding;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, mo26107d2 = {"Leditor/editor/dashboard/drafts/EditorDraftsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NDraftsFragmentBinding;", "draftsAdapter", "Leditor/editor/dashboard/drafts/EditorDraftsAdapter;", "getDraftsAdapter", "()Leditor/editor/dashboard/drafts/EditorDraftsAdapter;", "draftsAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "getViewModel", "()Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "showDraftPreview", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "unused")
/* compiled from: EditorDraftsFragment.kt */
public final class EditorDraftsFragment extends Fragment {
    /* access modifiers changed from: private */
    public NDraftsFragmentBinding binding;
    private final Lazy draftsAdapter$delegate = LazyKt.lazy(new EditorDraftsFragment$draftsAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new EditorDraftsFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final EditorDraftsAdapter getDraftsAdapter() {
        return (EditorDraftsAdapter) this.draftsAdapter$delegate.getValue();
    }

    private final EditorDraftsViewModel getViewModel() {
        return (EditorDraftsViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NDraftsFragmentBinding access$getBinding$p(EditorDraftsFragment editorDraftsFragment) {
        NDraftsFragmentBinding nDraftsFragmentBinding = editorDraftsFragment.binding;
        if (nDraftsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nDraftsFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NDraftsFragmentBinding inflate = NDraftsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NDraftsFragmentBinding.i…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        NDraftsFragmentBinding nDraftsFragmentBinding = this.binding;
        if (nDraftsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nDraftsFragmentBinding.draftsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.draftsRecyclerView");
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        NDraftsFragmentBinding nDraftsFragmentBinding2 = this.binding;
        if (nDraftsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nDraftsFragmentBinding2.draftsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.draftsRecyclerView");
        recyclerView2.setAdapter(getDraftsAdapter());
        NDraftsFragmentBinding nDraftsFragmentBinding3 = this.binding;
        if (nDraftsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nDraftsFragmentBinding3.backImageView.setOnClickListener(new EditorDraftsFragment$onViewCreated$1(this));
        getViewModel().onDraftsFound().observe(getViewLifecycleOwner(), new EditorDraftsFragment$onViewCreated$2(this));
    }

    /* access modifiers changed from: private */
    public final void showDraftPreview(EditorDraft editorDraft) {
        ActivityProxyBridge activityProxyBridge = ActivityProxyBridge.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        activityProxyBridge.launchDraftPreviewPage(requireContext, new EditorDraftsFragment$showDraftPreview$1(editorDraft));
    }

    public void onResume() {
        super.onResume();
        getViewModel().fetchDrafts();
    }
}
