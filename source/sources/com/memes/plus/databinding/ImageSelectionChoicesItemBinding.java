package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class ImageSelectionChoicesItemBinding implements ViewBinding {
    private final CheckedTextView rootView;
    public final CheckedTextView text1;

    private ImageSelectionChoicesItemBinding(CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = checkedTextView;
        this.text1 = checkedTextView2;
    }

    public CheckedTextView getRoot() {
        return this.rootView;
    }

    public static ImageSelectionChoicesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ImageSelectionChoicesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.image_selection_choices_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ImageSelectionChoicesItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        CheckedTextView checkedTextView = (CheckedTextView) view;
        return new ImageSelectionChoicesItemBinding(checkedTextView, checkedTextView);
    }
}
