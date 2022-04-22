package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview17Binding implements ViewBinding {
    public final Guideline guidelineHorizontal20;
    public final Guideline guidelineVertical50;
    private final ItemSelectorView rootView;

    private NWireframePreview17Binding(ItemSelectorView itemSelectorView, Guideline guideline, Guideline guideline2) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal20 = guideline;
        this.guidelineVertical50 = guideline2;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview17Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview17Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_17, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview17Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_20;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_vertical_50;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                return new NWireframePreview17Binding((ItemSelectorView) view, guideline, guideline2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
