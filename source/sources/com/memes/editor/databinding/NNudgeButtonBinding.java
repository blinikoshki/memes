package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NNudgeButtonBinding implements ViewBinding {
    private final ImageView rootView;

    private NNudgeButtonBinding(ImageView imageView) {
        this.rootView = imageView;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static NNudgeButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NNudgeButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_nudge_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NNudgeButtonBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NNudgeButtonBinding((ImageView) view);
    }
}
