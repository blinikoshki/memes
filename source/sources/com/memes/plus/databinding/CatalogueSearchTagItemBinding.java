package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class CatalogueSearchTagItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView searchResultTagImageView;
    public final TextView searchResultTagNameTextView;
    public final TextView searchResultTagPostsTextView;

    private CatalogueSearchTagItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.searchResultTagImageView = imageView;
        this.searchResultTagNameTextView = textView;
        this.searchResultTagPostsTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CatalogueSearchTagItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueSearchTagItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_search_tag_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueSearchTagItemBinding bind(View view) {
        int i = C4199R.C4203id.search_result_tag_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.search_result_tag_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.search_result_tag_name_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.search_result_tag_name_text_view);
            if (textView != null) {
                i = C4199R.C4203id.search_result_tag_posts_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.search_result_tag_posts_text_view);
                if (textView2 != null) {
                    return new CatalogueSearchTagItemBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
