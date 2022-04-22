package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NResizeFrameDividerItemBinding implements ViewBinding {
    private final View rootView;

    private NResizeFrameDividerItemBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NResizeFrameDividerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NResizeFrameDividerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_resize_frame_divider_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NResizeFrameDividerItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NResizeFrameDividerItemBinding(view);
    }
}
