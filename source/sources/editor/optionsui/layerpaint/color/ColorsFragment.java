package editor.optionsui.layerpaint.color;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NColorsFragmentBinding;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo26107d2 = {"Leditor/optionsui/layerpaint/color/ColorsFragment;", "Landroidx/fragment/app/Fragment;", "Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "()V", "binding", "Lcom/memes/editor/databinding/NColorsFragmentBinding;", "colorsAdapter", "Leditor/optionsui/layerpaint/color/ColorsAdapter;", "getColorsAdapter", "()Leditor/optionsui/layerpaint/color/ColorsAdapter;", "colorsAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Leditor/optionsui/layerpaint/color/ColorsViewModel;", "getViewModel", "()Leditor/optionsui/layerpaint/color/ColorsViewModel;", "viewModel$delegate", "onColorSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCustomizeColorPaintSelected", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorsFragment.kt */
public final class ColorsFragment extends Fragment implements ColorsAdapter.Callback {
    private NColorsFragmentBinding binding;
    private final Lazy colorsAdapter$delegate = LazyKt.lazy(new ColorsFragment$colorsAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new ColorsFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final ColorsAdapter getColorsAdapter() {
        return (ColorsAdapter) this.colorsAdapter$delegate.getValue();
    }

    private final ColorsViewModel getViewModel() {
        return (ColorsViewModel) this.viewModel$delegate.getValue();
    }

    public void onCustomizeColorPaintSelected(LayerPaint.Color color) {
        Intrinsics.checkNotNullParameter(color, "paint");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NColorsFragmentBinding inflate = NColorsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NColorsFragmentBinding.i…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NColorsFragmentBinding nColorsFragmentBinding = this.binding;
        if (nColorsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nColorsFragmentBinding.colorsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.colorsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NColorsFragmentBinding nColorsFragmentBinding2 = this.binding;
        if (nColorsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nColorsFragmentBinding2.colorsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.colorsRecyclerView");
        recyclerView2.setAdapter(getColorsAdapter());
        getViewModel().onColorsAvailable().observe(getViewLifecycleOwner(), new ColorsFragment$onViewCreated$1(this));
        getViewModel().onSelectedColorChanged().observe(getViewLifecycleOwner(), new ColorsFragment$onViewCreated$2(this));
    }

    public void onColorSelected(LayerPaint.Color color) {
        Intrinsics.checkNotNullParameter(color, "paint");
        getColorsAdapter().setSelectedColor(color);
        getViewModel().changeSelectedColorPaint(color);
    }
}
