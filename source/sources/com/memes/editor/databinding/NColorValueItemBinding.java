package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NColorValueItemBinding implements ViewBinding {
    public final ImageView customizeColorView;
    private final ConstraintLayout rootView;

    private NColorValueItemBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.customizeColorView = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NColorValueItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NColorValueItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_color_value_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NColorValueItemBinding bind(View view) {
        int i = C4175R.C4179id.customize_color_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            return new NColorValueItemBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
