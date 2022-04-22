package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.C4175R;

public final class NLocalMediaSelectionItemBinding implements ViewBinding {
    public final ImageView mediaView;
    private final AspectRatioFrameLayout rootView;
    public final View selectionIndicator;
    public final ImageView videoView;

    private NLocalMediaSelectionItemBinding(AspectRatioFrameLayout aspectRatioFrameLayout, ImageView imageView, View view, ImageView imageView2) {
        this.rootView = aspectRatioFrameLayout;
        this.mediaView = imageView;
        this.selectionIndicator = view;
        this.videoView = imageView2;
    }

    public AspectRatioFrameLayout getRoot() {
        return this.rootView;
    }

    public static NLocalMediaSelectionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NLocalMediaSelectionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_local_media_selection_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.memes.editor.C4175R.C4179id.selection_indicator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NLocalMediaSelectionItemBinding bind(android.view.View r4) {
        /*
            int r0 = com.memes.editor.C4175R.C4179id.media_view
            android.view.View r1 = r4.findViewById(r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.memes.editor.C4175R.C4179id.selection_indicator
            android.view.View r2 = r4.findViewById(r0)
            if (r2 == 0) goto L_0x0024
            int r0 = com.memes.editor.C4175R.C4179id.video_view
            android.view.View r3 = r4.findViewById(r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x0024
            com.memes.editor.databinding.NLocalMediaSelectionItemBinding r0 = new com.memes.editor.databinding.NLocalMediaSelectionItemBinding
            com.memes.commons.aspectratio.AspectRatioFrameLayout r4 = (com.memes.commons.aspectratio.AspectRatioFrameLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NLocalMediaSelectionItemBinding.bind(android.view.View):com.memes.editor.databinding.NLocalMediaSelectionItemBinding");
    }
}
