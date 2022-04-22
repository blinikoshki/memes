package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview08Binding implements ViewBinding {
    public final Guideline guidelineHorizontal20;
    public final Guideline guidelineHorizontal80;
    private final ItemSelectorView rootView;

    private NWireframePreview08Binding(ItemSelectorView itemSelectorView, Guideline guideline, Guideline guideline2) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal20 = guideline;
        this.guidelineHorizontal80 = guideline2;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview08Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview08Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_08, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview08Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_20;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_horizontal_80;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                return new NWireframePreview08Binding((ItemSelectorView) view, guideline, guideline2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
