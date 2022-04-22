package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class SavedHashTagItemBinding implements ViewBinding {
    public final ImageView deleteImageView;
    public final TextView hashTagTextView;
    private final LinearLayout rootView;

    private SavedHashTagItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.deleteImageView = imageView;
        this.hashTagTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SavedHashTagItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SavedHashTagItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.saved_hash_tag_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SavedHashTagItemBinding bind(View view) {
        int i = C4199R.C4203id.delete_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.delete_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.hash_tag_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.hash_tag_text_view);
            if (textView != null) {
                return new SavedHashTagItemBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
