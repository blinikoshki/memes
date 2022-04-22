package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class SnippetTopBarLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final View topBarBackDummyView;
    public final ImageView topBarBackImageView;
    public final LinearLayout topBarLayout;
    public final TextView topBarTitleTextView;

    private SnippetTopBarLayoutBinding(LinearLayout linearLayout, View view, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.topBarBackDummyView = view;
        this.topBarBackImageView = imageView;
        this.topBarLayout = linearLayout2;
        this.topBarTitleTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SnippetTopBarLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SnippetTopBarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.snippet_top_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SnippetTopBarLayoutBinding bind(View view) {
        int i = C4199R.C4203id.top_bar_back_dummy_view;
        View findViewById = view.findViewById(C4199R.C4203id.top_bar_back_dummy_view);
        if (findViewById != null) {
            i = C4199R.C4203id.top_bar_back_image_view;
            ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.top_bar_back_image_view);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = C4199R.C4203id.top_bar_title_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.top_bar_title_text_view);
                if (textView != null) {
                    return new SnippetTopBarLayoutBinding(linearLayout, findViewById, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
