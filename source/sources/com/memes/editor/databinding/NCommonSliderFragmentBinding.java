package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;
import editor.common.sheetheader.TitleWithResetHeader;
import editor.custom.valueslider.ValueSlider;

public final class NCommonSliderFragmentBinding implements ViewBinding {
    public final CancelDoneFooter footer;
    public final TitleWithResetHeader header;
    private final LinearLayout rootView;
    public final ValueSlider slider;

    private NCommonSliderFragmentBinding(LinearLayout linearLayout, CancelDoneFooter cancelDoneFooter, TitleWithResetHeader titleWithResetHeader, ValueSlider valueSlider) {
        this.rootView = linearLayout;
        this.footer = cancelDoneFooter;
        this.header = titleWithResetHeader;
        this.slider = valueSlider;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NCommonSliderFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCommonSliderFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_common_slider_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCommonSliderFragmentBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
        if (cancelDoneFooter != null) {
            i = C4175R.C4179id.header;
            TitleWithResetHeader titleWithResetHeader = (TitleWithResetHeader) view.findViewById(i);
            if (titleWithResetHeader != null) {
                i = C4175R.C4179id.slider;
                ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
                if (valueSlider != null) {
                    return new NCommonSliderFragmentBinding((LinearLayout) view, cancelDoneFooter, titleWithResetHeader, valueSlider);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
