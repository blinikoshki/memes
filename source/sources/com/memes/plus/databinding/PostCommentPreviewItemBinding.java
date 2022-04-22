package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.plus.C4199R;

public final class PostCommentPreviewItemBinding implements ViewBinding {
    public final ImageView commentContentImageView;
    public final SocialTextView commentContentTextView;
    public final ImageView commentLikeImageView;
    public final TextView commentLikesCountTextView;
    public final ConstraintLayout commentPreviewRoot;
    private final ConstraintLayout rootView;

    private PostCommentPreviewItemBinding(ConstraintLayout constraintLayout, ImageView imageView, SocialTextView socialTextView, ImageView imageView2, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.commentContentImageView = imageView;
        this.commentContentTextView = socialTextView;
        this.commentLikeImageView = imageView2;
        this.commentLikesCountTextView = textView;
        this.commentPreviewRoot = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PostCommentPreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostCommentPreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_comment_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostCommentPreviewItemBinding bind(View view) {
        int i = C4199R.C4203id.comment_content_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.comment_content_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.comment_content_text_view;
            SocialTextView socialTextView = (SocialTextView) view.findViewById(C4199R.C4203id.comment_content_text_view);
            if (socialTextView != null) {
                i = C4199R.C4203id.comment_like_image_view;
                ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.comment_like_image_view);
                if (imageView2 != null) {
                    i = C4199R.C4203id.comment_likes_count_text_view;
                    TextView textView = (TextView) view.findViewById(C4199R.C4203id.comment_likes_count_text_view);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new PostCommentPreviewItemBinding(constraintLayout, imageView, socialTextView, imageView2, textView, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
