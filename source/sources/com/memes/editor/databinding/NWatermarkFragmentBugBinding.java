package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CloseOnlyFooter;

public final class NWatermarkFragmentBugBinding implements ViewBinding {
    public final CloseOnlyFooter footer;
    private final LinearLayout rootView;
    public final AppCompatImageView watermarkLogoOptionView;
    public final AppCompatImageView watermarkSavedOptionView;
    public final AppCompatImageView watermarkSignatureOptionView;
    public final SwitchCompat watermarkSwitch;
    public final AppCompatImageView watermarkTextOptionView;

    private NWatermarkFragmentBugBinding(LinearLayout linearLayout, CloseOnlyFooter closeOnlyFooter, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, SwitchCompat switchCompat, AppCompatImageView appCompatImageView4) {
        this.rootView = linearLayout;
        this.footer = closeOnlyFooter;
        this.watermarkLogoOptionView = appCompatImageView;
        this.watermarkSavedOptionView = appCompatImageView2;
        this.watermarkSignatureOptionView = appCompatImageView3;
        this.watermarkSwitch = switchCompat;
        this.watermarkTextOptionView = appCompatImageView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NWatermarkFragmentBugBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWatermarkFragmentBugBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_watermark_fragment_bug, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWatermarkFragmentBugBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CloseOnlyFooter closeOnlyFooter = (CloseOnlyFooter) view.findViewById(i);
        if (closeOnlyFooter != null) {
            i = C4175R.C4179id.watermark_logo_option_view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
            if (appCompatImageView != null) {
                i = C4175R.C4179id.watermark_saved_option_view;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(i);
                if (appCompatImageView2 != null) {
                    i = C4175R.C4179id.watermark_signature_option_view;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(i);
                    if (appCompatImageView3 != null) {
                        i = C4175R.C4179id.watermark_switch;
                        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(i);
                        if (switchCompat != null) {
                            i = C4175R.C4179id.watermark_text_option_view;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(i);
                            if (appCompatImageView4 != null) {
                                return new NWatermarkFragmentBugBinding((LinearLayout) view, closeOnlyFooter, appCompatImageView, appCompatImageView2, appCompatImageView3, switchCompat, appCompatImageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
