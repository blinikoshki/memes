package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;
import editor.mediaselection.items.MediaSelectionItemView;

public final class NMediaSelectionItemPreviewBottomSheetBinding implements ViewBinding {
    public final MediaSelectionItemView mediaSelectionItemView;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final LinearLayout rootView;

    private NMediaSelectionItemPreviewBottomSheetBinding(LinearLayout linearLayout, MediaSelectionItemView mediaSelectionItemView2, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.mediaSelectionItemView = mediaSelectionItemView2;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NMediaSelectionItemPreviewBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaSelectionItemPreviewBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_selection_item_preview_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaSelectionItemPreviewBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.media_selection_item_view;
        MediaSelectionItemView mediaSelectionItemView2 = (MediaSelectionItemView) view.findViewById(i);
        if (mediaSelectionItemView2 != null) {
            i = C4175R.C4179id.negative_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(i);
            if (materialButton != null) {
                i = C4175R.C4179id.positive_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
                if (materialButton2 != null) {
                    return new NMediaSelectionItemPreviewBottomSheetBinding((LinearLayout) view, mediaSelectionItemView2, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
