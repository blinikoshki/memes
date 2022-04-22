package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NSavedWatermarkItemBinding implements ViewBinding {
    public final ImageView deleteWatermarkView;
    private final ConstraintLayout rootView;
    public final ImageView thumbnailImageView;

    private NSavedWatermarkItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.deleteWatermarkView = imageView;
        this.thumbnailImageView = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NSavedWatermarkItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NSavedWatermarkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_saved_watermark_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NSavedWatermarkItemBinding bind(View view) {
        int i = C4175R.C4179id.delete_watermark_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.thumbnail_image_view;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                return new NSavedWatermarkItemBinding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
