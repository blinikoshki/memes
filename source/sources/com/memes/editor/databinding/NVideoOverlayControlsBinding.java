package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NVideoOverlayControlsBinding implements ViewBinding {
    public final ImageButton exoPause;
    public final ImageButton exoPlay;
    private final FrameLayout rootView;

    private NVideoOverlayControlsBinding(FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2) {
        this.rootView = frameLayout;
        this.exoPause = imageButton;
        this.exoPlay = imageButton2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static NVideoOverlayControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NVideoOverlayControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_video_overlay_controls, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NVideoOverlayControlsBinding bind(View view) {
        int i = C4175R.C4179id.exo_pause;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C4175R.C4179id.exo_play;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                return new NVideoOverlayControlsBinding((FrameLayout) view, imageButton, imageButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
