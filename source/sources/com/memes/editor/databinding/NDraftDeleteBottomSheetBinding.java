package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;

public final class NDraftDeleteBottomSheetBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final MaterialButton deleteButton;
    private final LinearLayout rootView;

    private NDraftDeleteBottomSheetBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.deleteButton = materialButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NDraftDeleteBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NDraftDeleteBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_draft_delete_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NDraftDeleteBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(i);
        if (materialButton != null) {
            i = C4175R.C4179id.delete_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                return new NDraftDeleteBottomSheetBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
