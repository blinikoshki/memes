package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NTextFontDividerItemBinding implements ViewBinding {
    private final View rootView;

    private NTextFontDividerItemBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NTextFontDividerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextFontDividerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_font_divider_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextFontDividerItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NTextFontDividerItemBinding(view);
    }
}
