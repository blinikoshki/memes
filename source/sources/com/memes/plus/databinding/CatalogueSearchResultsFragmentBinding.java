package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class CatalogueSearchResultsFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    private final ContentLayout rootView;
    public final RecyclerView searchResultsRecyclerView;

    private CatalogueSearchResultsFragmentBinding(ContentLayout contentLayout2, ContentLayout contentLayout3, RecyclerView recyclerView) {
        this.rootView = contentLayout2;
        this.contentLayout = contentLayout3;
        this.searchResultsRecyclerView = recyclerView;
    }

    public ContentLayout getRoot() {
        return this.rootView;
    }

    public static CatalogueSearchResultsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueSearchResultsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_search_results_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueSearchResultsFragmentBinding bind(View view) {
        ContentLayout contentLayout2 = (ContentLayout) view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.search_results_recycler_view);
        if (recyclerView != null) {
            return new CatalogueSearchResultsFragmentBinding(contentLayout2, contentLayout2, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C4199R.C4203id.search_results_recycler_view)));
    }
}
