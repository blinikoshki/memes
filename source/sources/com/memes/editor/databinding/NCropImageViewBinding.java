package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.tools.crop.lib.CropOverlayView;
import java.util.Objects;

public final class NCropImageViewBinding implements ViewBinding {
    public final CropOverlayView CropOverlayView;
    public final ProgressBar CropProgressBar;
    public final ImageView ImageViewImage;
    private final View rootView;

    private NCropImageViewBinding(View view, CropOverlayView cropOverlayView, ProgressBar progressBar, ImageView imageView) {
        this.rootView = view;
        this.CropOverlayView = cropOverlayView;
        this.CropProgressBar = progressBar;
        this.ImageViewImage = imageView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NCropImageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4175R.C4181layout.n_crop_image_view, viewGroup);
        return bind(viewGroup);
    }

    public static NCropImageViewBinding bind(View view) {
        int i = C4175R.C4179id.CropOverlayView;
        CropOverlayView cropOverlayView = (CropOverlayView) view.findViewById(i);
        if (cropOverlayView != null) {
            i = C4175R.C4179id.CropProgressBar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(i);
            if (progressBar != null) {
                i = C4175R.C4179id.ImageView_image;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    return new NCropImageViewBinding(view, cropOverlayView, progressBar, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
