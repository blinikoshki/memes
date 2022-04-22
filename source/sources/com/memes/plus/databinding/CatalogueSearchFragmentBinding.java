package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.memes.plus.C4199R;

public final class CatalogueSearchFragmentBinding implements ViewBinding {
    public final ViewPager catalogueSearchViewPager;
    private final LinearLayout rootView;
    public final SnippetSearchBoxLayoutBinding searchBoxLayout;
    public final TabLayout searchTypeTabLayout;

    private CatalogueSearchFragmentBinding(LinearLayout linearLayout, ViewPager viewPager, SnippetSearchBoxLayoutBinding snippetSearchBoxLayoutBinding, TabLayout tabLayout) {
        this.rootView = linearLayout;
        this.catalogueSearchViewPager = viewPager;
        this.searchBoxLayout = snippetSearchBoxLayoutBinding;
        this.searchTypeTabLayout = tabLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CatalogueSearchFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueSearchFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_search_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueSearchFragmentBinding bind(View view) {
        int i = C4199R.C4203id.catalogue_search_view_pager;
        ViewPager viewPager = (ViewPager) view.findViewById(C4199R.C4203id.catalogue_search_view_pager);
        if (viewPager != null) {
            i = C4199R.C4203id.search_box_layout;
            View findViewById = view.findViewById(C4199R.C4203id.search_box_layout);
            if (findViewById != null) {
                SnippetSearchBoxLayoutBinding bind = SnippetSearchBoxLayoutBinding.bind(findViewById);
                TabLayout tabLayout = (TabLayout) view.findViewById(C4199R.C4203id.search_type_tab_layout);
                if (tabLayout != null) {
                    return new CatalogueSearchFragmentBinding((LinearLayout) view, viewPager, bind, tabLayout);
                }
                i = C4199R.C4203id.search_type_tab_layout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
