package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.mediacategoryview.MediaCategoryView;

public final class NEditorEntrySelectionActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final MediaCategoryView draftsCategoryView;
    public final MediaCategoryView frameSizesCategoryView;
    private final LinearLayout rootView;
    public final MediaCategoryView templatesCategoryView;
    public final FrameLayout topbar;
    public final MediaCategoryView wireframesCategoryView;

    private NEditorEntrySelectionActivityBinding(LinearLayout linearLayout, ImageView imageView, MediaCategoryView mediaCategoryView, MediaCategoryView mediaCategoryView2, MediaCategoryView mediaCategoryView3, FrameLayout frameLayout, MediaCategoryView mediaCategoryView4) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.draftsCategoryView = mediaCategoryView;
        this.frameSizesCategoryView = mediaCategoryView2;
        this.templatesCategoryView = mediaCategoryView3;
        this.topbar = frameLayout;
        this.wireframesCategoryView = mediaCategoryView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NEditorEntrySelectionActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NEditorEntrySelectionActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_editor_entry_selection_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NEditorEntrySelectionActivityBinding bind(View view) {
        int i = C4175R.C4179id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.drafts_category_view;
            MediaCategoryView mediaCategoryView = (MediaCategoryView) view.findViewById(i);
            if (mediaCategoryView != null) {
                i = C4175R.C4179id.frame_sizes_category_view;
                MediaCategoryView mediaCategoryView2 = (MediaCategoryView) view.findViewById(i);
                if (mediaCategoryView2 != null) {
                    i = C4175R.C4179id.templates_category_view;
                    MediaCategoryView mediaCategoryView3 = (MediaCategoryView) view.findViewById(i);
                    if (mediaCategoryView3 != null) {
                        i = C4175R.C4179id.topbar;
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                        if (frameLayout != null) {
                            i = C4175R.C4179id.wireframes_category_view;
                            MediaCategoryView mediaCategoryView4 = (MediaCategoryView) view.findViewById(i);
                            if (mediaCategoryView4 != null) {
                                return new NEditorEntrySelectionActivityBinding((LinearLayout) view, imageView, mediaCategoryView, mediaCategoryView2, mediaCategoryView3, frameLayout, mediaCategoryView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
