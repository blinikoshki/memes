package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class ExportCatalogueSelectionActivityBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final LinearLayout rootView;
    public final SnippetSearchBoxLayoutBinding searchBoxLayout;

    private ExportCatalogueSelectionActivityBinding(LinearLayout linearLayout, FragmentContainerView fragmentContainerView, SnippetSearchBoxLayoutBinding snippetSearchBoxLayoutBinding) {
        this.rootView = linearLayout;
        this.fragmentContainer = fragmentContainerView;
        this.searchBoxLayout = snippetSearchBoxLayoutBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ExportCatalogueSelectionActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ExportCatalogueSelectionActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.export_catalogue_selection_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ExportCatalogueSelectionActivityBinding bind(View view) {
        int i = C4199R.C4203id.fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C4199R.C4203id.fragment_container);
        if (fragmentContainerView != null) {
            i = C4199R.C4203id.search_box_layout;
            View findViewById = view.findViewById(C4199R.C4203id.search_box_layout);
            if (findViewById != null) {
                return new ExportCatalogueSelectionActivityBinding((LinearLayout) view, fragmentContainerView, SnippetSearchBoxLayoutBinding.bind(findViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
