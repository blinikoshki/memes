package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;
import java.util.Objects;

public final class ChoiceDividerItemBinding implements ViewBinding {
    private final View rootView;

    private ChoiceDividerItemBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static ChoiceDividerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChoiceDividerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4144R.C4150layout.choice_divider_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChoiceDividerItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ChoiceDividerItemBinding(view);
    }
}
