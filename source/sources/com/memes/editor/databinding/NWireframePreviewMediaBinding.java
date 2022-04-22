package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NWireframePreviewMediaBinding implements ViewBinding {
    public final Guideline guidelineHorizontal30;
    public final Guideline guidelineHorizontal70;
    public final Guideline guidelineVertical30;
    public final Guideline guidelineVertical70;
    private final ConstraintLayout rootView;

    private NWireframePreviewMediaBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.guidelineHorizontal30 = guideline;
        this.guidelineHorizontal70 = guideline2;
        this.guidelineVertical30 = guideline3;
        this.guidelineVertical70 = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NWireframePreviewMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreviewMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreviewMediaBinding bind(View view) {
        int i = C4175R.C4179id.guideline_horizontal_30;
        Guideline guideline = (Guideline) view.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.guideline_horizontal_70;
            Guideline guideline2 = (Guideline) view.findViewById(i);
            if (guideline2 != null) {
                i = C4175R.C4179id.guideline_vertical_30;
                Guideline guideline3 = (Guideline) view.findViewById(i);
                if (guideline3 != null) {
                    i = C4175R.C4179id.guideline_vertical_70;
                    Guideline guideline4 = (Guideline) view.findViewById(i);
                    if (guideline4 != null) {
                        return new NWireframePreviewMediaBinding((ConstraintLayout) view, guideline, guideline2, guideline3, guideline4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
