package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NCropOptionDividerItemBinding implements ViewBinding {
    private final View rootView;

    private NCropOptionDividerItemBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NCropOptionDividerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCropOptionDividerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_crop_option_divider_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCropOptionDividerItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NCropOptionDividerItemBinding(view);
    }
}
