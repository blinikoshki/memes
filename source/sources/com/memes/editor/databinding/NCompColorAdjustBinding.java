package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.colorshadeselector.ColorShadeSelector;
import editor.custom.valueslider.ValueSlider;

public final class NCompColorAdjustBinding implements ViewBinding {
    public final ValueSlider opacitySlider;
    private final LinearLayout rootView;
    public final ColorShadeSelector shadeSelector;

    private NCompColorAdjustBinding(LinearLayout linearLayout, ValueSlider valueSlider, ColorShadeSelector colorShadeSelector) {
        this.rootView = linearLayout;
        this.opacitySlider = valueSlider;
        this.shadeSelector = colorShadeSelector;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NCompColorAdjustBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCompColorAdjustBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_comp_color_adjust, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCompColorAdjustBinding bind(View view) {
        int i = C4175R.C4179id.opacity_slider;
        ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
        if (valueSlider != null) {
            i = C4175R.C4179id.shade_selector;
            ColorShadeSelector colorShadeSelector = (ColorShadeSelector) view.findViewById(i);
            if (colorShadeSelector != null) {
                return new NCompColorAdjustBinding((LinearLayout) view, valueSlider, colorShadeSelector);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
