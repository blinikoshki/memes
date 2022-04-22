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

public final class SocialNotificationsTabFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final SnippetTopBarLayoutBinding includedTopBar;
    public final RecyclerView notificationsRecyclerView;
    private final LinearLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;

    private SocialNotificationsTabFragmentBinding(LinearLayout linearLayout, ContentLayout contentLayout2, SnippetTopBarLayoutBinding snippetTopBarLayoutBinding, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.rootView = linearLayout;
        this.contentLayout = contentLayout2;
        this.includedTopBar = snippetTopBarLayoutBinding;
        this.notificationsRecyclerView = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SocialNotificationsTabFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SocialNotificationsTabFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.social_notifications_tab_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialNotificationsTabFragmentBinding bind(View view) {
        int i = C4199R.C4203id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
        if (contentLayout2 != null) {
            i = C4199R.C4203id.included_top_bar;
            View findViewById = view.findViewById(C4199R.C4203id.included_top_bar);
            if (findViewById != null) {
                SnippetTopBarLayoutBinding bind = SnippetTopBarLayoutBinding.bind(findViewById);
                i = C4199R.C4203id.notifications_recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.notifications_recycler_view);
                if (recyclerView != null) {
                    i = C4199R.C4203id.swipe_refresh_layout;
                    SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) view.findViewById(C4199R.C4203id.swipe_refresh_layout);
                    if (swipeRefreshLayout2 != null) {
                        return new SocialNotificationsTabFragmentBinding((LinearLayout) view, contentLayout2, bind, recyclerView, swipeRefreshLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
