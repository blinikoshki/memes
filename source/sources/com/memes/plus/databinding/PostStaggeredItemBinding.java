package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.plus.C4199R;

public final class PostStaggeredItemBinding implements ViewBinding {
    public final SnippetPostMediaProgressBarBinding includedMediaProgressLayout;
    public final RoundedImageView postContentImageView;
    public final ImageView postContentTypeView;
    public final AspectRatioFrameLayout postMediaContainer;
    private final AspectRatioFrameLayout rootView;

    private PostStaggeredItemBinding(AspectRatioFrameLayout aspectRatioFrameLayout, SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding, RoundedImageView roundedImageView, ImageView imageView, AspectRatioFrameLayout aspectRatioFrameLayout2) {
        this.rootView = aspectRatioFrameLayout;
        this.includedMediaProgressLayout = snippetPostMediaProgressBarBinding;
        this.postContentImageView = roundedImageView;
        this.postContentTypeView = imageView;
        this.postMediaContainer = aspectRatioFrameLayout2;
    }

    public AspectRatioFrameLayout getRoot() {
        return this.rootView;
    }

    public static PostStaggeredItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostStaggeredItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_staggered_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostStaggeredItemBinding bind(View view) {
        int i = C4199R.C4203id.included_media_progress_layout;
        View findViewById = view.findViewById(C4199R.C4203id.included_media_progress_layout);
        if (findViewById != null) {
            SnippetPostMediaProgressBarBinding bind = SnippetPostMediaProgressBarBinding.bind(findViewById);
            i = C4199R.C4203id.post_content_image_view;
            RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(C4199R.C4203id.post_content_image_view);
            if (roundedImageView != null) {
                i = C4199R.C4203id.post_content_type_view;
                ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.post_content_type_view);
                if (imageView != null) {
                    AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) view;
                    return new PostStaggeredItemBinding(aspectRatioFrameLayout, bind, roundedImageView, imageView, aspectRatioFrameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
