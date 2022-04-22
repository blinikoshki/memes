package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;

public final class NWatermarkImportBottomSheetBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final MaterialButton importButton;
    private final LinearLayout rootView;
    public final ImageView watermarkThumbnailView;

    private NWatermarkImportBottomSheetBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.importButton = materialButton2;
        this.watermarkThumbnailView = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NWatermarkImportBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWatermarkImportBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_watermark_import_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWatermarkImportBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(i);
        if (materialButton != null) {
            i = C4175R.C4179id.import_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
            if (materialButton2 != null) {
                i = C4175R.C4179id.watermark_thumbnail_view;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    return new NWatermarkImportBottomSheetBinding((LinearLayout) view, materialButton, materialButton2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
