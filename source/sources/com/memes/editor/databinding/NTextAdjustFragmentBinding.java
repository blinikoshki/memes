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

public final class NTextAdjustFragmentBinding implements ViewBinding {
    public final CancelDoneFooter footer;
    public final TitleWithResetHeader header;
    public final ValueSlider opacitySlider;
    private final LinearLayout rootView;
    public final ValueSlider rotationSlider;
    public final ValueSlider scaleSlider;

    private NTextAdjustFragmentBinding(LinearLayout linearLayout, CancelDoneFooter cancelDoneFooter, TitleWithResetHeader titleWithResetHeader, ValueSlider valueSlider, ValueSlider valueSlider2, ValueSlider valueSlider3) {
        this.rootView = linearLayout;
        this.footer = cancelDoneFooter;
        this.header = titleWithResetHeader;
        this.opacitySlider = valueSlider;
        this.rotationSlider = valueSlider2;
        this.scaleSlider = valueSlider3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextAdjustFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextAdjustFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_adjust_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextAdjustFragmentBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
        if (cancelDoneFooter != null) {
            i = C4175R.C4179id.header;
            TitleWithResetHeader titleWithResetHeader = (TitleWithResetHeader) view.findViewById(i);
            if (titleWithResetHeader != null) {
                i = C4175R.C4179id.opacity_slider;
                ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
                if (valueSlider != null) {
                    i = C4175R.C4179id.rotation_slider;
                    ValueSlider valueSlider2 = (ValueSlider) view.findViewById(i);
                    if (valueSlider2 != null) {
                        i = C4175R.C4179id.scale_slider;
                        ValueSlider valueSlider3 = (ValueSlider) view.findViewById(i);
                        if (valueSlider3 != null) {
                            return new NTextAdjustFragmentBinding((LinearLayout) view, cancelDoneFooter, titleWithResetHeader, valueSlider, valueSlider2, valueSlider3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
