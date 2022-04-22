package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NBasicFilterPreviewItemBinding implements ViewBinding {
    public final ImageView iconImageView;
    public final LinearLayout iconImageViewLayout;
    private final ConstraintLayout rootView;
    public final TextView titleTextView;

    private NBasicFilterPreviewItemBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.iconImageView = imageView;
        this.iconImageViewLayout = linearLayout;
        this.titleTextView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NBasicFilterPreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NBasicFilterPreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_basic_filter_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NBasicFilterPreviewItemBinding bind(View view) {
        int i = C4175R.C4179id.icon_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.icon_image_view_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                i = C4175R.C4179id.title_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new NBasicFilterPreviewItemBinding((ConstraintLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
