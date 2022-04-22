package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.editor.C4175R;
import editor.extra.NicoRatioFrameLayout;

public final class NCustomFrameSizeBottomSheetBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final MaterialButton doneButton;
    public final FrameLayout frameSizePreviewContainer;
    public final NicoRatioFrameLayout frameSizePreviewView;
    public final TextInputEditText heightEditText;
    private final LinearLayout rootView;
    public final TextView sizeErrorTextView;
    public final TextInputEditText widthEditText;

    private NCustomFrameSizeBottomSheetBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, FrameLayout frameLayout, NicoRatioFrameLayout nicoRatioFrameLayout, TextInputEditText textInputEditText, TextView textView, TextInputEditText textInputEditText2) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.doneButton = materialButton2;
        this.frameSizePreviewContainer = frameLayout;
        this.frameSizePreviewView = nicoRatioFrameLayout;
        this.heightEditText = textInputEditText;
        this.sizeErrorTextView = textView;
        this.widthEditText = textInputEditText2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NCustomFrameSizeBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCustomFrameSizeBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_custom_frame_size_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCustomFrameSizeBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(i);
        if (materialButton != null) {
            i = C4175R.C4179id.done_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                i = C4175R.C4179id.frame_size_preview_container;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                if (frameLayout != null) {
                    i = C4175R.C4179id.frame_size_preview_view;
                    NicoRatioFrameLayout nicoRatioFrameLayout = (NicoRatioFrameLayout) view.findViewById(i);
                    if (nicoRatioFrameLayout != null) {
                        i = C4175R.C4179id.height_edit_text;
                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(i);
                        if (textInputEditText != null) {
                            i = C4175R.C4179id.size_error_text_view;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C4175R.C4179id.width_edit_text;
                                TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(i);
                                if (textInputEditText2 != null) {
                                    return new NCustomFrameSizeBottomSheetBinding((LinearLayout) view, materialButton, materialButton2, frameLayout, nicoRatioFrameLayout, textInputEditText, textView, textInputEditText2);
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
