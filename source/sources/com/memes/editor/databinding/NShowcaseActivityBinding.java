package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.trash.ColorAdjustSheet;

public final class NShowcaseActivityBinding implements ViewBinding {
    public final ColorAdjustSheet colorAdjustSliderSheet;
    private final ConstraintLayout rootView;

    private NShowcaseActivityBinding(ConstraintLayout constraintLayout, ColorAdjustSheet colorAdjustSheet) {
        this.rootView = constraintLayout;
        this.colorAdjustSliderSheet = colorAdjustSheet;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NShowcaseActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NShowcaseActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_showcase_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NShowcaseActivityBinding bind(View view) {
        int i = C4175R.C4179id.color_adjust_slider_sheet;
        ColorAdjustSheet colorAdjustSheet = (ColorAdjustSheet) view.findViewById(i);
        if (colorAdjustSheet != null) {
            return new NShowcaseActivityBinding((ConstraintLayout) view, colorAdjustSheet);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
