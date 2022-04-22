package editor.tools.filters.tabs;

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
import com.memes.editor.databinding.NMediaFiltersTabFragmentBinding;
import editor.core.NicoFragment;
import editor.custom.TabsSheetAdapter;
import editor.tools.filters.conflation.FilterRequest;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo26107d2 = {"Leditor/tools/filters/tabs/MediaFilterTabsFragment;", "Leditor/core/NicoFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaFiltersTabFragmentBinding;", "viewModel", "Leditor/tools/filters/tabs/MediaFilterTabsViewModel;", "getViewModel", "()Leditor/tools/filters/tabs/MediaFilterTabsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setAdapter", "adapter", "Leditor/custom/TabsSheetAdapter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaFilterTabsFragment.kt */
public final class MediaFilterTabsFragment extends NicoFragment {
    /* access modifiers changed from: private */
    public NMediaFiltersTabFragmentBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MediaFilterTabsFragment$viewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FilterRequest.FilterTab.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterRequest.FilterTab.ENHANCE.ordinal()] = 1;
            iArr[FilterRequest.FilterTab.FILTERS.ordinal()] = 2;
            iArr[FilterRequest.FilterTab.DEEP_FRY.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final MediaFilterTabsViewModel getViewModel() {
        return (MediaFilterTabsViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ NMediaFiltersTabFragmentBinding access$getBinding$p(MediaFilterTabsFragment mediaFilterTabsFragment) {
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding = mediaFilterTabsFragment.binding;
        if (nMediaFiltersTabFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaFiltersTabFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NMediaFiltersTabFragmentBinding inflate = NMediaFiltersTabFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaFiltersTabFragment…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding = this.binding;
        if (nMediaFiltersTabFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nMediaFiltersTabFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "viewLifecycleOwner.lifecycle");
        MediaFilterTabsAdapter mediaFilterTabsAdapter = new MediaFilterTabsAdapter(childFragmentManager, lifecycle);
        setAdapter(mediaFilterTabsAdapter);
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding = this.binding;
        if (nMediaFiltersTabFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaFiltersTabFragmentBinding.footer.setOnDoneButtonClickListener(new MediaFilterTabsFragment$onViewCreated$1(this));
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding2 = this.binding;
        if (nMediaFiltersTabFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nMediaFiltersTabFragmentBinding2.footer.setOnCancelButtonClickListener(new MediaFilterTabsFragment$onViewCreated$2(this));
        getViewModel().onFilterTabSelected().observe(getViewLifecycleOwner(), new MediaFilterTabsFragment$onViewCreated$3(this, mediaFilterTabsAdapter));
    }

    private final void setAdapter(TabsSheetAdapter tabsSheetAdapter) {
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding = this.binding;
        if (nMediaFiltersTabFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager2 = nMediaFiltersTabFragmentBinding.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.tabViewPager");
        viewPager2.setUserInputEnabled(false);
        NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding2 = this.binding;
        if (nMediaFiltersTabFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager22 = nMediaFiltersTabFragmentBinding2.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.tabViewPager");
        viewPager22.setAdapter(tabsSheetAdapter);
        if (tabsSheetAdapter != null) {
            NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding3 = this.binding;
            if (nMediaFiltersTabFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout = nMediaFiltersTabFragmentBinding3.tabLayout;
            NMediaFiltersTabFragmentBinding nMediaFiltersTabFragmentBinding4 = this.binding;
            if (nMediaFiltersTabFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            new TabLayoutMediator(tabLayout, nMediaFiltersTabFragmentBinding4.tabViewPager, new MediaFilterTabsFragment$setAdapter$1(tabsSheetAdapter)).attach();
        }
    }
}
