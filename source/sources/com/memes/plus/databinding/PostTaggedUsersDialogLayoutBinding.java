package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class PostTaggedUsersDialogLayoutBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final TextView hideDialogView;
    private final FrameLayout rootView;
    public final RecyclerView tagsRecyclerView;

    private PostTaggedUsersDialogLayoutBinding(FrameLayout frameLayout, ContentLayout contentLayout2, TextView textView, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.contentLayout = contentLayout2;
        this.hideDialogView = textView;
        this.tagsRecyclerView = recyclerView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PostTaggedUsersDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostTaggedUsersDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_tagged_users_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostTaggedUsersDialogLayoutBinding bind(View view) {
        int i = C4199R.C4203id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
        if (contentLayout2 != null) {
            i = C4199R.C4203id.hide_dialog_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.hide_dialog_view);
            if (textView != null) {
                i = C4199R.C4203id.tags_recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.tags_recycler_view);
                if (recyclerView != null) {
                    return new PostTaggedUsersDialogLayoutBinding((FrameLayout) view, contentLayout2, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
