package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.C4175R;

public final class NTemplateItemBinding implements ViewBinding {
    public final AspectRatioFrameLayout aspectRatioFrameLayout;
    public final ImageView imageView;
    private final AspectRatioFrameLayout rootView;

    private NTemplateItemBinding(AspectRatioFrameLayout aspectRatioFrameLayout2, AspectRatioFrameLayout aspectRatioFrameLayout3, ImageView imageView2) {
        this.rootView = aspectRatioFrameLayout2;
        this.aspectRatioFrameLayout = aspectRatioFrameLayout3;
        this.imageView = imageView2;
    }

    public AspectRatioFrameLayout getRoot() {
        return this.rootView;
    }

    public static NTemplateItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTemplateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_template_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTemplateItemBinding bind(View view) {
        AspectRatioFrameLayout aspectRatioFrameLayout2 = (AspectRatioFrameLayout) view;
        int i = C4175R.C4179id.image_view;
        ImageView imageView2 = (ImageView) view.findViewById(i);
        if (imageView2 != null) {
            return new NTemplateItemBinding(aspectRatioFrameLayout2, aspectRatioFrameLayout2, imageView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
