package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NGradientValueItemBinding implements ViewBinding {
    public final ImageView gradientImageView;
    public final View gradientSelectionView;
    private final CardView rootView;

    private NGradientValueItemBinding(CardView cardView, ImageView imageView, View view) {
        this.rootView = cardView;
        this.gradientImageView = imageView;
        this.gradientSelectionView = view;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static NGradientValueItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NGradientValueItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_gradient_value_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.memes.editor.C4175R.C4179id.gradient_selection_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NGradientValueItemBinding bind(android.view.View r3) {
        /*
            int r0 = com.memes.editor.C4175R.C4179id.gradient_image_view
            android.view.View r1 = r3.findViewById(r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x001a
            int r0 = com.memes.editor.C4175R.C4179id.gradient_selection_view
            android.view.View r2 = r3.findViewById(r0)
            if (r2 == 0) goto L_0x001a
            com.memes.editor.databinding.NGradientValueItemBinding r0 = new com.memes.editor.databinding.NGradientValueItemBinding
            androidx.cardview.widget.CardView r3 = (androidx.cardview.widget.CardView) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001a:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NGradientValueItemBinding.bind(android.view.View):com.memes.editor.databinding.NGradientValueItemBinding");
    }
}
