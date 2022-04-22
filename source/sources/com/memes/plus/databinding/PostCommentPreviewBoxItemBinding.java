package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostCommentPreviewItem;

public final class PostCommentPreviewBoxItemBinding implements ViewBinding {
    public final PostCommentPreviewItem firstCommentPreviewView;
    private final LinearLayout rootView;
    public final PostCommentPreviewItem secondCommentPreviewView;

    private PostCommentPreviewBoxItemBinding(LinearLayout linearLayout, PostCommentPreviewItem postCommentPreviewItem, PostCommentPreviewItem postCommentPreviewItem2) {
        this.rootView = linearLayout;
        this.firstCommentPreviewView = postCommentPreviewItem;
        this.secondCommentPreviewView = postCommentPreviewItem2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PostCommentPreviewBoxItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostCommentPreviewBoxItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_comment_preview_box_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostCommentPreviewBoxItemBinding bind(View view) {
        int i = C4199R.C4203id.first_comment_preview_view;
        PostCommentPreviewItem postCommentPreviewItem = (PostCommentPreviewItem) view.findViewById(C4199R.C4203id.first_comment_preview_view);
        if (postCommentPreviewItem != null) {
            i = C4199R.C4203id.second_comment_preview_view;
            PostCommentPreviewItem postCommentPreviewItem2 = (PostCommentPreviewItem) view.findViewById(C4199R.C4203id.second_comment_preview_view);
            if (postCommentPreviewItem2 != null) {
                return new PostCommentPreviewBoxItemBinding((LinearLayout) view, postCommentPreviewItem, postCommentPreviewItem2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
