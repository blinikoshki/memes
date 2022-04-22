package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NBlankFragmentBinding implements ViewBinding {
    private final View rootView;

    private NBlankFragmentBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NBlankFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NBlankFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_blank_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NBlankFragmentBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NBlankFragmentBinding(view);
    }
}
