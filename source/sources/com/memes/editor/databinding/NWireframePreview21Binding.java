package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview21Binding implements ViewBinding {
    public final Guideline guidelineHorizontal33;
    public final Guideline guidelineHorizontal66;
    public final Guideline guidelineVertical40;
    private final ItemSelectorView rootView;

    private NWireframePreview21Binding(ItemSelectorView itemSelectorView, Guideline guideline, Guideline guideline2, Guideline guideline3) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal33 = guideline;
        this.guidelineHorizontal66 = guideline2;
        this.guidelineVertical40 = guideline3;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview21Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview21Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_21, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview21Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_33;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_horizontal_66;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                i = C4175R.C4179id.guideline_vertical_40;
                Guideline guideline3 = (Guideline) view.findViewById(i);
                if (guideline3 != null) {
                    return new NWireframePreview21Binding((ItemSelectorView) view, guideline, guideline2, guideline3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
