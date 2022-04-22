package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NMediaCategorySuggestionItemBinding implements ViewBinding {
    public final ImageView iconView;
    private final LinearLayout rootView;
    public final TextView textView;

    private NMediaCategorySuggestionItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        this.rootView = linearLayout;
        this.iconView = imageView;
        this.textView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NMediaCategorySuggestionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaCategorySuggestionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_category_suggestion_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaCategorySuggestionItemBinding bind(View view) {
        int i = C4175R.C4179id.icon_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.text_view;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new NMediaCategorySuggestionItemBinding((LinearLayout) view, imageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
