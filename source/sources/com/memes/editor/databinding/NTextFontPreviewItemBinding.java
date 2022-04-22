package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NTextFontPreviewItemBinding implements ViewBinding {
    public final TextView fontPreviewTextView;
    public final View premiumFontIndicatorView;
    private final FrameLayout rootView;

    private NTextFontPreviewItemBinding(FrameLayout frameLayout, TextView textView, View view) {
        this.rootView = frameLayout;
        this.fontPreviewTextView = textView;
        this.premiumFontIndicatorView = view;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static NTextFontPreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextFontPreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_font_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.memes.editor.C4175R.C4179id.premium_font_indicator_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NTextFontPreviewItemBinding bind(android.view.View r3) {
        /*
            int r0 = com.memes.editor.C4175R.C4179id.font_preview_text_view
            android.view.View r1 = r3.findViewById(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x001a
            int r0 = com.memes.editor.C4175R.C4179id.premium_font_indicator_view
            android.view.View r2 = r3.findViewById(r0)
            if (r2 == 0) goto L_0x001a
            com.memes.editor.databinding.NTextFontPreviewItemBinding r0 = new com.memes.editor.databinding.NTextFontPreviewItemBinding
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NTextFontPreviewItemBinding.bind(android.view.View):com.memes.editor.databinding.NTextFontPreviewItemBinding");
    }
}
