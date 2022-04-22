package editor.optionsui.frame.tabs;

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
import com.memes.editor.databinding.NFrameTabsFragmentBinding;
import editor.core.NicoFragment;
import editor.custom.TabsSheetAdapter;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo26107d2 = {"Leditor/optionsui/frame/tabs/FrameTabsFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NFrameTabsFragmentBinding;", "tabsViewModel", "Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "getTabsViewModel", "()Leditor/optionsui/frame/tabs/FrameTabsViewModel;", "tabsViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setAdapter", "adapter", "Leditor/custom/TabsSheetAdapter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameTabsFragment.kt */
public final class FrameTabsFragment extends NicoFragment {
    private NFrameTabsFragmentBinding binding;
    private final Lazy tabsViewModel$delegate = LazyKt.lazy(new FrameTabsFragment$tabsViewModel$2(this));

    /* access modifiers changed from: private */
    public final FrameTabsViewModel getTabsViewModel() {
        return (FrameTabsViewModel) this.tabsViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NFrameTabsFragmentBinding inflate = NFrameTabsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NFrameTabsFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NFrameTabsFragmentBinding nFrameTabsFragmentBinding = this.binding;
        if (nFrameTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nFrameTabsFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NFrameTabsFragmentBinding nFrameTabsFragmentBinding = this.binding;
        if (nFrameTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nFrameTabsFragmentBinding.footer.setOnDoneButtonClickListener(new FrameTabsFragment$onViewCreated$1(this));
        NFrameTabsFragmentBinding nFrameTabsFragmentBinding2 = this.binding;
        if (nFrameTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nFrameTabsFragmentBinding2.footer.setOnCancelButtonClickListener(new FrameTabsFragment$onViewCreated$2(this));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "viewLifecycleOwner.lifecycle");
        setAdapter(new FrameTabsAdapter(childFragmentManager, lifecycle));
    }

    private final void setAdapter(TabsSheetAdapter tabsSheetAdapter) {
        NFrameTabsFragmentBinding nFrameTabsFragmentBinding = this.binding;
        if (nFrameTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager2 = nFrameTabsFragmentBinding.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.tabViewPager");
        viewPager2.setUserInputEnabled(false);
        NFrameTabsFragmentBinding nFrameTabsFragmentBinding2 = this.binding;
        if (nFrameTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager22 = nFrameTabsFragmentBinding2.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.tabViewPager");
        viewPager22.setAdapter(tabsSheetAdapter);
        if (tabsSheetAdapter != null) {
            NFrameTabsFragmentBinding nFrameTabsFragmentBinding3 = this.binding;
            if (nFrameTabsFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout = nFrameTabsFragmentBinding3.tabLayout;
            NFrameTabsFragmentBinding nFrameTabsFragmentBinding4 = this.binding;
            if (nFrameTabsFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            new TabLayoutMediator(tabLayout, nFrameTabsFragmentBinding4.tabViewPager, new FrameTabsFragment$setAdapter$1(tabsSheetAdapter)).attach();
        }
    }
}
