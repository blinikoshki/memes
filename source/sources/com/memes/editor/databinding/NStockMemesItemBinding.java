package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.C4175R;

public final class NStockMemesItemBinding implements ViewBinding {
    public final AspectRatioFrameLayout aspectRatioFrameLayout;
    public final ImageView imageView;
    private final AspectRatioFrameLayout rootView;
    public final View selectionIndicator;

    private NStockMemesItemBinding(AspectRatioFrameLayout aspectRatioFrameLayout2, AspectRatioFrameLayout aspectRatioFrameLayout3, ImageView imageView2, View view) {
        this.rootView = aspectRatioFrameLayout2;
        this.aspectRatioFrameLayout = aspectRatioFrameLayout3;
        this.imageView = imageView2;
        this.selectionIndicator = view;
    }

    public AspectRatioFrameLayout getRoot() {
        return this.rootView;
    }

    public static NStockMemesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NStockMemesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_stock_memes_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.memes.editor.C4175R.C4179id.selection_indicator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NStockMemesItemBinding bind(android.view.View r4) {
        /*
            r0 = r4
            com.memes.commons.aspectratio.AspectRatioFrameLayout r0 = (com.memes.commons.aspectratio.AspectRatioFrameLayout) r0
            int r1 = com.memes.editor.C4175R.C4179id.image_view
            android.view.View r2 = r4.findViewById(r1)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x001b
            int r1 = com.memes.editor.C4175R.C4179id.selection_indicator
            android.view.View r3 = r4.findViewById(r1)
            if (r3 == 0) goto L_0x001b
            com.memes.editor.databinding.NStockMemesItemBinding r4 = new com.memes.editor.databinding.NStockMemesItemBinding
            r4.<init>(r0, r0, r2, r3)
            return r4
        L_0x001b:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r1)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NStockMemesItemBinding.bind(android.view.View):com.memes.editor.databinding.NStockMemesItemBinding");
    }
}
