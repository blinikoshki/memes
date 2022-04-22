package editor.optionsui.watermark.savedwatermarks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NSavedWatermarksFragmentBinding;
import editor.custom.liveevent.LiveEventObserver;
import editor.optionsui.watermark.Watermark;
import editor.optionsui.watermark.deleteconfimation.DeleteWatermarkBottomSheet;
import editor.optionsui.watermark.importpreview.ImportWatermarkBottomSheet;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, mo26107d2 = {"Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksFragment;", "Landroidx/fragment/app/Fragment;", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapterListener;", "()V", "binding", "Lcom/memes/editor/databinding/NSavedWatermarksFragmentBinding;", "viewModel", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "getViewModel", "()Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "watermarkPreviewBottomSheet", "Leditor/optionsui/watermark/importpreview/ImportWatermarkBottomSheet;", "getWatermarkPreviewBottomSheet", "()Leditor/optionsui/watermark/importpreview/ImportWatermarkBottomSheet;", "watermarkPreviewBottomSheet$delegate", "watermarksAdapter", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapter;", "getWatermarksAdapter", "()Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapter;", "watermarksAdapter$delegate", "ensureSavedWatermarksHintVisibility", "", "hideSavedWatermarksHint", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSavedWatermarkDeleteRequested", "watermark", "Leditor/optionsui/watermark/Watermark;", "onSavedWatermarkTapped", "onViewCreated", "view", "showSavedWatermarksHint", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksFragment.kt */
public final class SavedWatermarksFragment extends Fragment implements SavedWatermarksAdapterListener {
    private NSavedWatermarksFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new SavedWatermarksFragment$viewModel$2(this));
    private final Lazy watermarkPreviewBottomSheet$delegate = LazyKt.lazy(SavedWatermarksFragment$watermarkPreviewBottomSheet$2.INSTANCE);
    private final Lazy watermarksAdapter$delegate = LazyKt.lazy(new SavedWatermarksFragment$watermarksAdapter$2(this));

    /* access modifiers changed from: private */
    public final SavedWatermarksViewModel getViewModel() {
        return (SavedWatermarksViewModel) this.viewModel$delegate.getValue();
    }

    private final ImportWatermarkBottomSheet getWatermarkPreviewBottomSheet() {
        return (ImportWatermarkBottomSheet) this.watermarkPreviewBottomSheet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SavedWatermarksAdapter getWatermarksAdapter() {
        return (SavedWatermarksAdapter) this.watermarksAdapter$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NSavedWatermarksFragmentBinding inflate = NSavedWatermarksFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NSavedWatermarksFragment…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding = this.binding;
        if (nSavedWatermarksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nSavedWatermarksFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding = this.binding;
        if (nSavedWatermarksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nSavedWatermarksFragmentBinding.watermarksRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.watermarksRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding2 = this.binding;
        if (nSavedWatermarksFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nSavedWatermarksFragmentBinding2.watermarksRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.watermarksRecyclerView");
        recyclerView2.setAdapter(getWatermarksAdapter());
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding3 = this.binding;
        if (nSavedWatermarksFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nSavedWatermarksFragmentBinding3.footer.setOnCloseButtonClickListener(new SavedWatermarksFragment$onViewCreated$1(this));
        getViewModel().savedWatermarks().observe(getViewLifecycleOwner(), new SavedWatermarksFragment$onViewCreated$2(this));
        getViewModel().onWatermarkDeleted().observe(getViewLifecycleOwner(), new LiveEventObserver(new SavedWatermarksFragment$onViewCreated$3(this)));
        ensureSavedWatermarksHintVisibility();
    }

    /* access modifiers changed from: private */
    public final void ensureSavedWatermarksHintVisibility() {
        if (getWatermarksAdapter().getItemCount() == 0) {
            showSavedWatermarksHint();
        } else {
            hideSavedWatermarksHint();
        }
    }

    private final void showSavedWatermarksHint() {
        Animation loadAnimation = AnimationUtils.loadAnimation(requireContext(), C4175R.anim.anim_saved_watermarks_hint);
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding = this.binding;
        if (nSavedWatermarksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nSavedWatermarksFragmentBinding.savedWatermarksHintView.startAnimation(loadAnimation);
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding2 = this.binding;
        if (nSavedWatermarksFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = nSavedWatermarksFragmentBinding2.savedWatermarksHintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.savedWatermarksHintView");
        textView.setVisibility(0);
    }

    private final void hideSavedWatermarksHint() {
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding = this.binding;
        if (nSavedWatermarksFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nSavedWatermarksFragmentBinding.savedWatermarksHintView.clearAnimation();
        NSavedWatermarksFragmentBinding nSavedWatermarksFragmentBinding2 = this.binding;
        if (nSavedWatermarksFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = nSavedWatermarksFragmentBinding2.savedWatermarksHintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.savedWatermarksHintView");
        textView.setVisibility(8);
    }

    public void onDestroyView() {
        hideSavedWatermarksHint();
        super.onDestroyView();
    }

    public void onSavedWatermarkTapped(Watermark watermark) {
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        ImportWatermarkBottomSheet watermarkPreviewBottomSheet = getWatermarkPreviewBottomSheet();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        watermarkPreviewBottomSheet.show(parentFragmentManager, watermark, new SavedWatermarksFragment$onSavedWatermarkTapped$1(this, watermark));
    }

    public void onSavedWatermarkDeleteRequested(Watermark watermark) {
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        DeleteWatermarkBottomSheet deleteWatermarkBottomSheet = new DeleteWatermarkBottomSheet();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        deleteWatermarkBottomSheet.show(parentFragmentManager, new SavedWatermarksFragment$onSavedWatermarkDeleteRequested$1(this, watermark));
    }
}
