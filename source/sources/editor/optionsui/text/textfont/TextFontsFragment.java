package editor.optionsui.text.textfont;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.PairObserver;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.databinding.NTextFontsFragmentBinding;
import editor.custom.liveevent.LiveEventObserver;
import editor.editor.EditorPlanViewModel;
import editor.optionsui.text.tabs.TextTabsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "()V", "binding", "Lcom/memes/editor/databinding/NTextFontsFragmentBinding;", "editorPlanViewModel", "Leditor/editor/EditorPlanViewModel;", "getEditorPlanViewModel", "()Leditor/editor/EditorPlanViewModel;", "editorPlanViewModel$delegate", "Lkotlin/Lazy;", "tabSelectedByScroll", "", "tabSelectedByUser", "textFontsViewModel", "Leditor/optionsui/text/textfont/TextFontsViewModel;", "getTextFontsViewModel", "()Leditor/optionsui/text/textfont/TextFontsViewModel;", "textFontsViewModel$delegate", "textTabsViewModel", "Leditor/optionsui/text/tabs/TextTabsViewModel;", "getTextTabsViewModel", "()Leditor/optionsui/text/tabs/TextTabsViewModel;", "textTabsViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "onViewCreated", "view", "showSelectedTabByFontCategory", "category", "Leditor/optionsui/text/textfont/TextFontCategory;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsFragment.kt */
public final class TextFontsFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    /* access modifiers changed from: private */
    public NTextFontsFragmentBinding binding;
    private final Lazy editorPlanViewModel$delegate = LazyKt.lazy(new TextFontsFragment$editorPlanViewModel$2(this));
    private boolean tabSelectedByScroll;
    private boolean tabSelectedByUser;
    private final Lazy textFontsViewModel$delegate = LazyKt.lazy(new TextFontsFragment$textFontsViewModel$2(this));
    private final Lazy textTabsViewModel$delegate = LazyKt.lazy(new TextFontsFragment$textTabsViewModel$2(this));

    private final EditorPlanViewModel getEditorPlanViewModel() {
        return (EditorPlanViewModel) this.editorPlanViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextFontsViewModel getTextFontsViewModel() {
        return (TextFontsViewModel) this.textFontsViewModel$delegate.getValue();
    }

    private final TextTabsViewModel getTextTabsViewModel() {
        return (TextTabsViewModel) this.textTabsViewModel$delegate.getValue();
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public static final /* synthetic */ NTextFontsFragmentBinding access$getBinding$p(TextFontsFragment textFontsFragment) {
        NTextFontsFragmentBinding nTextFontsFragmentBinding = textFontsFragment.binding;
        if (nTextFontsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextFontsFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextFontsFragmentBinding inflate = NTextFontsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextFontsFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getTextFontsViewModel().setOnEditorPlanRequestedListener(getEditorPlanViewModel());
        getTextFontsViewModel().setOnPropertyUpdatedListener(getTextTabsViewModel());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 0, false);
        NTextFontsFragmentBinding nTextFontsFragmentBinding = this.binding;
        if (nTextFontsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nTextFontsFragmentBinding.fontsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.fontsRecyclerView");
        recyclerView.setLayoutManager(gridLayoutManager);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        TextFontsAdapter textFontsAdapter = new TextFontsAdapter(requireContext, new TextFontsFragment$onViewCreated$adapter$1(getTextFontsViewModel()));
        NTextFontsFragmentBinding nTextFontsFragmentBinding2 = this.binding;
        if (nTextFontsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nTextFontsFragmentBinding2.fontsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.fontsRecyclerView");
        recyclerView2.setAdapter(textFontsAdapter);
        gridLayoutManager.setSpanSizeLookup(new TextFontsFragment$onViewCreated$1(textFontsAdapter));
        NTextFontsFragmentBinding nTextFontsFragmentBinding3 = this.binding;
        if (nTextFontsFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextFontsFragmentBinding3.fontsRecyclerView.clearOnScrollListeners();
        NTextFontsFragmentBinding nTextFontsFragmentBinding4 = this.binding;
        if (nTextFontsFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextFontsFragmentBinding4.fontsRecyclerView.addOnScrollListener(new TextFontsFragment$onViewCreated$2(this, gridLayoutManager, gridLayoutManager, new TextFontsFragment$onViewCreated$3(this)));
        NTextFontsFragmentBinding nTextFontsFragmentBinding5 = this.binding;
        if (nTextFontsFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextFontsFragmentBinding5.tabLayout.clearOnTabSelectedListeners();
        NTextFontsFragmentBinding nTextFontsFragmentBinding6 = this.binding;
        if (nTextFontsFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextFontsFragmentBinding6.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        getTextFontsViewModel().fontItems().observe(getViewLifecycleOwner(), new TextFontsFragment$onViewCreated$4(textFontsAdapter));
        getTextFontsViewModel().fontCategories().observe(getViewLifecycleOwner(), new TextFontsFragment$onViewCreated$5(this));
        getTextFontsViewModel().onLocalTextFontSelected().observe(getViewLifecycleOwner(), new TextFontsFragment$onViewCreated$6(this, textFontsAdapter));
        getTextFontsViewModel().onNewRecentFontItemAdded().observe(getViewLifecycleOwner(), new LiveEventObserver(new TextFontsFragment$onViewCreated$7(this, textFontsAdapter)));
        getTextFontsViewModel().onRecentFontItemRemoved().observe(getViewLifecycleOwner(), new LiveEventObserver(new TextFontsFragment$onViewCreated$8(this, textFontsAdapter)));
        getTextFontsViewModel().onRecentFontCategoryAdded().observe(getViewLifecycleOwner(), new LiveEventObserver(new TextFontsFragment$onViewCreated$9(this)));
        getTextFontsViewModel().onShowFontsOnPosition().observe(getViewLifecycleOwner(), new TextFontsFragment$onViewCreated$10(gridLayoutManager));
        getTextTabsViewModel().onTextStyleSet().observe(getViewLifecycleOwner(), new TextFontsFragment$onViewCreated$11(this));
        getEditorPlanViewModel().onEditorPlanChanged().observe(getViewLifecycleOwner(), new PairObserver(new TextFontsFragment$onViewCreated$12(this, textFontsAdapter)));
        getTextFontsViewModel().fetchFonts();
    }

    /* access modifiers changed from: private */
    public final void showSelectedTabByFontCategory(TextFontCategory textFontCategory) {
        int i = 0;
        if (this.tabSelectedByUser) {
            this.tabSelectedByUser = false;
            return;
        }
        NTextFontsFragmentBinding nTextFontsFragmentBinding = this.binding;
        if (nTextFontsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = nTextFontsFragmentBinding.tabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabLayout");
        int tabCount = tabLayout.getTabCount();
        while (i < tabCount) {
            NTextFontsFragmentBinding nTextFontsFragmentBinding2 = this.binding;
            if (nTextFontsFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout.Tab tabAt = nTextFontsFragmentBinding2.tabLayout.getTabAt(i);
            if (tabAt == null || !Intrinsics.areEqual((Object) textFontCategory.getDisplayName(), (Object) tabAt.getText())) {
                i++;
            } else {
                this.tabSelectedByScroll = true;
                NTextFontsFragmentBinding nTextFontsFragmentBinding3 = this.binding;
                if (nTextFontsFragmentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                nTextFontsFragmentBinding3.tabLayout.selectTab(tabAt);
                return;
            }
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        if (this.tabSelectedByScroll) {
            this.tabSelectedByScroll = false;
            return;
        }
        this.tabSelectedByUser = true;
        getTextFontsViewModel().changeSelectedFontCategoryPosition(tab != null ? Integer.valueOf(tab.getPosition()) : null);
    }

    public void onTabReselected(TabLayout.Tab tab) {
        if (this.tabSelectedByScroll) {
            this.tabSelectedByScroll = false;
            return;
        }
        this.tabSelectedByUser = true;
        getTextFontsViewModel().changeSelectedFontCategoryPosition(tab != null ? Integer.valueOf(tab.getPosition()) : null);
    }
}
