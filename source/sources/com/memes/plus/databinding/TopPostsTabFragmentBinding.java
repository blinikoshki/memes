package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class TopPostsTabFragmentBinding implements ViewBinding {
    public final SnippetSearchBoxMaskLayoutBinding includedSearchBoxMaskLayout;
    private final LinearLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final ContentLayout topPostsContentLayout;
    public final RecyclerView topPostsRecyclerView;

    private TopPostsTabFragmentBinding(LinearLayout linearLayout, SnippetSearchBoxMaskLayoutBinding snippetSearchBoxMaskLayoutBinding, SwipeRefreshLayout swipeRefreshLayout2, ContentLayout contentLayout, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.includedSearchBoxMaskLayout = snippetSearchBoxMaskLayoutBinding;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.topPostsContentLayout = contentLayout;
        this.topPostsRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TopPostsTabFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TopPostsTabFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.top_posts_tab_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TopPostsTabFragmentBinding bind(View view) {
        int i = C4199R.C4203id.included_search_box_mask_layout;
        View findViewById = view.findViewById(C4199R.C4203id.included_search_box_mask_layout);
        if (findViewById != null) {
            SnippetSearchBoxMaskLayoutBinding bind = SnippetSearchBoxMaskLayoutBinding.bind(findViewById);
            i = C4199R.C4203id.swipe_refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) view.findViewById(C4199R.C4203id.swipe_refresh_layout);
            if (swipeRefreshLayout2 != null) {
                i = C4199R.C4203id.top_posts_content_layout;
                ContentLayout contentLayout = (ContentLayout) view.findViewById(C4199R.C4203id.top_posts_content_layout);
                if (contentLayout != null) {
                    i = C4199R.C4203id.top_posts_recycler_view;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.top_posts_recycler_view);
                    if (recyclerView != null) {
                        return new TopPostsTabFragmentBinding((LinearLayout) view, bind, swipeRefreshLayout2, contentLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
