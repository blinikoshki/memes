package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class SnippetSearchBoxMaskLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout searchMaskLayout;

    private SnippetSearchBoxMaskLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.searchMaskLayout = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SnippetSearchBoxMaskLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SnippetSearchBoxMaskLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.snippet_search_box_mask_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SnippetSearchBoxMaskLayoutBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        LinearLayout linearLayout = (LinearLayout) view;
        return new SnippetSearchBoxMaskLayoutBinding(linearLayout, linearLayout);
    }
}
