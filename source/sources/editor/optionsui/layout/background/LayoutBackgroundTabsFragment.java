package editor.optionsui.layout.background;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.memes.editor.databinding.NLayoutBackgroundTabsFragmentBinding;
import editor.common.assetsprovider.AssetsProvider;
import editor.custom.TabsSheetAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsViewModel;
import editor.optionsui.layerpaint.gradient.GradientsViewModel;
import editor.optionsui.layerpaint.pattern.PatternsViewModel;
import editor.optionsui.layout.tabs.LayoutTabsViewModel;
import editor.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u000101H\u0002J\u0012\u00102\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u000103H\u0002J\u001a\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u000108H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b!\u0010\"¨\u00069"}, mo26107d2 = {"Leditor/optionsui/layout/background/LayoutBackgroundTabsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "getAssetsProvider", "()Leditor/common/assetsprovider/AssetsProvider;", "assetsProvider$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/editor/databinding/NLayoutBackgroundTabsFragmentBinding;", "colorsViewModel", "Leditor/optionsui/layerpaint/color/ColorsViewModel;", "getColorsViewModel", "()Leditor/optionsui/layerpaint/color/ColorsViewModel;", "colorsViewModel$delegate", "gradientsViewModel", "Leditor/optionsui/layerpaint/gradient/GradientsViewModel;", "getGradientsViewModel", "()Leditor/optionsui/layerpaint/gradient/GradientsViewModel;", "gradientsViewModel$delegate", "layoutBackgroundViewModel", "Leditor/optionsui/layout/background/LayoutBackgroundViewModel;", "getLayoutBackgroundViewModel", "()Leditor/optionsui/layout/background/LayoutBackgroundViewModel;", "layoutBackgroundViewModel$delegate", "layoutTabsViewModel", "Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "getLayoutTabsViewModel", "()Leditor/optionsui/layout/tabs/LayoutTabsViewModel;", "layoutTabsViewModel$delegate", "patternsViewModel", "Leditor/optionsui/layerpaint/pattern/PatternsViewModel;", "getPatternsViewModel", "()Leditor/optionsui/layerpaint/pattern/PatternsViewModel;", "patternsViewModel$delegate", "onColorSelected", "", "background", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGradientSelected", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "onPatternSelected", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "onViewCreated", "view", "setAdapter", "adapter", "Leditor/custom/TabsSheetAdapter;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundTabsFragment.kt */
public final class LayoutBackgroundTabsFragment extends Fragment {
    private final Lazy assetsProvider$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$assetsProvider$2(this));
    private NLayoutBackgroundTabsFragmentBinding binding;
    private final Lazy colorsViewModel$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$colorsViewModel$2(this));
    private final Lazy gradientsViewModel$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$gradientsViewModel$2(this));
    private final Lazy layoutBackgroundViewModel$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$layoutBackgroundViewModel$2(this));
    private final Lazy layoutTabsViewModel$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$layoutTabsViewModel$2(this));
    private final Lazy patternsViewModel$delegate = LazyKt.lazy(new LayoutBackgroundTabsFragment$patternsViewModel$2(this));

    /* access modifiers changed from: private */
    public final AssetsProvider getAssetsProvider() {
        return (AssetsProvider) this.assetsProvider$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ColorsViewModel getColorsViewModel() {
        return (ColorsViewModel) this.colorsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GradientsViewModel getGradientsViewModel() {
        return (GradientsViewModel) this.gradientsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutBackgroundViewModel getLayoutBackgroundViewModel() {
        return (LayoutBackgroundViewModel) this.layoutBackgroundViewModel$delegate.getValue();
    }

    private final LayoutTabsViewModel getLayoutTabsViewModel() {
        return (LayoutTabsViewModel) this.layoutTabsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PatternsViewModel getPatternsViewModel() {
        return (PatternsViewModel) this.patternsViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NLayoutBackgroundTabsFragmentBinding inflate = NLayoutBackgroundTabsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NLayoutBackgroundTabsFra…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ExtKt.disableTouch(root);
        NLayoutBackgroundTabsFragmentBinding nLayoutBackgroundTabsFragmentBinding = this.binding;
        if (nLayoutBackgroundTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nLayoutBackgroundTabsFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getLayoutBackgroundViewModel().setOnPropertyUpdatedListener(getLayoutTabsViewModel());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "viewLifecycleOwner.lifecycle");
        setAdapter(new LayoutBackgroundTabsAdapter(childFragmentManager, lifecycle));
        getLayoutTabsViewModel().onFrameStyleSet().observe(getViewLifecycleOwner(), new LayoutBackgroundTabsFragment$onViewCreated$1(this));
        getColorsViewModel().onSelectedColorChanged().observe(getViewLifecycleOwner(), new LayoutBackgroundTabsFragment$onViewCreated$2(this));
        getGradientsViewModel().onSelectedGradientChanged().observe(getViewLifecycleOwner(), new LayoutBackgroundTabsFragment$onViewCreated$3(this));
        getPatternsViewModel().onSelectedPatternChanged().observe(getViewLifecycleOwner(), new LayoutBackgroundTabsFragment$onViewCreated$4(this));
        getLayoutBackgroundViewModel().onSelectedBackgroundSet().observe(getViewLifecycleOwner(), new LayoutBackgroundTabsFragment$onViewCreated$5(this));
    }

    /* access modifiers changed from: private */
    public final void onColorSelected(LayerPaint.Color color) {
        if (color != null) {
            getGradientsViewModel().changeSelectedGradientPaint((LayerPaint.Gradient) null);
            getPatternsViewModel().changeSelectedPatternPaint((LayerPaint.Pattern) null);
            getLayoutBackgroundViewModel().selectBackground(color);
        }
    }

    /* access modifiers changed from: private */
    public final void onGradientSelected(LayerPaint.Gradient gradient) {
        if (gradient != null) {
            getColorsViewModel().changeSelectedColorPaint((LayerPaint.Color) null);
            getPatternsViewModel().changeSelectedPatternPaint((LayerPaint.Pattern) null);
            getLayoutBackgroundViewModel().selectBackground(gradient);
        }
    }

    /* access modifiers changed from: private */
    public final void onPatternSelected(LayerPaint.Pattern pattern) {
        if (pattern != null) {
            getColorsViewModel().changeSelectedColorPaint((LayerPaint.Color) null);
            getGradientsViewModel().changeSelectedGradientPaint((LayerPaint.Gradient) null);
            getLayoutBackgroundViewModel().selectBackground(pattern);
        }
    }

    private final void setAdapter(TabsSheetAdapter tabsSheetAdapter) {
        NLayoutBackgroundTabsFragmentBinding nLayoutBackgroundTabsFragmentBinding = this.binding;
        if (nLayoutBackgroundTabsFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager2 = nLayoutBackgroundTabsFragmentBinding.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.tabViewPager");
        viewPager2.setUserInputEnabled(false);
        NLayoutBackgroundTabsFragmentBinding nLayoutBackgroundTabsFragmentBinding2 = this.binding;
        if (nLayoutBackgroundTabsFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager2 viewPager22 = nLayoutBackgroundTabsFragmentBinding2.tabViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.tabViewPager");
        viewPager22.setAdapter(tabsSheetAdapter);
        if (tabsSheetAdapter != null) {
            NLayoutBackgroundTabsFragmentBinding nLayoutBackgroundTabsFragmentBinding3 = this.binding;
            if (nLayoutBackgroundTabsFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout = nLayoutBackgroundTabsFragmentBinding3.tabLayout;
            NLayoutBackgroundTabsFragmentBinding nLayoutBackgroundTabsFragmentBinding4 = this.binding;
            if (nLayoutBackgroundTabsFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            new TabLayoutMediator(tabLayout, nLayoutBackgroundTabsFragmentBinding4.tabViewPager, new LayoutBackgroundTabsFragment$setAdapter$1(tabsSheetAdapter)).attach();
        }
    }
}
