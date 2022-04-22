package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.slider.Slider;
import com.memes.editor.C4175R;

public final class NCustomValueSliderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Slider slider;
    public final TextView titleTextView;

    private NCustomValueSliderBinding(LinearLayout linearLayout, Slider slider2, TextView textView) {
        this.rootView = linearLayout;
        this.slider = slider2;
        this.titleTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NCustomValueSliderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCustomValueSliderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_custom_value_slider, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCustomValueSliderBinding bind(View view) {
        int i = C4175R.C4179id.slider;
        Slider slider2 = (Slider) view.findViewById(i);
        if (slider2 != null) {
            i = C4175R.C4179id.title_text_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new NCustomValueSliderBinding((LinearLayout) view, slider2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
