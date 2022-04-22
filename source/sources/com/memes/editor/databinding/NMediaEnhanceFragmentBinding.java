package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.optionbutton.SmallOptionButton;

public final class NMediaEnhanceFragmentBinding implements ViewBinding {
    public final SmallOptionButton brightnessOptionView;
    public final SmallOptionButton contrastOptionView;
    public final SmallOptionButton pixelationOptionView;
    private final HorizontalScrollView rootView;
    public final SmallOptionButton saturationOptionView;
    public final SmallOptionButton sharpnessOptionView;

    private NMediaEnhanceFragmentBinding(HorizontalScrollView horizontalScrollView, SmallOptionButton smallOptionButton, SmallOptionButton smallOptionButton2, SmallOptionButton smallOptionButton3, SmallOptionButton smallOptionButton4, SmallOptionButton smallOptionButton5) {
        this.rootView = horizontalScrollView;
        this.brightnessOptionView = smallOptionButton;
        this.contrastOptionView = smallOptionButton2;
        this.pixelationOptionView = smallOptionButton3;
        this.saturationOptionView = smallOptionButton4;
        this.sharpnessOptionView = smallOptionButton5;
    }

    public HorizontalScrollView getRoot() {
        return this.rootView;
    }

    public static NMediaEnhanceFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaEnhanceFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_enhance_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaEnhanceFragmentBinding bind(View view) {
        int i = C4175R.C4179id.brightness_option_view;
        SmallOptionButton smallOptionButton = (SmallOptionButton) view.findViewById(i);
        if (smallOptionButton != null) {
            i = C4175R.C4179id.contrast_option_view;
            SmallOptionButton smallOptionButton2 = (SmallOptionButton) view.findViewById(i);
            if (smallOptionButton2 != null) {
                i = C4175R.C4179id.pixelation_option_view;
                SmallOptionButton smallOptionButton3 = (SmallOptionButton) view.findViewById(i);
                if (smallOptionButton3 != null) {
                    i = C4175R.C4179id.saturation_option_view;
                    SmallOptionButton smallOptionButton4 = (SmallOptionButton) view.findViewById(i);
                    if (smallOptionButton4 != null) {
                        i = C4175R.C4179id.sharpness_option_view;
                        SmallOptionButton smallOptionButton5 = (SmallOptionButton) view.findViewById(i);
                        if (smallOptionButton5 != null) {
                            return new NMediaEnhanceFragmentBinding((HorizontalScrollView) view, smallOptionButton, smallOptionButton2, smallOptionButton3, smallOptionButton4, smallOptionButton5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
