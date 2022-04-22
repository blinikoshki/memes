package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NWireframePreviewItemBinding implements ViewBinding {
    public final View background;
    public final ImageView previewImageView;
    private final ConstraintLayout rootView;

    private NWireframePreviewItemBinding(ConstraintLayout constraintLayout, View view, ImageView imageView) {
        this.rootView = constraintLayout;
        this.background = view;
        this.previewImageView = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NWireframePreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreviewItemBinding bind(View view) {
        int i = C4175R.C4179id.background;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            i = C4175R.C4179id.preview_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                return new NWireframePreviewItemBinding((ConstraintLayout) view, findViewById, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
