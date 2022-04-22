package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;

public final class NWireframePreview22Binding implements ViewBinding {
    public final Guideline guidelineHorizontal20;
    public final Guideline guidelineHorizontal40;
    public final Guideline guidelineHorizontal60;
    public final Guideline guidelineHorizontal80;
    public final Guideline guidelineVertical40;
    private final ItemSelectorView rootView;

    private NWireframePreview22Binding(ItemSelectorView itemSelectorView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5) {
        this.rootView = itemSelectorView;
        this.guidelineHorizontal20 = guideline;
        this.guidelineHorizontal40 = guideline2;
        this.guidelineHorizontal60 = guideline3;
        this.guidelineHorizontal80 = guideline4;
        this.guidelineVertical40 = guideline5;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_22, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview22Binding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_20;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_horizontal_40;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                i = C4175R.C4179id.guideline_horizontal_60;
                Guideline guideline3 = (Guideline) view.findViewById(i);
                if (guideline3 != null) {
                    i = C4175R.C4179id.guideline_horizontal_80;
                    Guideline guideline4 = (Guideline) view.findViewById(i);
                    if (guideline4 != null) {
                        i = C4175R.C4179id.guideline_vertical_40;
                        Guideline guideline5 = (Guideline) view.findViewById(i);
                        if (guideline5 != null) {
                            return new NWireframePreview22Binding((ItemSelectorView) view, guideline, guideline2, guideline3, guideline4, guideline5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
