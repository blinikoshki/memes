package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;
import editor.custom.valueslider.ValueSlider;
import editor.signature.views.SignaturePad;

public final class NSignatureActivityBinding implements ViewBinding {
    public final TextView brushColorLabelView;
    public final ValueSlider brushThicknessValueSlider;
    public final ImageView clearSignatureView;
    public final FragmentContainerView colorsContainer;
    public final CancelDoneFooter footer;
    private final LinearLayout rootView;
    public final TextView signatureHintView;
    public final SignaturePad signaturePad;

    private NSignatureActivityBinding(LinearLayout linearLayout, TextView textView, ValueSlider valueSlider, ImageView imageView, FragmentContainerView fragmentContainerView, CancelDoneFooter cancelDoneFooter, TextView textView2, SignaturePad signaturePad2) {
        this.rootView = linearLayout;
        this.brushColorLabelView = textView;
        this.brushThicknessValueSlider = valueSlider;
        this.clearSignatureView = imageView;
        this.colorsContainer = fragmentContainerView;
        this.footer = cancelDoneFooter;
        this.signatureHintView = textView2;
        this.signaturePad = signaturePad2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NSignatureActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NSignatureActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_signature_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NSignatureActivityBinding bind(View view) {
        int i = C4175R.C4179id.brush_color_label_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.brush_thickness_value_slider;
            ValueSlider valueSlider = (ValueSlider) view.findViewById(i);
            if (valueSlider != null) {
                i = C4175R.C4179id.clear_signature_view;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4175R.C4179id.colors_container;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
                    if (fragmentContainerView != null) {
                        i = C4175R.C4179id.footer;
                        CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
                        if (cancelDoneFooter != null) {
                            i = C4175R.C4179id.signature_hint_view;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = C4175R.C4179id.signature_pad;
                                SignaturePad signaturePad2 = (SignaturePad) view.findViewById(i);
                                if (signaturePad2 != null) {
                                    return new NSignatureActivityBinding((LinearLayout) view, textView, valueSlider, imageView, fragmentContainerView, cancelDoneFooter, textView2, signaturePad2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
