package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class PostsTabFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final CoordinatorLayout coordinatorLayout;
    public final RecyclerView postsRecyclerView;
    private final CoordinatorLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;

    private PostsTabFragmentBinding(CoordinatorLayout coordinatorLayout2, ContentLayout contentLayout2, CoordinatorLayout coordinatorLayout3, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.rootView = coordinatorLayout2;
        this.contentLayout = contentLayout2;
        this.coordinatorLayout = coordinatorLayout3;
        this.postsRecyclerView = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static PostsTabFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostsTabFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.posts_tab_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostsTabFragmentBinding bind(View view) {
        int i = C4199R.C4203id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
        if (contentLayout2 != null) {
            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) view;
            i = C4199R.C4203id.posts_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.posts_recycler_view);
            if (recyclerView != null) {
                i = C4199R.C4203id.swipe_refresh_layout;
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) view.findViewById(C4199R.C4203id.swipe_refresh_layout);
                if (swipeRefreshLayout2 != null) {
                    return new PostsTabFragmentBinding(coordinatorLayout2, contentLayout2, coordinatorLayout2, recyclerView, swipeRefreshLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
