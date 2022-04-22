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

public final class NTextSpacingFragmentBinding implements ViewBinding {
    public final CancelDoneFooter footer;
    public final TitleWithResetHeader header;
    public final ValueSlider letterSpacingSlider;
    public final ValueSlider lineSpacingSlider;
    private final LinearLayout rootView;

    private NTextSpacingFragmentBinding(LinearLayout linearLayout, CancelDoneFooter cancelDoneFooter, TitleWithResetHeader titleWithResetHeader, ValueSlider valueSlider, ValueSlider valueSlider2) {
        this.rootView = linearLayout;
        this.footer = cancelDoneFooter;
        this.header = titleWithResetHeader;
        this.letterSpacingSlider = valueSlider;
        this.lineSpacingSlider = valueSlider2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextSpacingFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextSpacingFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_spacing_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextSpacingFragmentBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
        if (cancelDoneFooter != null) {
            i = C4175R.C4179id.header;
            TitleWithResetHeader titleWithResetHeader = (TitleWithResetHeader) view.findViewById(i);
            if (titleWithResetHeader != null) {
                i = C4175R.C4179id.letter_spacing_slider;
                ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
                if (valueSlider != null) {
                    i = C4175R.C4179id.line_spacing_slider;
                    ValueSlider valueSlider2 = (ValueSlider) view.findViewById(i);
                    if (valueSlider2 != null) {
                        return new NTextSpacingFragmentBinding((LinearLayout) view, cancelDoneFooter, titleWithResetHeader, valueSlider, valueSlider2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
