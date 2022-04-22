package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview04Binding implements ViewBinding {
    public final Guideline guidelineHorizontal20;
    private final ItemSelectorView rootView;

    private NWireframePreview04Binding(ItemSelectorView itemSelectorView, Guideline guideline) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal20 = guideline;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview04Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview04Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_04, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview04Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_20;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            return new NWireframePreview04Binding((ItemSelectorView) view, guideline);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
