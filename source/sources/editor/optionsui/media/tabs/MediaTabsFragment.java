package editor.optionsui.media.tabs;

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
import com.memes.editor.databinding.NMediaTabsFragmentBinding;
import editor.core.NicoFragment;
import editor.custom.TabsSheetAdapter;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/media/tabs/MediaTabsFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaTabsFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setAdapter", "adapter", "Leditor/custom/TabsSheetAdapter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaTabsFragment.kt */
public final class MediaTabsFragment extends NicoFragment {
    private NMediaTabsFragmentBinding binding;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NMediaTabsFragmentBinding inflate = NMediaTabsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaTabsFragmentBindin…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NMediaTabsFragmentBinding nMediaTabsFragmentBinding = this.binding;
        if (nMediaTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaTabsFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        NMediaTabsFragmentBinding nMediaTabsFragmentBinding = this.binding;
        if (nMediaTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaTabsFragmentBinding.footer.setOnDoneButtonClickListener(new MediaTabsFragment$onViewCreated$1(this));
        NMediaTabsFragmentBinding nMediaTabsFragmentBinding2 = this.binding;
        if (nMediaTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaTabsFragmentBinding2.footer.setOnCancelButtonClickListener(new MediaTabsFragment$onViewCreated$2(this));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "viewLifecycleOwner.lifecycle");
        setAdapter(new MediaTabsAdapter(childFragmentManager, lifecycle));
    }

    private final void setAdapter(TabsSheetAdapter tabsSheetAdapter) {
        NMediaTabsFragmentBinding nMediaTabsFragmentBinding = this.binding;
        if (nMediaTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager2 = nMediaTabsFragmentBinding.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.tabViewPager");
        viewPager2.setUserInputEnabled(false);
        NMediaTabsFragmentBinding nMediaTabsFragmentBinding2 = this.binding;
        if (nMediaTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager22 = nMediaTabsFragmentBinding2.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.tabViewPager");
        viewPager22.setAdapter(tabsSheetAdapter);
        if (tabsSheetAdapter != null) {
            NMediaTabsFragmentBinding nMediaTabsFragmentBinding3 = this.binding;
            if (nMediaTabsFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout = nMediaTabsFragmentBinding3.tabLayout;
            NMediaTabsFragmentBinding nMediaTabsFragmentBinding4 = this.binding;
            if (nMediaTabsFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            new TabLayoutMediator(tabLayout, nMediaTabsFragmentBinding4.tabViewPager, new MediaTabsFragment$setAdapter$1(tabsSheetAdapter)).attach();
        }
    }
}
