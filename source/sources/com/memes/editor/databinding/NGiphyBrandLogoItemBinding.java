package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NGiphyBrandLogoItemBinding implements ViewBinding {
    private final LinearLayout rootView;

    private NGiphyBrandLogoItemBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NGiphyBrandLogoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NGiphyBrandLogoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_giphy_brand_logo_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NGiphyBrandLogoItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NGiphyBrandLogoItemBinding((LinearLayout) view);
    }
}
