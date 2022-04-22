package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;
import editor.tools.crop.lib.CropImageView;

public final class NCropActivityBinding implements ViewBinding {
    public final CropImageView cropImageView;
    public final RecyclerView cropOptionsRecyclerView;
    public final CancelDoneFooter footer;
    public final ImageView resetSelectionView;
    private final LinearLayout rootView;

    private NCropActivityBinding(LinearLayout linearLayout, CropImageView cropImageView2, RecyclerView recyclerView, CancelDoneFooter cancelDoneFooter, ImageView imageView) {
        this.rootView = linearLayout;
        this.cropImageView = cropImageView2;
        this.cropOptionsRecyclerView = recyclerView;
        this.footer = cancelDoneFooter;
        this.resetSelectionView = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NCropActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NCropActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_crop_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NCropActivityBinding bind(View view) {
        int i = C4175R.C4179id.crop_image_view;
        CropImageView cropImageView2 = (CropImageView) view.findViewById(i);
        if (cropImageView2 != null) {
            i = C4175R.C4179id.crop_options_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            if (recyclerView != null) {
                i = C4175R.C4179id.footer;
                CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
                if (cancelDoneFooter != null) {
                    i = C4175R.C4179id.reset_selection_view;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        return new NCropActivityBinding((LinearLayout) view, cropImageView2, recyclerView, cancelDoneFooter, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
