package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class PostFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final SnippetTopBarLayoutBinding includedTopBar;
    public final RecyclerView postAndCommentsRecyclerView;
    private final LinearLayout rootView;

    private PostFragmentBinding(LinearLayout linearLayout, ContentLayout contentLayout2, SnippetTopBarLayoutBinding snippetTopBarLayoutBinding, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.contentLayout = contentLayout2;
        this.includedTopBar = snippetTopBarLayoutBinding;
        this.postAndCommentsRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PostFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostFragmentBinding bind(View view) {
        int i = C4199R.C4203id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
        if (contentLayout2 != null) {
            i = C4199R.C4203id.included_top_bar;
            View findViewById = view.findViewById(C4199R.C4203id.included_top_bar);
            if (findViewById != null) {
                SnippetTopBarLayoutBinding bind = SnippetTopBarLayoutBinding.bind(findViewById);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.post_and_comments_recycler_view);
                if (recyclerView != null) {
                    return new PostFragmentBinding((LinearLayout) view, contentLayout2, bind, recyclerView);
                }
                i = C4199R.C4203id.post_and_comments_recycler_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
