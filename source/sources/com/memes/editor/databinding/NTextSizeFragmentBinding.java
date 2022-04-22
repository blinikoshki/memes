package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.valueslider.ValueSlider;

public final class NTextSizeFragmentBinding implements ViewBinding {
    public final SwitchCompat autoTextSizeSwitch;
    private final LinearLayout rootView;
    public final ValueSlider textSizeSlider;

    private NTextSizeFragmentBinding(LinearLayout linearLayout, SwitchCompat switchCompat, ValueSlider valueSlider) {
        this.rootView = linearLayout;
        this.autoTextSizeSwitch = switchCompat;
        this.textSizeSlider = valueSlider;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextSizeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextSizeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_size_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextSizeFragmentBinding bind(View view) {
        int i = C4175R.C4179id.auto_text_size_switch;
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(i);
        if (switchCompat != null) {
            i = C4175R.C4179id.text_size_slider;
            ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
            if (valueSlider != null) {
                return new NTextSizeFragmentBinding((LinearLayout) view, switchCompat, valueSlider);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
