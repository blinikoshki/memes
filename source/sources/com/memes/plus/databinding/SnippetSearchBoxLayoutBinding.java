package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class SnippetSearchBoxLayoutBinding implements ViewBinding {
    public final TextView copyrightTextView;
    private final LinearLayout rootView;
    public final LinearLayout searchBoxLayout;
    public final EditText searchEditText;
    public final ImageView searchInputCancelImageView;

    private SnippetSearchBoxLayoutBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, EditText editText, ImageView imageView) {
        this.rootView = linearLayout;
        this.copyrightTextView = textView;
        this.searchBoxLayout = linearLayout2;
        this.searchEditText = editText;
        this.searchInputCancelImageView = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SnippetSearchBoxLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SnippetSearchBoxLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.snippet_search_box_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SnippetSearchBoxLayoutBinding bind(View view) {
        int i = C4199R.C4203id.copyright_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.copyright_text_view);
        if (textView != null) {
            i = C4199R.C4203id.search_box_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.search_box_layout);
            if (linearLayout != null) {
                i = C4199R.C4203id.search_edit_text;
                EditText editText = (EditText) view.findViewById(C4199R.C4203id.search_edit_text);
                if (editText != null) {
                    i = C4199R.C4203id.search_input_cancel_image_view;
                    ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.search_input_cancel_image_view);
                    if (imageView != null) {
                        return new SnippetSearchBoxLayoutBinding((LinearLayout) view, textView, linearLayout, editText, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
