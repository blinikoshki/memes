package editor.optionsui.layout.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.memes.editor.databinding.NLayoutTabsFragmentBinding;
import editor.core.NicoFragment;
import editor.custom.TabsSheetAdapter;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo26107d2 = {"Leditor/optionsui/layout/tabs/LayoutTabsFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NLayoutTabsFragmentBinding;", "tabsViewModel", "Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "getTabsViewModel", "()Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "tabsViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setAdapter", "adapter", "Leditor/custom/TabsSheetAdapter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayoutTabsFragment.kt */
public final class LayoutTabsFragment extends NicoFragment {
    private NLayoutTabsFragmentBinding binding;
    private final Lazy tabsViewModel$delegate = LazyKt.lazy(new LayoutTabsFragment$tabsViewModel$2(this));

    /* access modifiers changed from: private */
    public final LayoutTabsViewModel getTabsViewModel() {
        return (LayoutTabsViewModel) this.tabsViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NLayoutTabsFragmentBinding inflate = NLayoutTabsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NLayoutTabsFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding = this.binding;
        if (nLayoutTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nLayoutTabsFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding = this.binding;
        if (nLayoutTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nLayoutTabsFragmentBinding.footer.setOnDoneButtonClickListener(new LayoutTabsFragment$onViewCreated$1(this));
        NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding2 = this.binding;
        if (nLayoutTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nLayoutTabsFragmentBinding2.footer.setOnCancelButtonClickListener(new LayoutTabsFragment$onViewCreated$2(this));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "viewLifecycleOwner.lifecycle");
        setAdapter(new LayoutTabsAdapter(childFragmentManager, lifecycle));
    }

    private final void setAdapter(TabsSheetAdapter tabsSheetAdapter) {
        NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding = this.binding;
        if (nLayoutTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager2 = nLayoutTabsFragmentBinding.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.tabViewPager");
        viewPager2.setUserInputEnabled(false);
        NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding2 = this.binding;
        if (nLayoutTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager22 = nLayoutTabsFragmentBinding2.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.tabViewPager");
        viewPager22.setAdapter(tabsSheetAdapter);
        if (tabsSheetAdapter != null) {
            NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding3 = this.binding;
            if (nLayoutTabsFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout = nLayoutTabsFragmentBinding3.tabLayout;
            NLayoutTabsFragmentBinding nLayoutTabsFragmentBinding4 = this.binding;
            if (nLayoutTabsFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            new TabLayoutMediator(tabLayout, nLayoutTabsFragmentBinding4.tabViewPager, new LayoutTabsFragment$setAdapter$1(tabsSheetAdapter)).attach();
        }
    }
}
