package editor.optionsui.text.textpaint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.databinding.NTextPaintsFragmentBinding;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsAdapter;
import editor.optionsui.text.tabs.TextTabsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010(\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, mo26107d2 = {"Leditor/optionsui/text/textpaint/TextPaintsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "()V", "binding", "Lcom/memes/editor/databinding/NTextPaintsFragmentBinding;", "textPaintAdapter", "Leditor/optionsui/text/textpaint/TextPaintsAdapter;", "getTextPaintAdapter", "()Leditor/optionsui/text/textpaint/TextPaintsAdapter;", "textPaintAdapter$delegate", "Lkotlin/Lazy;", "textPaintsViewModel", "Leditor/optionsui/text/textpaint/TextPaintsViewModel;", "getTextPaintsViewModel", "()Leditor/optionsui/text/textpaint/TextPaintsViewModel;", "textPaintsViewModel$delegate", "textTabsViewModel", "Leditor/optionsui/text/tabs/TextTabsViewModel;", "getTextTabsViewModel", "()Leditor/optionsui/text/tabs/TextTabsViewModel;", "textTabsViewModel$delegate", "onColorSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCustomizeColorPaintSelected", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "onViewCreated", "view", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextPaintsFragment.kt */
public final class TextPaintsFragment extends Fragment implements TabLayout.OnTabSelectedListener, ColorsAdapter.Callback {
    /* access modifiers changed from: private */
    public NTextPaintsFragmentBinding binding;
    private final Lazy textPaintAdapter$delegate = LazyKt.lazy(new TextPaintsFragment$textPaintAdapter$2(this));
    private final Lazy textPaintsViewModel$delegate = LazyKt.lazy(new TextPaintsFragment$textPaintsViewModel$2(this));
    private final Lazy textTabsViewModel$delegate = LazyKt.lazy(new TextPaintsFragment$textTabsViewModel$2(this));

    /* access modifiers changed from: private */
    public final TextPaintsAdapter getTextPaintAdapter() {
        return (TextPaintsAdapter) this.textPaintAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextPaintsViewModel getTextPaintsViewModel() {
        return (TextPaintsViewModel) this.textPaintsViewModel$delegate.getValue();
    }

    private final TextTabsViewModel getTextTabsViewModel() {
        return (TextTabsViewModel) this.textTabsViewModel$delegate.getValue();
    }

    public void onCustomizeColorPaintSelected(LayerPaint.Color color) {
        Intrinsics.checkNotNullParameter(color, "paint");
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public static final /* synthetic */ NTextPaintsFragmentBinding access$getBinding$p(TextPaintsFragment textPaintsFragment) {
        NTextPaintsFragmentBinding nTextPaintsFragmentBinding = textPaintsFragment.binding;
        if (nTextPaintsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextPaintsFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextPaintsFragmentBinding inflate = NTextPaintsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextPaintsFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getTextPaintsViewModel().setOnPropertyUpdatedListener(getTextTabsViewModel());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        NTextPaintsFragmentBinding nTextPaintsFragmentBinding = this.binding;
        if (nTextPaintsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nTextPaintsFragmentBinding.colorsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.colorsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        NTextPaintsFragmentBinding nTextPaintsFragmentBinding2 = this.binding;
        if (nTextPaintsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nTextPaintsFragmentBinding2.colorsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.colorsRecyclerView");
        recyclerView2.setAdapter(getTextPaintAdapter());
        NTextPaintsFragmentBinding nTextPaintsFragmentBinding3 = this.binding;
        if (nTextPaintsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextPaintsFragmentBinding3.tabLayout.clearOnTabSelectedListeners();
        NTextPaintsFragmentBinding nTextPaintsFragmentBinding4 = this.binding;
        if (nTextPaintsFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextPaintsFragmentBinding4.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        getTextTabsViewModel().onTextStyleSet().observe(getViewLifecycleOwner(), new TextPaintsFragment$onViewCreated$1(this));
        getTextPaintsViewModel().onColorsAvailable().observe(getViewLifecycleOwner(), new TextPaintsFragment$onViewCreated$2(this));
        getTextPaintsViewModel().onSelectedColorChanged().observe(getViewLifecycleOwner(), new TextPaintsFragment$onViewCreated$3(this));
        getTextPaintsViewModel().selectedColorTarget().observe(getViewLifecycleOwner(), new TextPaintsFragment$onViewCreated$4(this));
    }

    public void onTabSelected(TabLayout.Tab tab) {
        Integer valueOf = tab != null ? Integer.valueOf(tab.getPosition()) : null;
        int ordinal = TextPaintSelectionTarget.FONT.ordinal();
        if (valueOf != null && valueOf.intValue() == ordinal) {
            getTextPaintAdapter().changeSelectionTarget(TextPaintSelectionTarget.FONT);
            getTextPaintsViewModel().setFontColorMode();
            return;
        }
        int ordinal2 = TextPaintSelectionTarget.BACKGROUND.ordinal();
        if (valueOf != null && valueOf.intValue() == ordinal2) {
            getTextPaintAdapter().changeSelectionTarget(TextPaintSelectionTarget.BACKGROUND);
            getTextPaintsViewModel().setBackgroundColorMode();
        }
    }

    public void onColorSelected(LayerPaint.Color color) {
        Intrinsics.checkNotNullParameter(color, "paint");
        getTextPaintsViewModel().updateSelectedColor(color);
    }
}
