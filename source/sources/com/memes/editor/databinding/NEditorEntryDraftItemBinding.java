package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.C4175R;

public final class NEditorEntryDraftItemBinding implements ViewBinding {
    public final AspectRatioFrameLayout aspectRatioFrameLayout;
    private final AspectRatioFrameLayout rootView;
    public final ImageView thumbnailImageView;

    private NEditorEntryDraftItemBinding(AspectRatioFrameLayout aspectRatioFrameLayout2, AspectRatioFrameLayout aspectRatioFrameLayout3, ImageView imageView) {
        this.rootView = aspectRatioFrameLayout2;
        this.aspectRatioFrameLayout = aspectRatioFrameLayout3;
        this.thumbnailImageView = imageView;
    }

    public AspectRatioFrameLayout getRoot() {
        return this.rootView;
    }

    public static NEditorEntryDraftItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NEditorEntryDraftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_editor_entry_draft_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NEditorEntryDraftItemBinding bind(View view) {
        AspectRatioFrameLayout aspectRatioFrameLayout2 = (AspectRatioFrameLayout) view;
        int i = C4175R.C4179id.thumbnail_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            return new NEditorEntryDraftItemBinding(aspectRatioFrameLayout2, aspectRatioFrameLayout2, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
