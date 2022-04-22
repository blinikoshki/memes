package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class TaggedPostsFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    private final LinearLayout rootView;
    public final RecyclerView taggedPostsRecyclerView;
    public final SnippetTopBarLayoutBinding topBarLayout;

    private TaggedPostsFragmentBinding(LinearLayout linearLayout, ContentLayout contentLayout2, RecyclerView recyclerView, SnippetTopBarLayoutBinding snippetTopBarLayoutBinding) {
        this.rootView = linearLayout;
        this.contentLayout = contentLayout2;
        this.taggedPostsRecyclerView = recyclerView;
        this.topBarLayout = snippetTopBarLayoutBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TaggedPostsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TaggedPostsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.tagged_posts_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TaggedPostsFragmentBinding bind(View view) {
        int i = C4199R.C4203id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
        if (contentLayout2 != null) {
            i = C4199R.C4203id.tagged_posts_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.tagged_posts_recycler_view);
            if (recyclerView != null) {
                i = C4199R.C4203id.top_bar_layout;
                View findViewById = view.findViewById(C4199R.C4203id.top_bar_layout);
                if (findViewById != null) {
                    return new TaggedPostsFragmentBinding((LinearLayout) view, contentLayout2, recyclerView, SnippetTopBarLayoutBinding.bind(findViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
