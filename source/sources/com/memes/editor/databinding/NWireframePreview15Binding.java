package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview15Binding implements ViewBinding {
    public final Guideline guidelineHorizontal80;
    public final Guideline guidelineVertical30;
    private final ItemSelectorView rootView;

    private NWireframePreview15Binding(ItemSelectorView itemSelectorView, Guideline guideline, Guideline guideline2) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal80 = guideline;
        this.guidelineVertical30 = guideline2;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview15Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview15Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_15, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview15Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_80;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_vertical_30;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                return new NWireframePreview15Binding((ItemSelectorView) view, guideline, guideline2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
