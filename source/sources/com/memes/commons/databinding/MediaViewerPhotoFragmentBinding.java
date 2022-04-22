package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;
import java.util.Objects;

public final class MediaViewerPhotoFragmentBinding implements ViewBinding {
    public final ImageView photoView;
    private final ImageView rootView;

    private MediaViewerPhotoFragmentBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.photoView = imageView2;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static MediaViewerPhotoFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MediaViewerPhotoFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4144R.C4150layout.media_viewer_photo_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MediaViewerPhotoFragmentBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ImageView imageView = (ImageView) view;
        return new MediaViewerPhotoFragmentBinding(imageView, imageView);
    }
}
