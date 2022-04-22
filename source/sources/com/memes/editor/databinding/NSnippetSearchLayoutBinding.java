package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NSnippetSearchLayoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout searchBoxLayout;
    public final EditText searchEditText;
    public final ImageView searchImageView;
    public final ImageView searchInputCancelImageView;

    private NSnippetSearchLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.searchBoxLayout = constraintLayout2;
        this.searchEditText = editText;
        this.searchImageView = imageView;
        this.searchInputCancelImageView = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NSnippetSearchLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NSnippetSearchLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_snippet_search_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NSnippetSearchLayoutBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C4175R.C4179id.search_edit_text;
        EditText editText = (EditText) view.findViewById(i);
        if (editText != null) {
            i = C4175R.C4179id.search_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4175R.C4179id.search_input_cancel_image_view;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    return new NSnippetSearchLayoutBinding(constraintLayout, constraintLayout, editText, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
