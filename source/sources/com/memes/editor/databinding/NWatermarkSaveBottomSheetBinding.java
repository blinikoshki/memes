package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;

public final class NWatermarkSaveBottomSheetBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    private final LinearLayout rootView;
    public final MaterialButton saveButton;

    private NWatermarkSaveBottomSheetBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.saveButton = materialButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NWatermarkSaveBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWatermarkSaveBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_watermark_save_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWatermarkSaveBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(i);
        if (materialButton != null) {
            i = C4175R.C4179id.save_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                return new NWatermarkSaveBottomSheetBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
