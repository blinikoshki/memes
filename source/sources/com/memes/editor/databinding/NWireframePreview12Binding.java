package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.ItemSelectorView;
import java.util.Objects;

public final class NWireframePreview12Binding implements ViewBinding {
    private final ItemSelectorView rootView;

    private NWireframePreview12Binding(ItemSelectorView itemSelectorView) {
        this.rootView = itemSelectorView;
    }

    public ItemSelectorView getRoot() {
        return this.rootView;
    }

    public static NWireframePreview12Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframePreview12Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframe_preview_12, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframePreview12Binding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new NWireframePreview12Binding((ItemSelectorView) view);
    }
}
