package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NDraftItemBinding implements ViewBinding {
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final ImageView thumbnailImageView;

    private NDraftItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.root = constraintLayout2;
        this.thumbnailImageView = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NDraftItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NDraftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_draft_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NDraftItemBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C4175R.C4179id.thumbnail_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            return new NDraftItemBinding(constraintLayout, constraintLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
