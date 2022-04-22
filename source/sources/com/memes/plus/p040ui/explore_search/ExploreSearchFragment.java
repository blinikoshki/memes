package com.memes.plus.p040ui.explore_search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.App;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.databinding.CatalogueSearchFragmentBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/ExploreSearchFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/CatalogueSearchFragmentBinding;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "()V", "explorePagerAdapter", "Lcom/memes/plus/ui/explore_search/ExplorePagerAdapter;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBindingComplete", "", "savedInstanceState", "Landroid/os/Bundle;", "onSearchQueryChanged", "query", "", "onSearchRequested", "closeKeyboard", "", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.ExploreSearchFragment */
/* compiled from: ExploreSearchFragment.kt */
public final class ExploreSearchFragment extends BaseFragment<CatalogueSearchFragmentBinding> implements TabLayout.OnTabSelectedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CatalogueSearchFragment";
    private ExplorePagerAdapter explorePagerAdapter;

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/ExploreSearchFragment$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.ExploreSearchFragment$Companion */
    /* compiled from: ExploreSearchFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CatalogueSearchFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        CatalogueSearchFragmentBinding inflate = CatalogueSearchFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "CatalogueSearchFragmentB…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ExplorePagerAdapter explorePagerAdapter2 = new ExplorePagerAdapter(childFragmentManager);
        ViewPager viewPager = ((CatalogueSearchFragmentBinding) getBinding()).catalogueSearchViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "getBinding().catalogueSearchViewPager");
        viewPager.setAdapter(explorePagerAdapter2);
        Unit unit = Unit.INSTANCE;
        this.explorePagerAdapter = explorePagerAdapter2;
        ((CatalogueSearchFragmentBinding) getBinding()).searchTypeTabLayout.setupWithViewPager(((CatalogueSearchFragmentBinding) getBinding()).catalogueSearchViewPager);
        ((CatalogueSearchFragmentBinding) getBinding()).searchTypeTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        ((CatalogueSearchFragmentBinding) getBinding()).searchBoxLayout.searchInputCancelImageView.setOnClickListener(new ExploreSearchFragment$onBindingComplete$2(this));
        EditText editText = ((CatalogueSearchFragmentBinding) getBinding()).searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "getBinding().searchBoxLayout.searchEditText");
        editText.addTextChangedListener(new C4257x393922e6(this));
        ((CatalogueSearchFragmentBinding) getBinding()).searchBoxLayout.searchEditText.setOnEditorActionListener(new ExploreSearchFragment$onBindingComplete$4(this));
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText2 = ((CatalogueSearchFragmentBinding) getBinding()).searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "getBinding().searchBoxLayout.searchEditText");
        softKeyboardUtil.showKeyboard(editText2);
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        ImageView imageView = ((CatalogueSearchFragmentBinding) getBinding()).searchBoxLayout.searchInputCancelImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "getBinding().searchBoxLa…earchInputCancelImageView");
        CharSequence charSequence = str;
        imageView.setVisibility(((charSequence.length() == 0) || StringsKt.isBlank(charSequence)) ? 8 : 0);
        onSearchRequested(str, false);
    }

    static /* synthetic */ void onSearchRequested$default(ExploreSearchFragment exploreSearchFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        exploreSearchFragment.onSearchRequested(str, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (kotlin.text.StringsKt.isBlank(r0) == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onSearchRequested(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x0016
            com.memes.commons.util.SoftKeyboardUtil r5 = com.memes.commons.util.SoftKeyboardUtil.INSTANCE
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            com.memes.plus.databinding.CatalogueSearchFragmentBinding r0 = (com.memes.plus.databinding.CatalogueSearchFragmentBinding) r0
            com.memes.plus.databinding.SnippetSearchBoxLayoutBinding r0 = r0.searchBoxLayout
            android.widget.EditText r0 = r0.searchEditText
            java.lang.String r1 = "getBinding().searchBoxLayout.searchEditText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5.hideKeyboard((android.widget.EditText) r0)
        L_0x0016:
            r5 = 0
            if (r4 == 0) goto L_0x002d
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 != 0) goto L_0x002d
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x002e
        L_0x002d:
            r4 = 0
        L_0x002e:
            r0 = 2
        L_0x002f:
            if (r5 >= r0) goto L_0x004a
            com.memes.plus.ui.explore_search.ExplorePagerAdapter r1 = r3.explorePagerAdapter
            if (r1 != 0) goto L_0x003a
            java.lang.String r2 = "explorePagerAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x003a:
            androidx.fragment.app.Fragment r1 = r1.getItem(r5)
            boolean r2 = r1 instanceof com.memes.plus.base.upgrades.Searchable
            if (r2 == 0) goto L_0x0047
            com.memes.plus.base.upgrades.Searchable r1 = (com.memes.plus.base.upgrades.Searchable) r1
            r1.search(r4)
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x002f
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.ExploreSearchFragment.onSearchRequested(java.lang.String, boolean):void");
    }

    public void onTabSelected(TabLayout.Tab tab) {
        Integer valueOf = tab != null ? Integer.valueOf(tab.getPosition()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            App.Companion.trackingManager().onExplorePeopleTabTapped();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            App.Companion.trackingManager().onExploreTagsTabTapped();
        }
    }
}
