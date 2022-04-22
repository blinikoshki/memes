package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NCropOptionPreviewItemBinding implements ViewBinding {
    public final View background;
    public final ImageView iconImageView;
    private final ConstraintLayout rootView;
    public final TextView titleTextView;

    private NCropOptionPreviewItemBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.background = view;
        this.iconImageView = imageView;
        this.titleTextView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NCropOptionPreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCropOptionPreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_crop_option_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCropOptionPreviewItemBinding bind(View view) {
        int i = C4175R.C4179id.background;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            i = C4175R.C4179id.icon_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4175R.C4179id.title_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new NCropOptionPreviewItemBinding((ConstraintLayout) view, findViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
